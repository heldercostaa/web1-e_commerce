/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.produto;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author helder
 */
public class IncluirProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // entrada
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        // processamento
        ProdutoNegocio produtoNegocio = new ProdutoNegocio();
        boolean sucessoInserir = produtoNegocio.inserir(id, descricao, preco, categoria_id);
        // saída
        if (sucessoInserir) {
            request.setAttribute("mensagem", "Produto inserido com sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("ListarProdutoServlet");
            rd.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Não foi possível inserir este produto");
            RequestDispatcher rd = request.getRequestDispatcher("ListarProdutoServlet");
            rd.forward(request, response);
        }
    }
}
