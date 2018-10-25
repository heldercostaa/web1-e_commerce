/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.usuario;

import modelo.perfil.PerfilInterface;

/**
 *
 * @author Leonardo Oliveira Moreira
 * 
 * Classe que representa a entidade usuário
 */
public class Usuario implements PerfilInterface {

    private String nome;
    private String login;
    private String senha;

    @Override
    public Usuario getPerfil() {
        return this;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
