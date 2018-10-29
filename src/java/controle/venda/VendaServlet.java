/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package controle.venda;

import config.Mensagem;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoItem;
import modelo.carrinho.CarrinhoNegocio;
import modelo.venda.VendaNegocio;

/**
 *
 * @author heldercosta
 */
public class VendaServlet extends HttpServlet {

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
        String login = request.getParameter("login"); //login do usuário
        
        if(login.equals("")){
            request.setAttribute("mensagem", Mensagem.MSG_LOGADO_PARA_COMPRAR);
            RequestDispatcher rd = request.getRequestDispatcher("MinhaContaServlet");
            rd.forward(request, response);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
        String data = dateFormat.format(date); //pega data e hora atual
        
        Cookie[] cookies = request.getCookies();
        String cookieValor = "";
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("pw1.cc")){
                cookieValor = c.getValue();
                break;
            }
        }
        
        // obtem todos os itens presentes no cookie de carrinho
        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        List<CarrinhoItem> resultado = carrinhoNegocio.obterProdutos(cookieValor);
        
        VendaNegocio vendaNegocio = new VendaNegocio();
        boolean sucessoVenda = vendaNegocio.inserir(data, login, resultado);
        
        // saída
        if (sucessoVenda) {
            // zerando cookies da sessão (carrinho de compras)
            for (int i = 0; cookies != null && i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals("pw1.cc")) {
                    c.setValue("");
                    response.addCookie(c);
                    break;
                }
            }
            
            request.setAttribute("mensagem", "Compra realizada com sucesso.");
            RequestDispatcher rd = request.getRequestDispatcher("HistoricoComprasServlet?login=" + login);
            rd.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Não foi possível realizar a compra.");
            RequestDispatcher rd = request.getRequestDispatcher("ListarCarrinhoServlet");
            rd.forward(request, response);
        }
    }
    
}
