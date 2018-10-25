<%-- 
    Document   : novo
    Created on : 03/10/2018, 00:06:42
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
<div id="titulo">Nova categoria</div>
<form action="IncluirCategoriaServlet" method="post">
    <div>Id:</div>
    <div><input type="number" name="id" /></div>
    <div>Descrição:</div>
    <div><input type="text" name="descricao" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
