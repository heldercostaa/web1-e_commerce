<%-- 
    Document   : historico
    Created on : Oct 28, 2018, 9:23:04 PM
    Author     : heldercosta
--%>

<%@page import="modelo.produto.ProdutoNegocio"%>
<%@page import="modelo.venda_produto.VendaProduto"%>
<%@page import="modelo.venda.Venda"%>
<%@page import="config.Mensagem"%>
<%@page import="java.util.List"%>
<%@page import="modelo.produto.Produto"%>
<%@include file="../cabecalho.jsp" %>
<div id="titulo">Histórico de Compras</div>
<%
    if (tipoUsuario == 0) {
        request.setAttribute("mensagem", Mensagem.MSG_PRECISA_LOGAR);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<% List<Venda> vendas = (List<Venda>) request.getAttribute("vendas"); %>
<% List<VendaProduto> vendasProdutos = (List<VendaProduto>) request.getAttribute("vendasProdutos"); %>
<% ProdutoNegocio produtoNegocio = new ProdutoNegocio(); %>
<% if ((vendas != null && vendas.size() > 0) && (vendasProdutos != null && vendasProdutos.size() > 0)) { %>

<% for (Venda venda : vendas) {%>
<% double total = 0;%>
<% boolean primeiro = true; %>
<table>
    <tr>
        <th>Data</th>
        <th>Produto</th>
        <th>Preço</th>
    </tr>
    <tr>
    <% for (VendaProduto vendaProduto : vendasProdutos) {
        if (vendaProduto.getVenda() == venda.getId()) { %>
            <%if(primeiro) {%>
                <td><%= venda.getData()%></td>
                <%primeiro = false;%>
            <%} else {%>
                <td></td>
            <%}%>
            <td><%= produtoNegocio.obterProduto(vendaProduto.getProduto()).getDescricao()%> (x<%= vendaProduto.getQuantidade()%>)</td>
            <td><%= vendaProduto.getQuantidade() * produtoNegocio.obterProduto(vendaProduto.getProduto()).getPreco()%></td>
            <% total += produtoNegocio.obterProduto(vendaProduto.getProduto()).getPreco() * vendaProduto.getQuantidade(); %>
        </tr>
        <% } %>
    <% } %>
</table>
<div>Total: <%= total%></div>
<br/>
<% } %>
<% } %>
<%@include file="../rodape.jsp" %>
