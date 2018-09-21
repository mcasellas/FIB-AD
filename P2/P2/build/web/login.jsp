<%-- 
    Document   : login
    Created on : 14-sep-2018, 10:15:59
    Author     : marc.casellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action = "login" method = "POST">
            <p>Usuari</p>
            <input type="text" name="user">
            <p>Contrasenya</p>
            <input type="password" name="pass">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
