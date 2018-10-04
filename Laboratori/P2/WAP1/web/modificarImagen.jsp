<%-- 
    Document   : modificar Imatge
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
    
    <%
        String titol = request.getParameter("titol");
        String data = request.getParameter("data");
        String tag =  request.getParameter("tags");
        String descrip =  request.getParameter("descripcio");
        String autor = request.getParameter("autor");
        String id = request.getParameter("id");
        String filename = request.getParameter("filename");
    %>
    
        <title>JSP Page</title>
    </head>
    <body>   
       
            <form class="w3-container" method="post" action="modificarImagen">
                      

            <input  class="w3-input w3-light-grey" type="text" name="titol" placeholder="Títol" value="<%= titol %> " required>
            <input  class="w3-input w3-light-grey" type="text" name="descripcio" placeholder="Descripció" value=" <%= descrip %> " required>
            <input class="w3-input w3-light-grey" type="text" name="tags" placeholder="Tags separats amb ';'  Exemple: (naturalesa;animals;maincra) " value="<%= tag %>" required>
            <input  class="w3-input w3-light-grey" type="text" name="autor" placeholder="Autor" value="<%= autor %>" required>
            <input  class="w3-input w3-light-grey" type="date" name="datac" value="<%= data %>" required>
            <input type="hidden" name="username" value="<%= userName %>"  >
            <input type="hidden" name="id" value="<%= id %>"  >
            <input type="hidden" name="anticFilename" value="<%= filename %>"  >
            <input  class="boto" type="submit" value="Actualitza data">
        </form>
    </body>
</html>

 