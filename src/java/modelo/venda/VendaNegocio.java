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

/**
 *
 * @author heldercosta
 *
 * Classe de negócio que encapsula as regras de negócio das vendas
 */
public class VendaNegocio {
    
    public boolean inserir(int id, String data, String login) {
        VendaDAO dao = new VendaDAO();
        return dao.inserir(id, data, login);
    }

    public boolean alterar(int id, String data, String login) {
        VendaDAO dao = new VendaDAO();
        return dao.alterar(id, data, login);
    }

    public boolean excluir(int id) {
        VendaDAO dao = new VendaDAO();
        return dao.excluir(id);
    }
    
    public Venda obterUsuario(int id) {
        VendaDAO dao = new VendaDAO();
        return dao.obterVenda(id);
    }

    public List<Venda> obterTodos() {
        VendaDAO dao = new VendaDAO();
        return dao.obterTodos();
    }
    
}
