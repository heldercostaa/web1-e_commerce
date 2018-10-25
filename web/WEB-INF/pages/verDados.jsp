<%-- 
    Document   : verUsuario
    Created on : 19/09/2018, 14:50:53
    Author     : leoomoreira
--%>
<%@include file="cabecalho.jsp" %>
<div id="titulo">Seus Dados</div>
<jsp:useBean id="dados" type="modelo.perfil.PerfilInterface" scope="request" />
<div class="rotulo">Nome: <jsp:getProperty name="dados" property="nome" /></div>
<div class="rotulo">Login: <jsp:getProperty name="dados" property="login" /></div>
<div class="rotulo">Senha: <jsp:getProperty name="dados" property="senha" /></div>
<%@include file="rodape.jsp" %>
