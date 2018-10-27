/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.carrinho;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoItem;
import modelo.carrinho.CarrinhoNegocio;

/**
 *
 * @author heldercosta
 */
public class RemoverCarrinhoServlet extends HttpServlet {

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
        
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));

        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("pw1.cc")) {
                cookie = c;
                break;
            }
        }

        String cookieValor = "";
        if (cookie == null) {
            cookie = new Cookie("pw1.cc", cookieValor);
        } else {
            cookieValor = cookie.getValue();
        }

        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        cookieValor = carrinhoNegocio.removerProduto(cookieValor, produtoId);

        cookie.setValue(cookieValor);
        cookie.setMaxAge(Integer.MAX_VALUE);

        
        
        List<CarrinhoItem> resultado = carrinhoNegocio.obterProdutos(cookieValor);
        request.setAttribute("resultado", resultado);
        
        response.addCookie(cookie);
        request.setAttribute("mensagem", "Produto removido do carrinho de compras");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/carrinho/listar.jsp");
        rd.forward(request, response);
    }
}
