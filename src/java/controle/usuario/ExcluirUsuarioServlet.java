/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.usuario;

import config.Mensagem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        
        // verificação para ver se o usuário possui permissão
        HttpSession session = request.getSession();
        Integer tipoUsuario = (Integer) session.getAttribute("tipoUsuario");
        if (tipoUsuario == null || tipoUsuario != 2) {  
            request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }
        
        String login = request.getParameter("login");
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        boolean sucessoExcluir = usuarioNegocio.excluir(login);
        if (sucessoExcluir) {
            request.setAttribute("mensagem", "Usuário excluído com sucesso");
        } else {
            request.setAttribute("mensagem", "Não foi possível excluir este usuário");
        }
        
        String url = request.getHeader("referer");
        
        if(url.matches("(.*)MeusDadosServlet")) {
            RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

}
