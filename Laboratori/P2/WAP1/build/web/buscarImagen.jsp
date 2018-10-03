<%-- 
    Document   : buscarImagen
    Created on : 03-oct-2018, 12:26:02
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
    <body>
        <h1>Hello World!</h1>
        <form class="w3-container" method="post" action="buscarImagen">
            <input class="w3-input" type="text" name="tags" required>
            <input  class="boto" type="submit" value="Busca">
        </form>
    </body>
</html>

<%
        String user = null;
        if(session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
        }else user = (String) session.getAttribute("username");
        String userName = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")) userName = cookie.getValue();
                if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
        }
    %>  