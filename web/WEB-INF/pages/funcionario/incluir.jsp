<%-- 
    Document   : incluir
    Created on : 03/10/2018, 20:54:57
    Author     : helder
--%>

<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", "Você não possui permissão para acessar essa área");
        RequestDispatcher rd = request.getRequestDispatcher("../principal.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Novo funcoinário</div>
<form action="IncluirFuncionarioServlet" method="post">
    <div>Login:</div>
    <div><input type="text" name="login" /></div>
    <div>Nome:</div>
    <div><input type="text" name="nome" /></div>
    <div>Senha:</div>
    <div><input type="text" name="senha" /></div>
    <div>Salário:</div>
    <div><input type="number" step="0.01" name="salario" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
