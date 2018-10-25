/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.funcionario;

import java.util.List;

/**
 *
 * @author helder
 */
public class FuncionarioNegocio {

    public boolean inserir(String login, String nome, String senha, double salario) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.inserir(login, nome, senha, salario);
    }

    public boolean alterar(String login, String nome, String senha, double salario) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.alterar(login, nome, senha, salario);
    }

    public boolean excluir(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.excluir(login);
    }
    
    public Funcionario obterFuncionario(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.obterFuncionario(login);
    }

    public List<Funcionario> obterTodos() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.obterTodos();
    }
}
