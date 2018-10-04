<%-- 
    Document   : buscarImagen
    Created on : 03-oct-2018, 12:26:02
    Author     : rando
--%>

<%@page import="java.sql.Array"%>
<%@page import="java.awt.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="/styles/estil.css"%></style>
    </head>
    <body>
        <h1>Buscador d'imatges</h1>
        <form class="w3-container" method="post" action="buscarImagen">
            <input class="w3-input" type="text" name="tags" required>
            <input  class="boto" type="submit" value="Busca">
            </form>    
            
<%
  ArrayList<String> pdts = null;
  ArrayList<String> titolA = null;
  ArrayList<String> descripcioA = null;
  ArrayList<String> tagsA = null;
  ArrayList<String> autorA = null;
  ArrayList<String> datacA = null;
  ArrayList<String> userA = null;
  ArrayList<Integer> idA = null;
  try {
      pdts = (ArrayList<String>) request.getAttribute("list");
      titolA = (ArrayList<String>) request.getAttribute("titol");
      descripcioA = (ArrayList<String>) request.getAttribute("descripcio");
      tagsA = (ArrayList<String>) request.getAttribute("tags");
      autorA = (ArrayList<String>) request.getAttribute("autor");
      datacA = (ArrayList<String>) request.getAttribute("datac");
      userA = (ArrayList<String>) request.getAttribute("user");
      idA = (ArrayList<Integer>) request.getAttribute("id");
  }
  catch (Exception e) {
      pdts = null;
      System.err.println(e.getMessage());
  }
  if(pdts!=null){
    for(int i=0; i < pdts.size();i++){
        if (pdts.get(i)!="ERRCODE21"){
        %>
        <th> <image src="./Image/<%= pdts.get(i) %>" ></th>
        
          <%
                       if (userA.get(i).equals(userName)){ 
                       %>
                       
         <form class="w3-container" action="./modificarImagen.jsp" method="POST">
                            <input type="hidden" name="titol" value ="<%=titolA.get(i)%>">
                            <input type="hidden" name="descripcio" value ="<%=descripcioA.get(i)%>">
                            <input type="hidden" name="data" value ="<%=datacA.get(i)%>">
                            <input type="hidden" name="tags" value ="<%=tagsA.get(i)%>">
                            <input type="hidden" name="autor" value ="<%=autorA.get(i)%>">
                            <input type="hidden" name="id" value ="<%=idA.get(i)%>">
                <input class="w3-button  w3-light-grey" type="submit" value="Editar">      
            </form> 
       <%
           }
        }   
        else{ 
       %>
        <h4>No hi ha cap imatge relacionada amb la teva cerca</h4>
        <%
     
}
}
}
%>

        
    </body>
</html>

