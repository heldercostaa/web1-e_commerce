/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.funcionario;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author helder
 */
public class ListarFuncionarioServlet extends HttpServlet {

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
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        List<Funcionario> resultado = funcionarioNegocio.obterTodos();
        request.setAttribute("resultado", resultado);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/funcionario/listar.jsp");
        rd.forward(request, response);
    }
}
