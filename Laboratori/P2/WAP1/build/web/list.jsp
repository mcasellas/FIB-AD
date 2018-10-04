<%-- 
    Document   : list
    Created on : 03-oct-2018, 12:26:40
    Author     : rando
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.PreparedStatement"%>
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
        <title>FotOK</title>
    </head>
    
            <%
                Connection con = null;
                int rss = 0;
                String[] res = null;
                
                try {
                    con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                    Statement statement = con.createStatement();
                    statement.setQueryTimeout(30);
                    PreparedStatement getid = con.prepareStatement("SELECT * FROM imatges");
                    ResultSet rs = getid.executeQuery();
                    
                    int i = 0;
                    %>
                    
                    <table style="width:100%">
                    
                    
                    <%
                    while (rs.next()){
                        // Inici while
                        %>
                       <tr> 
    <th> <image src="./Image/<%= rs.getString("filename") %>" ></th>
    <th>
        <p>Títol: <%= rs.getString("titol") %></p>
        <p>Data creació: <%= rs.getString("datac") %></p>
        <p>Usuari: <%= rs.getString("username") %></p>
        <p>Tags: <%= rs.getString("tags") %></p>
    
        <%
                       if (rs.getString("username").equals(userName)){ 
                       %>
                        <form class="w3-container" action="./modificarImagen.jsp" method="POST">
                            <input type="hidden" name="titol" value ="<%=rs.getString("titol")%>">
                            <input type="hidden" name="descripcio" value ="<%=rs.getString("descripcio")%>">
                            <input type="hidden" name="data" value ="<%=rs.getString("datac")%>">
                            <input type="hidden" name="tags" value ="<%=rs.getString("tags")%>">
                            <input type="hidden" name="autor" value ="<%=rs.getString("autor")%>">
                            <input type="hidden" name="id" value="<%= rs.getInt("id")%>">
                <input class="w3-button  w3-light-grey" type="submit" value="Editar">      
            </form> 
                        <%
                        }
                        %>
    </th> 
   
  </tr>
  
   
                        
                      
  <%
      
                        i++;
                    }
%>
</table> 
<%
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
           
            
        
</html>

  