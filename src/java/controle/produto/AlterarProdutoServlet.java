/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.produto;

import config.Mensagem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author helder
 */
public class AlterarProdutoServlet extends HttpServlet {

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
        
        // verificação para ver se o usuário possui permissão
        HttpSession session = request.getSession();
        Integer tipoUsuario = (Integer) session.getAttribute("tipoUsuario");
        if (tipoUsuario == null || tipoUsuario != 2) {  
            request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }
        
         // entrada
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        // processamento
        ProdutoNegocio produtoNegocio = new ProdutoNegocio();
        boolean sucessoAlterar = produtoNegocio.alterar(id, descricao, preco, categoria_id);
        // saída
        if (sucessoAlterar) {
            request.setAttribute("mensagem", "Produto alterado com sucesso");
        } else {
            request.setAttribute("mensagem", "Não foi possível alterar este produto");
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListarProdutoServlet");
        rd.forward(request, response);
    }

}
