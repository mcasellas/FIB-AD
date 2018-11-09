<%@page import="java.util.ArrayList"%>
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
            <li><a href="./menu.jsp">Inici</a></li>
            <li><a href="./registrarImagen.jsp">Registrar Imatge</a></li>
            <li><a href="./webresources/generic/list">Llista les imatges</a></li>
            <li class="active"><a href="./buscarImagen.jsp">Busca una imatge</a></li>
            <li>
                <form class="form-signin" action="logout" method="POST"></form> 
            </li>
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
        
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Nova imatge</h3>
            </div>
            <div class="panel-body">
              <form onchange="afegirPath()" id="formulari" class="form-signin" action="./webresources/generic/searchByID/" method="GET">
               <select name="accio" id="accio">
                <option value="ID">Id</option>
                <option value="Title">Titol</option>
                <option value="Author">Autor</option>
                <option value="CreationDate">Data de creació</option>
                <option value="Keywords">Tags</option>
            </select> 
            <input class="form-control" type="number" id="text" name="text" required autofocus>
            

        <button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
      </form>
               
            </div>
          </div>
          
       
        
      </div>
      
      
      
   

    </div> <!-- /container -->
    <script>
        function afegirPath() {
            var accio = document.getElementById("accio").value;
            
            document.getElementById("text").type = accio == "ID" ? "number" : "text";
            
            var data = document.getElementById("text").value;
            var result = "./webresources/generic/search" + accio + '/' + data;
            document.getElementById("formulari").action = result;
        }
    </script>

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
