<%-- 
    Document   : alterar
    Created on : 03/10/2018, 20:51:28
    Author     : helder
--%>

<%@page import="modelo.funcionario.Funcionario"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", "Você não possui permissão para acessar essa área");
        RequestDispatcher rd = request.getRequestDispatcher("../principal.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastro de Funcionários</div>
<% Funcionario funcionario = (Funcionario) request.getAttribute("funcionario"); %>
<% if (funcionario != null) {%>
<form action="AlterarFuncionarioServlet" method="post">
    <div class="rotulo">Login:</div>
    <div class="campo"><input type="text" name="login" value="<%= funcionario.getLogin()%>" readonly="readonly" /></div>
    <div class="rotulo">Nome:</div>
    <div class="campo"><input type="text" name="nome" value="<%= funcionario.getNome()%>" /></div>
    <div class="rotulo">Senha:</div>
    <div class="campo"><input type="text" name="senha" value="<%= funcionario.getSenha()%>" /></div>
    <div class="rotulo">Salário:</div>
    <div class="campo"><input type="number" step="0.01" name="salario" value="<%= funcionario.getSalario()%>" /></div>
    <div class="controles"><input type="submit" value="Salvar" /></div>
</form>
<% }%>
<%@include file="../rodape.jsp" %>