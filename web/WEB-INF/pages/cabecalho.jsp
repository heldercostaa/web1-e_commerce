    <%-- 
    Document   : cabecalho
    Created on : 23/09/2018, 10:02:29
    Author     : leoomoreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int tipoUsuario;
    String login;
    if(null != session.getAttribute("tipoUsuario")) {
        tipoUsuario = (Integer) session.getAttribute("tipoUsuario");
        login = (String) session.getAttribute("login");
    } else {
        tipoUsuario = 0;
        login = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SMD e-commerce</title>
        <link href="css/principal.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="logo">
            <center>
                <div id="logo-conteudo">SMD e-commerce</div>
            </center>
        </div>
        <div id="menu">
            <center>
                <div id="menu-conteudo" class="div-table">
                    <div class="div-table-row">
                        <%
                            if (tipoUsuario == 0) {
                        %>
                        <div class="div-table-col"><a href="MinhaContaServlet">Minha conta</a></div>
                        <%
                            } else {
                        %>
                        <div class="div-table-col"><a href="MeusDadosServlet">Meus Dados</a></div>
                        <%
                            }
                        %>
                        <div class="div-table-col"><a href="ListarCategoriaServlet">Categorias</a></div>
                        <div class="div-table-col"><a href="ListarProdutoServlet">Produtos</a></div>
                        <div class="div-table-col"><a href="ListarCarrinhoServlet">Carrinho</a></div>
                        <%
                            if (tipoUsuario == 2) { 
                        %>
                        <div class="div-table-col"><a href="ListarUsuarioServlet">Usuários</a></div>
                        <div class="div-table-col"><a href="ListarFuncionarioServlet">Funcionários</a></div>
                        <%
                            }
                        %>
                        <%
                            if (tipoUsuario != 0) {
                        %>
                        <div class="div-table-col"><a href="LogoutServlet">Sair</a></div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </center>
        </div>
    <center>    
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>

        <div id="mensagem"><b><%= mensagem%></b></div>
            <%
                }
            %>
        <div id="conteudo">
