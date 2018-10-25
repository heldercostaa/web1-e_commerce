/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.sessao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.sessao.SessaoNegocio;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que representa a ação de validar um login de usuário
 */
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        // entrada
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        // processamento        
        SessaoNegocio sessaoNegocio = new SessaoNegocio();
        int tipoUsuario = sessaoNegocio.efetuarLogin(login, senha);
        
        if (tipoUsuario == 1 || tipoUsuario == 2) { // caso seja usuário ou funcionario
            HttpSession session = request.getSession(true); // cria e referencia a sessão do usuário
            session.setAttribute("tipoUsuario", tipoUsuario); // coloca o tipo de usuário no objeto request
            session.setAttribute("login", login); // coloca o login do usuário no objeto request
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/principal.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
            rd.forward(request, response);
        } else { // caso não esteja cadastrado
            request.setAttribute("mensagem", "Login ou senha incorreta"); // coloca uma mensagem no objeto request
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
            rd.forward(request, response);
        }
    }

}
