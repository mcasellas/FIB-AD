<%-- 
    Document   : UploadOK
    Created on : 28-sep-2018, 10:32:44
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
        <h1>La Imatge s'ha pujat correctament!</h1>
        <form action="./registrarImagen.jsp" method="POST">
            <input class="boto" type="submit" value="Registra una altre imatge"> 
        </form>
        <form action="./menu.jsp" method="POST">
            <input class="boto" type="submit" value="Torna al menú"> 
        </form>
    </body>
</html>
