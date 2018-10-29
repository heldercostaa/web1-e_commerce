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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.venda.Venda;
import modelo.venda.VendaNegocio;
import modelo.venda_produto.VendaProduto;
import modelo.venda_produto.VendaProdutoNegocio;

/**
 *
 * @author heldercosta
 */
public class HistoricoComprasServlet extends HttpServlet {

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
        String login = request.getParameter("login");
        VendaNegocio vendaNegocio = new VendaNegocio();
        VendaProdutoNegocio vendaProdutoNegocio = new VendaProdutoNegocio();
        List<Venda> vendas = vendaNegocio.obterTodosPorLogin(login);
        List<VendaProduto> vendasProdutos = new ArrayList<VendaProduto>();
        for (Venda venda : vendas) {
            for (VendaProduto vendaProduto : vendaProdutoNegocio.obterTodosPorVenda(venda.getId())) {
                vendasProdutos.add(vendaProduto);
            }
        }
        
        request.setAttribute("vendas", vendas);
        request.setAttribute("vendasProdutos", vendasProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/sessao/historico.jsp");
        rd.forward(request, response);
    }
}
