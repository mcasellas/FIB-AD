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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FotOK</title>
    </head>
    
            <%
                Connection con = null;
                int rss = 0;
                String []res = null;
               
                
                try {
                    con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                    Statement statement = con.createStatement();
                    statement.setQueryTimeout(30);
                    PreparedStatement getid = con.prepareStatement("SELECT filename FROM imatges");
                    ResultSet rs = getid.executeQuery();
                    
                    rs.last();
                    rss = rs.getRow();
                    res = new String[rss];
                    rs.first();
                    int i = 0;
                    while (rs.next()){
                        res[i] = rs.getString(1);
                        i++;
                    }
                   
                }
                // Connexió Marc
                catch(SQLException e) {
                    try{
                    con = DriverManager.getConnection("jdbc:sqlite:FotOK.db");
                    Statement statement = con.createStatement();
                    statement.setQueryTimeout(30);
                    }
                    catch(SQLException ex){
                        System.out.println("No es troba cap base de dades d'usuaris");
                    }

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
           
            <% 
            for (int i2 = 0; i2 < rss; ++i2){ 
                String hola = res[i2];
            %>
                <div> 
                    <image src="./Image/<%= hola %>" >
                </div>
            <% } %>
        
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