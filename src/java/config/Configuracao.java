/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package config;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que representa os elementos de configuração da aplicação
 */
public final class Configuracao {
        

    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/pweb1";
    public static final String JDBC_USUARIO = "postgres";
    public static final String JDBC_SENHA = "postgres";

    private Configuracao() {
        
    }
}
