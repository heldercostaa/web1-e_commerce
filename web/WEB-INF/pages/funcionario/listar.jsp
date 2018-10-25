<%-- 
    Document   : listar
    Created on : 03/10/2018, 20:57:34
    Author     : helder
--%>

<%@page import="java.util.List"%>
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
<%
    if (tipoUsuario == 2) {
%>
<div><a href="NovoFuncionarioServlet">Novo</a></div>
<%
    }
%>
<% List<Funcionario> resultado = (List<Funcionario>) request.getAttribute("resultado"); %>
<% if (resultado != null && resultado.size() > 0) { %>
<table>
    <tr>
        <th>Login</th>
        <th>Nome</th>
        <th>Senha</th>
        <th>Salário</th>        
        <th class="controles"></th>
    </tr>
    <% for (Funcionario item : resultado) {%>
    <tr>
        <td><%= item.getLogin()%></td>
        <td><%= item.getNome()%></td>
        <td><%= item.getSenha()%></td>
        <td><%= item.getSalario()%></td>
        <%
            if (tipoUsuario == 2) {
        %>
        <td><a href="ObterFuncionarioServlet?login=<%= item.getLogin()%>">Alterar</a>&nbsp;<a href="ExcluirFuncionarioServlet?login=<%= item.getLogin()%>">Excluir</a></td>
        <%
            }
        %>
    </tr>
    <% } %>
</table>
<% }%>
<%@include file="../rodape.jsp" %>