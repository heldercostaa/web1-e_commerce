<%-- 
    Document   : novo
    Created on : 03/10/2018, 00:06:42
    Author     : helder
--%>

<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", "Voc� n�o possui permiss�o para acessar essa �rea");
        RequestDispatcher rd = request.getRequestDispatcher("../principal.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Nova categoria</div>
<form action="IncluirCategoriaServlet" method="post">
    <div>Id:</div>
    <div><input type="number" name="id" /></div>
    <div>Descri��o:</div>
    <div><input type="text" name="descricao" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
