/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.usuario;

import java.util.List;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe de negócio que encapsula as regras de negócio dos usuários
 */
public class UsuarioNegocio {
    
    public boolean inserir(String nome, String login, String senha) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserir(nome, login, senha);
    }

    public boolean alterar(String nome, String login, String senha) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.alterar(nome, login, senha);
    }

    public boolean excluir(String login) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.excluir(login);
    }
    
    public Usuario obterUsuario(String login) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.obterUsuario(login);
    }

    public List<Usuario> obterTodos() {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.obterTodos();
    }

}
