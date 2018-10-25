/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.produto;

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
public class ProdutoDAO {
    
    public List<Produto> obterTodos() {
        List<Produto> resultado = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, descricao, preco, categoria_id FROM produto");
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoria(resultSet.getInt("categoria_id"));
                resultado.add(produto);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
        return resultado;
    }

    
    public Produto obterProduto(int id) {
        Produto produto = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id, descricao, preco, categoria_id FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setCategoria(resultSet.getInt("categoria_id"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return produto;
    }
    
    public boolean inserir(int id, String descricao, double preco, int categoria_id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (id, descricao, preco, categoria_id) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, descricao);
            preparedStatement.setDouble(3, preco);
            preparedStatement.setInt(4, categoria_id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    public boolean alterar(int id, String descricao, double preco, int categoria_id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao = ?, preco = ?, categoria_id = ? WHERE id = ?");
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, categoria_id);
            preparedStatement.setInt(4, id);            
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public boolean excluir(int id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
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
