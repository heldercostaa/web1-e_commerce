<%-- 
    Document   : verUsuario
    Created on : 19/09/2018, 14:50:53
    Author     : leoomoreira
--%>

<%@include file="../cabecalho.jsp" %>
<div id="titulo">Meus Dados</div>
<jsp:useBean id="dados" type="modelo.perfil.PerfilInterface" scope="request" />
<div class="rotulo">Nome: <jsp:getProperty name="dados" property="nome" /></div>
<div class="rotulo">Login: <jsp:getProperty name="dados" property="login" /></div>
<div class="rotulo">Senha: <jsp:getProperty name="dados" property="senha" /></div>
<div class="controles">
    <% 
        if(tipoUsuario == 2) {
    %>
    <input type="button" onclick="location.href='ObterFuncionarioServlet?login=<jsp:getProperty name="dados" property="login" />'" value="Editar Dados">
    <input type="button" onclick="location.href='ExcluirFuncionarioServlet?login=<jsp:getProperty name="dados" property="login" />'" value="Excluir Conta">
    <%
        } else {
    %>
    <input type="button" onclick="location.href='ObterUsuarioServlet?login=<jsp:getProperty name="dados" property="login" />'" value="Editar Dados">
    <input type="button" onclick="location.href='ExcluirUsuarioServlet?login=<jsp:getProperty name="dados" property="login" />'" value="Excluir Conta">
    <%
        }
    %>
</div>

<%@include file="../rodape.jsp" %>
