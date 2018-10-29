/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.funcionario;

import config.Mensagem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author helder
 */
public class AlterarFuncionarioServlet extends HttpServlet {

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
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        double salario = Double.parseDouble(request.getParameter("salario"));
        // processamento
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        boolean sucessoAlterar = funcionarioNegocio.alterar(login, nome, senha, salario);
        // saída
        if (sucessoAlterar) {
            request.setAttribute("mensagem", "Funcionario alterado com sucesso");
        } else {
            request.setAttribute("mensagem", "Não foi possível alterar este usuario");
        }
        
        if (null != request.getParameter("verDados")) {
            RequestDispatcher rd = request.getRequestDispatcher("MeusDadosServlet");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionarioServlet");
            rd.forward(request, response);
        }
    }

}
