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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author helder
 */
public class IncluirFuncionarioServlet extends HttpServlet {

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
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        double salario = Double.parseDouble(request.getParameter("salario"));
        // processamento
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        boolean sucessoInserir = funcionarioNegocio.inserir(login, nome, senha, salario);
        // saída
        if (sucessoInserir) {
            request.setAttribute("mensagem", "Funcionario inserido com sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionarioServlet");
            rd.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Não foi possível inserir este funcionario");
            RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionarioServlet");
            rd.forward(request, response);
        }
    }
}
