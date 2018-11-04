/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author marccasellas
 */
@Path("generic")
public class GenericResource {
    
    
    
String banner = "<!DOCTYPE html>" 
+ " <html lang='en'>"
+ "   <head>"
+ "     <meta charset='utf-8'>"
+ "     <meta http-equiv='X-UA-Compatible' content='IE=edge'>"
+ "     <meta name='viewport' content='width=device-width, initial-scale=1'>"
+ "     <meta name='description' content=''>"
+ "     <meta name='author' content=''>"
+ "     <title>FotOK</title>"
+ "     <link href='http://localhost:8080/RestAD/css/bootstrap.min.css' rel='stylesheet'>"
+ "     <link href='http://localhost:8080/RestAD/css/bootstrap-theme.min.css' rel='stylesheet'>"
+ "     <link href='http://localhost:8080/RestAD/theme.css' rel='stylesheet'>"
+ " <link rel='shortcut icon' href='./favicon.ico'>"
+ "   </head>"
+ "   <body>"
+ "     <nav class='navbar navbar-inverse navbar-fixed-top'>"
+ "       <div class='container'>"
+ "         <div class='navbar-header'>"
+ "           <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='f"
+ "             <span class='sr-only'>Toggle navigation</span>"
+ "             <span class='icon-bar'></span>"
+ "             <span class='icon-bar'></span>"
+ "             <span class='icon-bar'></span>"
+ "           </button>"
+ "           <a class='navbar-brand' href='#'>FotOK</a>"
+ "         </div>"
+ "         <div id='navbar' class='navbar-collapse collapse'>"
+ "           <ul class='nav navbar-nav'>"
+ "             <li ><a href='http://localhost:8080/RestAD//menu.jsp'>Inici</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD//registrarImagen.jsp'>Registrar Imatge</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD//list.jsp'>Llista les imatges</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD//buscarImagen.jsp'>Busca una imatge</a></li>"
+ "             <li><form class='form-signin' action='logout' method='POST'>"
+ "      "
+ "        "
+ "    "
+ "       </form> </li>"
+ "           </ul>"
+ "         </div><!--/.nav-collapse -->"
+ "       </div>"
+ "     </nav>"
+ "     <div class='container theme-showcase' role='main'>"
+ "       <div class='page-header'>"
+ "         <h1>";

String mig = "</h1>"
+ "       </div>"
+ "       "
+ "       <div class='row'>";

String footer = "</div>"
+ "</div>"
+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
+ "<script>window.jQuery || document.write(\'<script src=\"http://localhost:8080/RestAD/../../assets/js/vendor/jquery.min.js\"/>\')</script>"
+ "<script src='http://localhost:8080/RestAD/js/bootstrap.min.js'></script>"
+ "<script src='http://localhost:8080/RestAD/js/docs.min.js'></script>"
+ "<script src='http://localhost:8080/RestAD/js/ie10-viewport-bug-workaround.js'></script>"
+ "</body>"
+ "</html>";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of restad.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        
        
        return banner + "Llistar imatges:" + mig + footer;
        //throw new UnsupportedOperationException();
    }
    
    /**
* POST method to register a new image
* @param title
* @param description
* @param keywords
* @param author
* @param crea_date
* @return
*/
@Path("register")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_HTML)
public String registerImage (@FormParam("title") String title,
@FormParam("description") String description, @FormParam("keywords") String keywords, @FormParam("author") String author, @FormParam("creation") String crea_date){
    return null;
}
/**
* POST method to register a new image
* @param title
* @param description
* @param keywords
* @param author
* @param crea_date
* @return
*/
@Path("modify")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_HTML)
public String modifyImage (@FormParam("title") String title,
@FormParam("description") String description, @FormParam("keywords") String keywords, @FormParam("author") String author, @FormParam("creation") String crea_date){
    return null;
}
   /**
    * GET method to list images
    * @return
    */
    @Path("list")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String listImages () throws ClassNotFoundException {
        Connection con = null;
        String resultat = "<h3>No hi han imatges<h3>";
        Boolean esPrimer = true;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

            java.sql.Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            PreparedStatement getid = con.prepareStatement("SELECT * FROM IMATGES ORDER BY ID");
            ResultSet rs = getid.executeQuery();
            
            while (rs.next()) {
         if (esPrimer) {
             esPrimer = false;
             resultat = "";        
         }        
         resultat += "<div class='row'>"
  + "    <div class='col-sm-6'>"
  + "      <img src='http://localhost:8080/RestAD/Image/" + rs.getString("filename") +  "' class='img-thumbnail' >"
+ ""
  + "    </div><!-- /.col-sm-4 -->"
  + "    <div class='col-sm-6'>"
  + "        <ul class='list-group'>"
  + "        <li class='list-group-item'>Títol: " + rs.getString("titol") +  "</li>"
  + "        <li class='list-group-item'>Data creació: " + rs.getString("datac") +  "</li>"
  + "        <li class='list-group-item'>Descripció: " + rs.getString("descripcio") +  "</li>"
  + "        <li class='list-group-item'>Autor: " + rs.getString("autor") +  "</li>"
  + "        <li class='list-group-item'>Tags: " + rs.getString("tags") +  "</li>"
  + "      </ul>"
  + "        <form class='w3-container' action='./modificarImagen.jsp' method='POST'>"
  + "            <input type='hidden' name='id' value ='<%= mobj.getId() %>'>"
  + "            <p>"
  + "                <button type='submit' class='btn btn-sm btn-primary'>Editar</button>"
  + "            </p>"
  + "        </form> "
  + "    </div><!-- /.col-sm-4 -->"
  + "    "
  + "  </div>       ";
        
  
         

            }
        }
        catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
           
        
        return banner + "Llistar imatges:" + mig + resultat + footer;
          
            
        
    }
/**
* GET method to search images by id
* @param id
* @return
*/
@Path("searchID/{id}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByID (@PathParam("id") int id){
    return null;
}
/**
* GET method to search images by title
* @param title
* @return
*/
@Path("searchTitle/{title}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByTitle (@PathParam("title") String title){
    return null;
}
/**
* GET method to search images by creation date
* @param creaDate
* @return
*/
@Path("searchCreationDate/{date}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByCreationDate (@PathParam("date") String date){
    return null;
}
/**
* GET method to search images by author
* @param author
* @return
*/
@Path("searchAuthor/{author}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByAuthor (@PathParam("author") String author){
    return null;
}
/**
* GET method to search images by keyword
* @param keywords
* @return
*/
@Path("searchKeywords/{keywords}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByKeywords (@PathParam("keywords") String
keywords){
    return null;
}

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
