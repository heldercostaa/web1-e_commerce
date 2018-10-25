<%-- 
    Document   : novoUsuario
    Created on : 17/09/2018, 14:37:17
    Author     : leoomoreira
--%>

<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", "Voc� n�o possui permiss�o para acessar essa �rea");
        RequestDispatcher rd = request.getRequestDispatcher("../principal.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Novo funcion�rio</div>
<form action="IncluirUsuarioServlet" method="post">
    <div>Nome:</div>
    <div><input type="text" name="nome" /></div>
    <div>Login:</div>
    <div><input type="text" name="login" /></div>
    <div>Senha:</div>
    <div><input type="password" name="senha" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
