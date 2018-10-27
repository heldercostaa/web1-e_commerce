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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leonardo Oliveira Moreira
 * 
 * Classe que representa a ação de encerrar a sessão de um usuário
 */
public class LogoutServlet extends HttpServlet {

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
        HttpSession session = request.getSession(); // recupera a sessão do usuário
        session.invalidate(); // invalida a sessão do usuário
        Cookie[] cookies = request.getCookies();
        
        // zerando cookies da sessão
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("pw1.cc")) {
                c.setValue("");
                response.addCookie(c);
                break;
            }
        }
        
        request.setAttribute("mensagem", "Sua sessão foi encerrada"); // coloca uma mensagem no objeto request
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
        rd.forward(request, response);
    }

}
