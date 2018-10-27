/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */

package modelo.carrinho;

import java.util.ArrayList;
import java.util.List;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author heldercosta
 * 
 * Classe que representa as ações de manipulações de carrinho de compras
 */
public class CarrinhoNegocio {

    private static final String SEPARADOR_REGISTRO = "id=";
    private static final String SEPARADOR_CAMPOS = "qtd=";
 
    /**
     * Método utilizado para adicionar um novo produto ou atualizar o existente,
     * retornando a String que representa o cookie atualizada
     *
     * @param cookieValor
     * @param produtoId
     * @param quantidade
     * @return
     */
    public String inserirProduto(String cookieValor, int produtoId, int quantidade) {
        if (cookieValor == null || cookieValor.trim().length() == 0) {
            return produtoId + SEPARADOR_CAMPOS + quantidade;
        }
        if (existeProduto(cookieValor, produtoId)) {
            if (!cookieValor.contains(SEPARADOR_REGISTRO)) { // só existe um produto
                cookieValor = produtoId + SEPARADOR_CAMPOS + quantidade;
            } else { // existe mais de um produto
                String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
                cookieValor = "";
                for (String p : produtos) {
                    String[] produto = p.split(SEPARADOR_CAMPOS);
                    if (cookieValor.trim().length() > 0) {
                        cookieValor = cookieValor + SEPARADOR_REGISTRO;
                    }
                    if (Integer.parseInt(produto[0]) == produtoId) {
                        cookieValor = cookieValor + (produtoId + SEPARADOR_CAMPOS + quantidade);
                    } else {
                        cookieValor = cookieValor + (Integer.parseInt(produto[0]) + SEPARADOR_CAMPOS + Integer.parseInt(produto[1]));
                    }
                }
            }
        } else {
            cookieValor = cookieValor + SEPARADOR_REGISTRO + (produtoId + SEPARADOR_CAMPOS + quantidade);
        }
        return cookieValor;
    }

    /**
     * Método utilizado para remover um produto existente, retornando a String
     * que representa o cookie atualizada
     *
     * @param cookieValor
     * @param produtoId
     * @return
     */
    public String removerProduto(String cookieValor, int produtoId) {
        if (cookieValor == null || cookieValor.trim().length() == 0) {
            return "";
        }
        if (existeProduto(cookieValor, produtoId)) {
            if (!cookieValor.contains(SEPARADOR_REGISTRO)) { // só existe um produto
                cookieValor = "";
            } else { // existe mais de um produto
                String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
                cookieValor = "";
                for (String p : produtos) {
                    if (p.equals("")) { continue; } // Após mudar formato do cookie (para id= e qtd=), o primeiro elemento do carrinho sempre é vazio.
                    String[] produto = p.split(SEPARADOR_CAMPOS);
                    if (cookieValor.trim().length() > 0) {
                        cookieValor = cookieValor + SEPARADOR_REGISTRO;
                    }
                    if (Integer.parseInt(produto[0]) != produtoId) {
                        cookieValor = cookieValor + (Integer.parseInt(produto[0]) + SEPARADOR_CAMPOS + Integer.parseInt(produto[1]));
                    }
                }
            }
        }
        return cookieValor;
    }

    /**
     * Método utilizado para verificar se o produto existe
     *
     * @param cookieValor
     * @param produtoId
     * @return
     */
    public boolean existeProduto(String cookieValor, int produtoId) {
        if (cookieValor == null || cookieValor.trim().length() == 0) {
            return false;
        }
        String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
        if (produtos == null || produtos.length == 0) {
            produtos = new String[]{cookieValor};
        }
        for (String p : produtos) {
            if (p.equals("")) { continue; } // Após mudar formato do cookie (para id= e qtd=), o primeiro elemento do carrinho sempre é vazio.
            String[] produto = p.split(SEPARADOR_CAMPOS);
            if (Integer.parseInt(produto[0]) == produtoId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método utilizado para recuperar todos os itens do carrinho de compras
     *
     * @param cookieValor
     * @return
     */
    public List<CarrinhoItem> obterProdutos(String cookieValor) {
        if (cookieValor == null || cookieValor.trim().length() == 0) {
            return new ArrayList<CarrinhoItem>();
        }
        List<CarrinhoItem> resultado = new ArrayList<CarrinhoItem>();
        String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
        if (produtos == null || produtos.length == 0) {
            produtos = new String[]{cookieValor};
        }
        ProdutoNegocio produtoNegocio = new ProdutoNegocio();
        for (String p : produtos) {
            if (p.equals("")) { continue; } // Após mudar formato do cookie (para id= e qtd=), o primeiro elemento do carrinho sempre é vazio.
            String[] produto = p.split(SEPARADOR_CAMPOS);
            CarrinhoItem carrinhoItem = new CarrinhoItem();
            carrinhoItem.setProduto(produtoNegocio.obterProduto(Integer.parseInt(produto[0])));
            carrinhoItem.setQuantidade(Integer.parseInt(produto[1]));
            resultado.add(carrinhoItem);
        }
        return resultado;
    }
    
}
