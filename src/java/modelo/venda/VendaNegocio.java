/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.venda;

import java.util.List;
import modelo.carrinho.CarrinhoItem;
import modelo.venda_produto.VendaProdutoNegocio;

/**
 *
 * @author heldercosta
 *
 * Classe de negócio que encapsula as regras de negócio das vendas
 */
public class VendaNegocio {
    
    public boolean inserir(String data, String login, List<CarrinhoItem> resultado) {
        
        int id = proximoId(); // obtem id no banco da próxima venda
        
        VendaDAO dao = new VendaDAO();
        if(id == -1 || !dao.inserir(id, data, login)) { return false; } // caso não consiga cadastrar uma nova venda ele retorna false sem precisar excluir nada
        boolean sucessoVendaProduto;
        VendaProdutoNegocio vendaProdutoNegocio = new VendaProdutoNegocio();
        for(CarrinhoItem produto : resultado) {
            sucessoVendaProduto = vendaProdutoNegocio.inserir(id, produto.getProduto().getId(), produto.getQuantidade());
            if(!sucessoVendaProduto) { // caso dê algum erro, são excluidas todas as vendas
                for(CarrinhoItem p : resultado) {
                    vendaProdutoNegocio.excluir(id, p.getProduto().getId());
                }
                return false;
            }
        }
        return true;
    }

    public boolean alterar(int id, String data, String login) {
        VendaDAO dao = new VendaDAO();
        return dao.alterar(id, data, login);
    }

    public boolean excluir(int id) {
        VendaDAO dao = new VendaDAO();
        return dao.excluir(id);
    }
    
    public Venda obterVenda(int id) {
        VendaDAO dao = new VendaDAO();
        return dao.obterVenda(id);
    }

    public List<Venda> obterTodosPorLogin(String login) {
        VendaDAO dao = new VendaDAO();
        return dao.obterTodosPorLogin(login);
    }
    
    public int proximoId() {
        VendaDAO dao = new VendaDAO();
        return dao.proximoId();
    }
    
}
