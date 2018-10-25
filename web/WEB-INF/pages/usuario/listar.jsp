<%-- 
    Document   : listar
    Created on : 23/09/2018, 10:25:15
    Author     : leoomoreira
--%>

<%@page import="java.util.List"%>
<%@page import="config.Mensagem"%>
<%@page import="modelo.usuario.Usuario"%>
<%@include file="../cabecalho.jsp" %>
<%
    if (tipoUsuario != 2) {
        request.setAttribute("mensagem", Mensagem.MSG_SEM_PERMISSAO);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>
<div id="titulo">Cadastro de Usuários</div>
<%
    if (tipoUsuario == 2) {
%>
<div><a href="NovoUsuarioServlet">Novo</a></div>
<%
    }
%>
<% List<Usuario> resultado = (List<Usuario>) request.getAttribute("resultado"); %>
<% if (resultado != null && resultado.size() > 0) { %>
<table>
    <tr>
        <th>Login</th>
        <th>Nome</th>   
        <th class="controles"></th>
    </tr>
    <% for (Usuario item : resultado) {%>
    <tr>
        <td><%= item.getLogin()%></td>
        <td><%= item.getNome()%></td>
        <%
            if (tipoUsuario == 2) {
        %>
        <td><a href="ObterUsuarioServlet?login=<%= item.getLogin()%>">Alterar</a>&nbsp;<a href="ExcluirUsuarioServlet?login=<%= item.getLogin()%>">Excluir</a></td>
        <%
            }
        %>
    </tr>
    <% } %>
</table>
<% }%>
<%@include file="../rodape.jsp" %>