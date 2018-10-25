/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.usuario;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que representa a ação de excluir um usuário existente
 */
public class ExcluirUsuarioServlet extends HttpServlet {

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
        String login = request.getParameter("login");
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        boolean sucessoExcluir = usuarioNegocio.excluir(login);
        if (sucessoExcluir) {
            request.setAttribute("mensagem", "Usuário excluído com sucesso");
        } else {
            request.setAttribute("mensagem", "Não foi possível excluir este usuário");
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListarUsuarioServlet");
        rd.forward(request, response);
    }

}