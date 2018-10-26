<%-- 
    Document   : alterar
    Created on : 03/10/2018, 20:51:28
    Author     : helder
--%>

<%@page import="config.Mensagem"%>
<%@page import="modelo.funcionario.Funcionario"%>
<%@include file="../cabecalho.jsp" %>
<% Funcionario funcionario = (Funcionario) request.getAttribute("funcionario"); %>
<% if (funcionario != null) {%>
<% if (!funcionario.getLogin().equals(login) && tipoUsuario != 2) {
        request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    } %>
<div id="titulo">Alterar Funcionário</div>
<form action="AlterarFuncionarioServlet" method="post">
    <div class="rotulo">Login:</div>
    <div class="campo"><input type="text" name="login" value="<%= funcionario.getLogin()%>" readonly="readonly" /></div>
    <div class="rotulo">Nome:</div>
    <div class="campo"><input type="text" name="nome" value="<%= funcionario.getNome()%>" /></div>
    <div class="rotulo">Senha:</div>
    <div class="campo"><input type="text" name="senha" value="<%= funcionario.getSenha()%>" /></div>
    <div class="rotulo">Salário:</div>
    <div class="campo"><input type="number" step="0.01" name="salario" value="<%= funcionario.getSalario()%>" /></div>
    <% if(request.getHeader("Referer").matches("(.*)MeusDadosServlet")) { %>
    <input type="hidden" name="verDados" value="TRUE" />
    <% 
        }
    %>
    <div class="controles"><input type="submit" value="Salvar" /></div>
</form>
<% }%>
<%@include file="../rodape.jsp" %>