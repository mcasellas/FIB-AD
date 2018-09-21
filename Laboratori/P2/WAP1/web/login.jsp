<%-- 
    Document   : login
    Created on : 18-sep-2018, 20:30:15
    Author     : rando
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page</title> 
        <style><%@include file="/styles/estil.css"%></style>
    </head> 
    
    <title>W3.CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
    <body> 
        <div class="content">
            <h1>Login</h1>
            <form class="w3-container" action="login" method="POST">
                <br/>
                <input  class="w3-input w3-light-grey" type="text" name="username" placeholder="Usuari" value="sergi" required>
                <br/>
                <input class="w3-input w3-light-grey" type="password" name="password" placeholder="Contrasenya" value="1234" required> 
                <br/>
                <br/>
                <input class="w3-button  w3-light-grey" type="submit" value="Inicia Sessió">      
            </form> 
            <br/>
            <br/>
            <br/>
        </div>
    </body>
</html>
