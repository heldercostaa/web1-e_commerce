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
import modelo.funcionario.FuncionarioNegocio;
import modelo.perfil.PerfilInterface;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author Leonardo Oliveira Moreira
 */
public class VerDadosServlet extends HttpServlet {

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
        
        int tipoUsuario = (int) session.getAttribute("tipoUsuario");
        String login = (String) session.getAttribute("login"); // recupera o atributo de login armazenado na sessão do usuário, caso não existe é retornado nulo
        
        PerfilInterface dados = null;
        
        if (tipoUsuario == 1) {
            UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
            dados = usuarioNegocio.obterUsuario(login); // recupera o objeto usuário por meio do login armazenado na sessão
        } else if (tipoUsuario == 2) {
            FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
            dados = funcionarioNegocio.obterFuncionario(login); // recupera o objeto funcionario por meio do login armazenado na sessão
        }
        
        if (dados != null) { // caso exista o usuário com o login armazenado na sessão
            request.setAttribute("dados", dados);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/verDados.jsp");
            rd.forward(request, response);
        } else { // caso o login não exista na sessão ou não é um login válido no sistema
            request.setAttribute("mensagem", "Você não possui um login válido");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

}
