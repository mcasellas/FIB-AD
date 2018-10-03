<%-- 
    Document   : registrarImagen
    Created on : 19-sep-2018, 18:20:18
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style><%@include file="/styles/estil.css"%></style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        <form class="w3-container" method="post" action="registrarImagen" enctype="multipart/form-data">
            <center>
            <input class="w3-input" type="file" id="imatge" name="imatge"required>
            <input  class="w3-input w3-light-grey" type="text" name="titol" placeholder="Títol" required>
            <input  class="w3-input w3-light-grey" type="text" name="descripcio" placeholder="Descripció" required>
            <input class="w3-input w3-light-grey" type="text" name="tags" placeholder="Tags separats amb ';'  Exemple: (naturalesa;animals;maincra) " required>
            <input  class="w3-input w3-light-grey" type="text" name="autor" placeholder="Autor" required>
            <input  class="w3-input w3-light-grey" type="date" name="datac" required>
            <input type="hidden" name="username" value=  >
            <input  class="boto" type="submit" value="Puja">
            </center>
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