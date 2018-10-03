<%-- 
    Document   : modificar Imatge
    Created on : 19-sep-2018, 18:20:18
    Author     : rando
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
    
    
        <title>JSP Page</title>
    </head>
    <body>
         <%
                Connection con = null;
                int rss = 0;
                String[] res = null;
                
                try {
                    con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                    Statement statement = con.createStatement();
                    statement.setQueryTimeout(30);
                    PreparedStatement getid = con.prepareStatement("SELECT * FROM imatges WHERE id = 2");
                    ResultSet rs = getid.executeQuery();
                    
                    int i = 0;
                   
                    while (rs.next()){
                        // Inici while
                     %>
                     
        
        <form class="w3-container" method="post" action="registrarImagen" enctype="multipart/form-data">
            <center>
            <input class="w3-input" type="file" id="imatge" name="imatge">
            <input  class="w3-input w3-light-grey" type="text" name="titol" placeholder="Títol" value="<%= rs.getString("titol") %>" required>
            <input  class="w3-input w3-light-grey" type="text" name="descripcio" placeholder="Descripció" value="<%= rs.getString("descripcio") %>" required>
            <input class="w3-input w3-light-grey" type="text" name="tags" placeholder="Tags separats amb ';'  Exemple: (naturalesa;animals;maincra) " value="<%= rs.getString("tags") %>" required>
            <input  class="w3-input w3-light-grey" type="text" name="autor" placeholder="Autor" value="<%= rs.getString("autor") %>" required>
            <input  class="w3-input w3-light-grey" type="date" name="datac" value="<%= rs.getString("datac") %>" required>
            <input type="hidden" name="username" value="<%= rs.getString("username") %>"  >
            <input  class="boto" type="submit" value="Puja">
            </center>
        </form>
                     <%
                     
      
                        i++;
                    }

                }
                catch(Exception e) {
                    System.out.println("Error amb la base de dades");
                    System.err.println(e.getMessage());
                }
                
                finally {
                    try {
                        if(con != null)
                        con.close();
                    }
                    catch(SQLException e) {
                        // connection close failed.
                        System.err.println(e.getMessage());
                    }
                }
                
               

            %>
        
    </body>
</html>

 