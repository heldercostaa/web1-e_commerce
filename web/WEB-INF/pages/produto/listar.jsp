<%-- 
    Document   : listar
    Created on : 03/10/2018, 19:55:48
    Author     : helder
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.produto.Produto"%>
<%@include file="../cabecalho.jsp" %>
<div id="titulo">Cadastro de Produtos</div>
<%
    if (tipoUsuario == 2) {
%>
<div><a href="NovoProdutoServlet">Novo</a></div>
<%
    }
%>
<% List<Produto> resultado = (List<Produto>) request.getAttribute("resultado"); %>
<% if (resultado != null && resultado.size() > 0) { %>
<table>
    <tr>
        <th>Id</th>
        <th>Descrição</th>
        <th>Preço</th>
        <th>Categoria</th>        
        <th class="controles"></th>
    </tr>
    <% for (Produto item : resultado) {%>
    <tr>
        <td><%= item.getId()%></td>
        <td><%= item.getDescricao()%></td>
        <td><%= item.getPreco()%></td>
        <td><%= item.getCategoria()%></td>
        <%
            if (tipoUsuario == 2) {
        %>
        <td><a href="ObterProdutoServlet?id=<%= item.getId()%>">Alterar</a>&nbsp;<a href="ExcluirProdutoServlet?id=<%= item.getId()%>">Excluir</a></td>
        <%
            }
        %>
    </tr>
    <% } %>
</table>
<% }%>
<%@include file="../rodape.jsp" %>