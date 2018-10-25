<%-- 
    Document   : index
    Created on : 12/09/2018, 15:28:30
    Author     : leoomoreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SMD e-commerce</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div>Identificação do Usuário</div>
        <form action="LoginServlet" method="post">
            <div>Login:</div>
            <div><input type="text" name="login" /></div>
            <div>Senha:</div>
            <div><input type="password" name="senha" /></div>
            <div><input type="submit" value="Enviar" /></div>
        </form>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div id="mensagem"><b><%= mensagem%></b></div>
        <%
            }
        %>
    </body>
</html>
