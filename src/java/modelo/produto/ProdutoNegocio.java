/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.produto;

import java.util.List;

/**
 *
 * @author helder
 */
public class ProdutoNegocio {

    public boolean inserir(int id, String descricao, double preco, int categoria_id) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.inserir(id, descricao, preco, categoria_id);
    }

    public boolean alterar(int id, String descricao, double preco, int categoria_id) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.alterar(id, descricao, preco, categoria_id);
    }

    public boolean excluir(int id) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.excluir(id);
    }
    
    public Produto obterProduto(int id) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.obterProduto(id);
    }

    public List<Produto> obterTodos() {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.obterTodos();
    }
}
