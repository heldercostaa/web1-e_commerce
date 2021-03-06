/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.venda_produto;

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
 * Classe que representa os relacionamentos entre vendas e produtos no banco de
 * dados
 */
public class VendaProdutoDAO {
    /**
     * Método utilizado para recuperar todos os relacionamentos de vendas e 
     * produtos registradas no banco
     *
     * @return
     */
    public List<VendaProduto> obterTodosPorVenda(int id) {
        List<VendaProduto> resultado = new ArrayList<VendaProduto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareCall("SELECT venda_id, produto_id, quantidade FROM venda_produto WHERE venda_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VendaProduto vendaProduto = new VendaProduto();
                vendaProduto.setVenda(resultSet.getInt("venda_id"));
                vendaProduto.setProduto(resultSet.getInt("produto_id"));
                vendaProduto.setQuantidade(resultSet.getInt("quantidade"));
                resultado.add(vendaProduto);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<VendaProduto>();
        }
        return resultado;
    }

    /**
     * Método utilizado para obter um relacionamento de venda e produto pelo id 
     * da venda
     *
     * @param venda_id
     * @param produto_id
     * @return
     */
    public VendaProduto obterVendaProduto(int venda_id, int produto_id) {
        VendaProduto vendaProduto = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT venda_id, produto_id, quantidade FROM venda_produto WHERE venda_id = ? AND produto_id = ?");
            preparedStatement.setInt(1, venda_id);
            preparedStatement.setInt(1, produto_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vendaProduto = new VendaProduto();
                vendaProduto.setVenda(resultSet.getInt("venda_id"));
                vendaProduto.setProduto(resultSet.getInt("produto_id"));
                vendaProduto.setQuantidade(resultSet.getInt("quantidade"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return vendaProduto;
    }

    /**
     * Método utilizado para registrar um novo relacionamento de venda e produto
     *
     * @param venda_id
     * @param produto_id
     * @param quantidade
     * @return
     */
    public boolean inserir(int venda_id, int produto_id, int quantidade) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda_produto (venda_id, produto_id, quantidade) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, venda_id);
            preparedStatement.setInt(2, produto_id);
            preparedStatement.setInt(3, quantidade);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método utilizado para alterar a quantidade de um relacionamento de 
     * venda e produto já existente
     *
     * @param venda_id
     * @param produto_id
     * @param quantidade
     * @return
     */
    public boolean alterar(int venda_id, int produto_id, int quantidade) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE venda_produto SET quantidade = ? WHERE venda_id = ? AND produto_id = ?");
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, venda_id);
            preparedStatement.setInt(3, produto_id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método para excluir um relacionamento de venda e produto já existente
     *
     * @param venda_id
     * @param produto_id
     * @return
     */
    public boolean excluir(int venda_id, int produto_id) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM venda_produto WHERE venda_id = ? AND produto_id = ?");
            preparedStatement.setInt(1, venda_id);
            preparedStatement.setInt(2, produto_id);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
}
