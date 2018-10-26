<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="server.ImageWS"%>
<%@page import="server.ImageWS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


    
    
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
            <li ><a href="./list.jsp">Llista les imatges</a></li>
            <li class="active"><a href="./buscarImagen.jsp">Busca una imatge</a></li>
            <li><form class="form-signin" action="logout" method="POST">
     
       
       
      </form> </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      

      
      <div class="page-header">
        <h1>Buscar imatges:</h1>
      </div>
      
      <div class="row">
        
            
<%  
    String estat = (String) request.getAttribute("estat");
    
    if (estat != "error") {
    List<ImageWS> resultat = (List<ImageWS>) request.getAttribute("list");
    
    Iterator<ImageWS> it = resultat.iterator();
                
           
    while (it.hasNext()) {
       Object image = it.next();
                    ImageWS mobj = ImageWS.class.cast(image);
        %>
            <div class="row">
       
                <div class="col-sm-6">
                  <img src="./Image/<%= mobj.getFilename() %>" data-src="holder.js/200x200" class="img-thumbnail" >
                </div><!-- /.col-sm-4 -->
                <div class="col-sm-6">
            <ul class="list-group">
            <li class="list-group-item">Títol: <%= mobj.getTitol() %></li>
            <li class="list-group-item">Data creació: <%= mobj.getDatac() %></li>
            <li class="list-group-item">Descripció: <%= mobj.getDescripcio() %></li>
            <li class="list-group-item">Autor: <%= mobj.getAutor() %></li>
            <li class="list-group-item">Tags: <%= mobj.getTags() %></li>
          </ul>
        
                
</div>  
<%
            }
}
else {
%>
<div class="row">
        
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">No s'ha trobat cap coincidència. Torna-ho a provar.</h3>
            </div>
            <div class="panel-body">
              <form class="form-signin" action="buscarImatges" method="POST">
                
           
            
            <input class="form-control" type="text" id="text" name="text" required autofocus>
            <select name="accio" id="accio">
                <option value="titol">Titol</option>
                <option value="autor">Autor</option>
                <option value="datac">Data de creació</option>
                <option value="tags">Tags</option>
            </select>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
      </form>
                
      
            </div>
          </div>
          
       
        
      </div>
<%
            }

%>
   
     
      </div>

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
