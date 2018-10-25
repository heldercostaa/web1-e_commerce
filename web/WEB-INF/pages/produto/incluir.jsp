<%-- 
    Document   : novo
    Created on : 03/10/2018, 19:54:30
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
<div id="titulo">Novo produto</div>
<form action="IncluirProdutoServlet" method="post">
    <div>Id:</div>
    <div><input type="number" name="id" /></div>
    <div>Descrição:</div>
    <div><input type="text" name="descricao" /></div>
    <div>Preço:</div>
    <div><input type="number" step="0.01" name="preco" /></div>
    <div>Categoria</div>
    <div><input type="number" name="categoria_id" /></div>
    <div><input type="submit" value="Salvar" /></div>
</form>
<%@include file="../rodape.jsp" %>
