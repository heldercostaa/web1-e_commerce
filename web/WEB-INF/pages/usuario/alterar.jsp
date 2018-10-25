<%-- 
    Document   : alterar
    Created on : 23/09/2018, 10:30:56
    Author     : leoomoreira
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page import="config.Mensagem"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastro de Usu�rios</div>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<% if (usuario != null) {%>
<form action="AlterarUsuarioServlet" method="post">
    <div class="rotulo">Login:</div>
    <div class="campo"><input type="text" name="login" value="<%= usuario.getLogin()%>" readonly="readonly" /></div>
    <div class="rotulo">Nome:</div>
    <div class="campo"><input type="text" name="nome" value="<%= usuario.getNome()%>" /></div>
    <div class="rotulo">Senha:</div>
    <div class="campo"><input type="password" name="senha" value="<%= usuario.getSenha()%>" /></div>
    <div class="controles"><input type="submit" value="Salvar" /></div>
</form>
<% }%>
<%@include file="../rodape.jsp" %>