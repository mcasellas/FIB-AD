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
    <link href="/RestAD/css/bootstrap.min.css" rel="stylesheet">
    <link href="/RestAD/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="theme.css" rel="stylesheet">

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
          <a class="navbar-brand" href="/RestAD/menu.jsp">FotOK</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="./menu.jsp">Inici</a></li>
            <li class="active"><a href="./registrarImagen.jsp">Registrar Imatge</a></li>
            <li><a href="./webresources/generic/list">Llista les imatges</a></li>
            <li><a href="./buscarImagen.jsp">Busca una imatge</a></li>
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
        <h1>Registrar imatge:</h1>
      </div>
      
      <div class="row">
        
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Nova imatge</h3>
            </div>
            <div class="panel-body">
            <form class="form-signin" action="./webresources/generic/register" method="POST" enctype="multipart/form-data">
     
        
            <input type="file" name="file"> <br>
            <input class="form-control" type="text" name="title" placeholder="T�tol" required>
            <input  class="form-control" type="text" name="description" placeholder="Descripci�" required>
            <input class="form-control" type="text" name="keywords" placeholder="Tags separats amb ';'  Exemple: (naturalesa;animals;maincra) " required>
            <input  class="form-control" type="text" name="author" placeholder="Autor" required>
            <input  class="form-control" type="date" name="creation" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Puja</button>
      </form>         
            </div>
          </div>
      </div>
        
        
    

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="/RestAD/js/bootstrap.min.js"></script>
    <script src="/RestAD/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/RestAD/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
