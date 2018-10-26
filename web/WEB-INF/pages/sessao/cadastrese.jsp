<%-- 
    Document   : cadastrar
    Created on : Oct 26, 2018, 1:25:43 PM
    Author     : heldercosta
--%>

<%@include file="../cabecalho.jsp" %>
<%@page import="config.Mensagem"%>
<%
    if (tipoUsuario != 0) {
        request.setAttribute("mensagem", Mensagem.MSG_JA_CADASTRADO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastrar Conta</div>
<form action="CadastrarServlet" method="post">
    <div class="rotulo">Nome</div>
    <div class="campo"><input type="text" name="nome" /></div>    
    <div class="rotulo">Login</div>
    <div class="campo"><input type="text" name="login" /></div>
    <div class="rotulo">Senha</div>
    <div class="campo"><input type="password" name="senha" /></div>
    <div class="controles"><input type="submit" value="Cadastrar" /></div>
</form>
<%@include file="../rodape.jsp" %>