/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.funcionario;

import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helder
 */
public class FuncionarioDAO {
    
    public List<Funcionario> obterTodos() {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login, nome, senha, salario FROM funcionario");
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setLogin(resultSet.getString("login"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setSenha(resultSet.getString("senha"));
                funcionario.setSalario(resultSet.getDouble("salario"));
                resultado.add(funcionario);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Funcionario>();
        }
        return resultado;
    }

    
    public Funcionario obterFuncionario(String login) {
        Funcionario funcionario = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT login, nome, senha, salario FROM funcionario WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setLogin(resultSet.getString("login"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setSenha(resultSet.getString("senha"));
                funcionario.setSalario(resultSet.getDouble("salario"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
            return null;
        }
        return funcionario;
    }
    
    public boolean inserir(String login, String nome, String senha, double salario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO funcionario (login, nome, senha, salario) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, senha);
            preparedStatement.setDouble(4, salario);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    public boolean alterar(String login, String nome, String senha, double salario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE funcionario SET nome = ?, senha = ?, salario = ? WHERE login = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            preparedStatement.setDouble(3, salario);
            preparedStatement.setString(4, login);            
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public boolean excluir(String login) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM funcionario WHERE login = ?");
            preparedStatement.setString(1, login);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
}
