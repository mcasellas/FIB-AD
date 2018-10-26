<%@page import="server.ImageWS"%>
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
            <li ><a href="#">Inici</a></li>
            <li class="active"><a href="./registrarImagen.jsp">Registrar Imatge</a></li>
            <li><a href="./list.jsp">Llista les imatges</a></li>
            <li><a href="./buscarImagen.jsp">Busca una imatge</a></li>
           
     
       
        <button class="btn btn-sm btn-warning btn-block" type="submit">Logout</button>
      </form> </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

     
      <div class="page-header">
        <h1>Modificar imatge:</h1>
      </div>
       <%
       
        int id = Integer.parseInt(request.getParameter("id"));
        ImageWS imatge = new ImageWS();
        
        server.FotOkWS_Service service = new server.FotOkWS_Service();
	server.FotOkWS port = service.getFotOkWSPort();
	 
	server.ImageWS result = port.searchById(id);
        
       %>
      <div class="row">
        
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Editar imatge</h3>
            </div>
            <div class="panel-body">
              <form class="form-signin" action="modificarImatge" method="POST" >
     
        
           
            <input class="form-control" type="text" name="titol" placeholder="Títol" value="<%= result.getTitol() %>" required>
            <input  class="form-control" type="text" name="descripcio" placeholder="Descripció" value="<%= result.getDescripcio() %>" required>
            <input class="form-control" type="text" name="tags" placeholder="Tags separats amb ';'  Exemple: (naturalesa;animals;maincra) " value="<%= result.getTags() %>" required>
            <input  class="form-control" type="text" name="autor" placeholder="Autor" value="<%= result.getAutor() %>" required>
            <input  class="form-control" type="date" name="datac" value="<%= result.getDatac() %>" required>
            <input type="hidden" name="id" value="<%= id %>"  >


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
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
