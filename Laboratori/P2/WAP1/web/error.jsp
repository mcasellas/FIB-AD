<%-- 
    Document   : error
    Created on : 05-oct-2018, 0:09:35
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
       <%
        String user = null;
        if(session.getAttribute("username") == null){
                %>
                <p> L'usuari o contrasenya són incorrectes.</p>    
                <a href="./login.jsp" class="button" >Torna al Login</a>
                <%
        }
       else 
{
    %>  
    <p>Les dades no s'han processat correctament.</p>
    <a href="./menu.jsp" class="button" >Torna al Menú</a>
    <%
        }
%>
    </body>
</html>
