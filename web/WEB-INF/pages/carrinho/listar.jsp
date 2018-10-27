<%-- 
    Document   : listar
    Created on : Oct 27, 2018, 4:09:57 PM
    Author     : heldercosta
--%>


<%@page import="modelo.carrinho.CarrinhoItem"%>
<%@page import="java.util.List"%>
<%@page import="config.Mensagem"%>
<%@include file="../cabecalho.jsp" %>
<div id="titulo">Carrinho de Compras</div>
<% List<CarrinhoItem> resultado = (List<CarrinhoItem>) request.getAttribute("resultado"); %>
<% if (resultado != null && resultado.size() > 0) { %>
<table>
    <tr>
        <th>Produto</th>
        <th>Preço (Uni)</th>
        <th>Quantidade</th> 
        <th class="controles"></th>
    </tr>
    <% double total = 0;
       int quantidade = 0; %>
    <% for (CarrinhoItem item : resultado) {%>
    <tr>
        <td><%= item.getProduto().getDescricao()%></td>
        <td><%= item.getProduto().getPreco()%></td>
        <td><%= item.getQuantidade()%></td>
        <% total += item.getProduto().getPreco()*item.getQuantidade(); 
           quantidade += item.getQuantidade();%>
        <td><a href="RemoverCarrinhoServlet?produtoId=<%= item.getProduto().getId()%>">Remover</td>
    </tr>
    <% } %>
</table>
<div>Subtotal (<%= quantidade%> itens) = <%= total%></div>
<% } else {
    request.setAttribute("mensagem", Mensagem.MSG_CARRINHO_VAZIO);
    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
    rd.forward(request, response);
}%>
<%@include file="../rodape.jsp" %>
