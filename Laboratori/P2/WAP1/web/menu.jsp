<%-- 
    Document   : menu
    Created on : 19-sep-2018, 17:17:15
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FotOK</title>
        <style><%@include file="/styles/estil.css"%></style>
    </head>
    <body>    
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
        <h1>MENU PRINCIPAL</h1>
        <br>
        <h2>Benvingut, <%=userName %></h2>
        <br>
        <form action="./registrarImagen.jsp" method="POST">
            <input class="boto" type="submit" value="Registra una imatge"> 
        </form>
        <form action="./modificarImagen.jsp" method="POST">
            <input class="boto" type="submit" value="Modifica una imatge"> 
        </form>
        <form action="./list.jsp" method="POST">
            <input class="boto" type="submit" value="Llista les imatges"> 
        </form>
        <form action="./buscarImagen.jsp" method="POST">
            <input class="boto" type="submit" value="Buscar una imatge"> 
        </form>
        <br>
        <br>
        <form action="logout" method="post">
        <input class="boto" type="submit" value="Logout" >
        </form>
    </body>
</html>

