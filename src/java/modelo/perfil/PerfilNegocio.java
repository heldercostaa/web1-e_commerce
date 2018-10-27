/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */

package modelo.perfil;

import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioDAO;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO;

/**
 *
 * @author heldercosta
 */
public class PerfilNegocio {

    /**
     * Método que identifica o tipo de usuario
     *
     * @param login
     * @param senha
     * @return 0: não cadastrado
     *         1: usuario
     *         2: funcionario
     */
    public int efetuarLogin(String login, String senha) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = usuarioDao.obterUsuario(login);
        
        FuncionarioDAO funcDao = new FuncionarioDAO();
        Funcionario funcionario = funcDao.obterFuncionario(login);
        
        int tipoUsuario = 0;
        
        tipoUsuario = (usuario != null && usuario.getSenha().equals(senha)) ? 1 : tipoUsuario; // verifica se está na tabela de usuário
        tipoUsuario = (funcionario != null && funcionario.getSenha().equals(senha)) ? 2 : tipoUsuario; // verifica se está na tabela de funcionário
        
        return tipoUsuario;
    }

}
