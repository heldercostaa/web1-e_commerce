<%-- 
    Document   : login
    Created on : Oct 25, 2018, 6:23:24 PM
    Author     : heldercosta
--%>

<%@include file="../cabecalho.jsp" %>
<div id="titulo">Minha Conta</div>
<form action="LoginServlet" method="post">
    <div class="rotulo">Login:</div>
    <div class="campo"><input type="text" name="login" /></div>
    <div class="rotulo">Senha</div>
    <div class="campo"><input type="password" name="senha" /></div>
    <div class="controles"><input type="submit" value="Entrar" /></div>
    <div class="controles">
        <input type="button" onclick="location.href='CadastreseServlet'" value="Cadastre-se">
    </div>
</form>
<%@include file="../rodape.jsp" %>