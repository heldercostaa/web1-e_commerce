<%-- 
    Document   : alterar
    Created on : 02/10/2018, 17:51:29
    Author     : helder
--%>

<%@page import="modelo.categoria.Categoria"%>
<%@page import="config.Mensagem"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastro de Categorias</div>
<% Categoria categoria = (Categoria) request.getAttribute("categoria"); %>
<% if (categoria != null) {%>
<form action="AlterarCategoriaServlet" method="post">
    <div class="rotulo">Id:</div>
    <div class="campo"><input type="number" name="id" value="<%= categoria.getId()%>" readonly="readonly" /></div>
    <div class="rotulo">Descrição:</div>
    <div class="campo"><input type="text" name="descricao" value="<%= categoria.getDescricao()%>" /></div>
    <div class="controles"><input type="submit" value="Salvar" /></div>
</form>
<% }%>
<%@include file="../rodape.jsp" %>