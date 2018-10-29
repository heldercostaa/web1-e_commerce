/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.venda_produto;

import java.util.List;

/**
 *
 * @author heldercosta
 * 
 * Classe de negócio que encapsula as regras de negócio dos relacionamentos de
 * vendas e produtos
 */
public class VendaProdutoNegocio {
    
    public boolean inserir(int venda_id, int id_produto, int quantidade) {
        VendaProdutoDAO dao = new VendaProdutoDAO();
        return dao.inserir(venda_id, id_produto, quantidade);
    }

    public boolean alterar(int venda_id, int id_produto, int quantidade) {
        VendaProdutoDAO dao = new VendaProdutoDAO();
        return dao.alterar(venda_id, id_produto, quantidade);
    }

    public boolean excluir(int venda_id, int produto_id) {
        VendaProdutoDAO dao = new VendaProdutoDAO();
        return dao.excluir(venda_id, produto_id);
    }
    
    public VendaProduto obterVendaProduto(int venda_id, int produto_id) {
        VendaProdutoDAO dao = new VendaProdutoDAO();
        return dao.obterVendaProduto(venda_id, produto_id);
    }

    public List<VendaProduto> obterTodosPorVenda(int id) {
        VendaProdutoDAO dao = new VendaProdutoDAO();
        return dao.obterTodosPorVenda(id);
    }
    
}
