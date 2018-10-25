/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.venda;

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
 * @author heldercosta
 * 
 * Classe que representa as ações de vendas em um banco de dados relacional
 */
public class VendaDAO {
    
    /**
     * Método utilizado para recuperar todas as vendas registradas no banco
     *
     * @return
     */
    public List<Venda> obterTodos() {
        List<Venda> resultado = new ArrayList<Venda>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, data, usuario_login FROM venda");
            while (resultSet.next()) {
                Venda venda = new Venda();
                venda.setId(resultSet.getInt("id"));
                venda.setData(resultSet.getString("data"));
                venda.setLogin(resultSet.getString("usuario_login"));
                resultado.add(venda);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Venda>();
        }
        return resultado;
    }

    /**
     * Método utilizado para obter uma venda pelo id
     *
     * @param id
     * @return
     */
    public Venda obterVenda(int id) {
        Venda venda = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, data, usuario_login FROM venda WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda = new Venda();
                venda.setId(resultSet.getInt("id"));
                venda.setData(resultSet.getString("data"));
                venda.setLogin(resultSet.getString("usuario_login"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return venda;
    }

    /**
     * Método utilizado para registrar uma nova venda
     *
     * @param id
     * @param data
     * @param login
     * @return
     */
    public boolean inserir(int id, String data, String login) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda (id, data, login) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, data);
            preparedStatement.setString(3, login);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método utilizado para alterar uma venda já existente
     * Idealmente esse método não deve ser usado, já que uma venda não deve ser
     * alterada.
     *
     * @param id
     * @param data
     * @param login
     * @return
     */
    public boolean alterar(int id, String data, String login) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE venda SET data = ?, login = ? WHERE id = ?");
            preparedStatement.setString(1, data);
            preparedStatement.setString(2, login);
            preparedStatement.setInt(3, id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método para excluir uma venda já existente
     * Idealmente esse método não deve ser usado, já que uma venda não pode ser
     * cancelada por fins históricos.
     *
     * @param id
     * @return
     */
    public boolean excluir(int id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM venda WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
}
