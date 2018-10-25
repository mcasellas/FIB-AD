<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

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
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>FotOK</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="theme.css" rel="stylesheet">
<link rel="shortcut icon" href="./favicon.ico">
  </head>

  <body>
   
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">FotOK</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="./menu.jsp">Inici</a></li>
            <li><a href="./registrarImagen.jsp">Registrar Imatge</a></li>
            <li class="active"><a href="./list.jsp">Llista les imatges</a></li>
            <li><a href="./buscarImagen.jsp">Busca una imatge</a></li>
            <li><form class="form-signin" action="logout" method="POST">
     
       
        <button class="btn btn-sm btn-warning btn-block" type="submit">Logout</button>
      </form> </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      

      
      <div class="page-header">
        <h1>Llistar imatges:</h1>
      </div>
      
      <div class="row">
        
          <%
                Connection con = null;
                int rss = 0;
                String[] res = null;
                
                try {
                    con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                    Statement statement = con.createStatement();
                    statement.setQueryTimeout(30);
                    PreparedStatement getid = con.prepareStatement("SELECT * FROM imatges ORDER BY datac DESC");
                    ResultSet rs = getid.executeQuery();
                    
                    int i = 0;
                  
                    while (rs.next()){
                        // Inici while
                        %>
                        <div class="row">
       
        <div class="col-sm-6">
          <img src="./Image/<%= rs.getString("filename") %>" class="img-thumbnail" >

        </div><!-- /.col-sm-4 -->
        <div class="col-sm-6">
            <ul class="list-group">
            <li class="list-group-item">Títol: <%= rs.getString("titol") %></li>
            <li class="list-group-item">Data creació: <%= rs.getString("datac") %></li>
            <li class="list-group-item">Descripció: <%= rs.getString("descripcio") %></li>
            <li class="list-group-item">Autor: <%= rs.getString("autor") %></li>
            <li class="list-group-item">Tags: <%= rs.getString("tags") %></li>
          </ul>
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
                            <input type="hidden" name="filename" value="<%= rs.getString("filename")%>">
                            <p>
        
        <button type="submit" class="btn btn-sm btn-primary">Editar</button>
        
      </p>
                
            </form> 
                        <%
                        }
                     %>
        </div><!-- /.col-sm-4 -->
      </div>
                   
    
       
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
        
      </div>
      
      
      


    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
