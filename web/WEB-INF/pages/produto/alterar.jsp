<%-- 
    Document   : alterar
    Created on : 03/10/2018, 19:50:03
    Author     : helder
--%>

<%@page import="modelo.produto.Produto"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", "Você não possui permissão para acessar essa área");
        RequestDispatcher rd = request.getRequestDispatcher("../principal.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastro de Produtos</div>
<% Produto produto = (Produto) request.getAttribute("produto"); %>
<% if (produto != null) {%>
<form action="AlterarProdutoServlet" method="post">
    <div class="rotulo">Id:</div>
    <div class="campo"><input type="number" name="id" value="<%= produto.getId()%>" readonly="readonly" /></div>
    <div class="rotulo">Descrição:</div>
    <div class="campo"><input type="text" name="descricao" value="<%= produto.getDescricao()%>" /></div>
    <div class="rotulo">Preço:</div>
    <div class="campo"><input type="number" step="0.01" name="preco" value="<%= produto.getPreco()%>" /></div>
    <div class="rotulo">Categoria:</div>
    <div class="campo"><input type="number" name="categoria_id" value="<%= produto.getCategoria()%>" /></div>
    <div class="controles"><input type="submit" value="Salvar" /></div>
</form>
<% }%>
<%@include file="../rodape.jsp" %>