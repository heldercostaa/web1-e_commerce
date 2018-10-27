
import java.util.List;
import modelo.carrinho.CarrinhoItem;
import modelo.carrinho.CarrinhoNegocio;

/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */

/**
 *
 * @author heldercosta
 * 
 * Classe criada para os testes de operações em carrinhos sejam feitos
 */
public class TestaCarrinho {
    public static void main(String[] args) {
        
        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        
        List<CarrinhoItem> carrinhoItens = null;
        
        String cookie = "id=2qtd=4id=1qtd=2";
        
        System.out.println("Existe 3: " + carrinhoNegocio.existeProduto(cookie, 3));
        
        System.out.println("---");
        System.out.println("Inserindo 3");
        cookie = carrinhoNegocio.inserirProduto(cookie, 3, 2);
        
        System.out.println("---");
        
        System.out.println("Existe 3: " + carrinhoNegocio.existeProduto(cookie, 3));

        System.out.println("---");
        carrinhoItens = carrinhoNegocio.obterProdutos(cookie);
        for (CarrinhoItem c : carrinhoItens) {
            System.out.println(c.getProduto().getId() + " - " + c.getProduto().getDescricao());
        }
        System.out.println("---");

        System.out.println("Removendo 3");
        cookie = carrinhoNegocio.removerProduto(cookie, 3);

        System.out.println("---");
        carrinhoItens = carrinhoNegocio.obterProdutos(cookie);
        for (CarrinhoItem c : carrinhoItens) {
            System.out.println(c.getProduto().getId() + " - " + c.getProduto().getDescricao());
        }
        System.out.println("---");
    }
}
