<%-- 
    Document   : incluir
    Created on : 03/10/2018, 20:54:57
    Author     : helder
--%>

<%@page import="config.Mensagem"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Novo funcoinário</div>
<form action="IncluirFuncionarioServlet" method="post">
    <div>Nome:</div>
    <div><input type="text" name="nome" /></div>
    <div>Login:</div>
    <div><input type="text" name="login" /></div>
    <div>Senha:</div>
    <div><input type="password" name="senha" /></div>
    <div>Salário:</div>
    <div><input type="number" step="0.01" name="salario" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
