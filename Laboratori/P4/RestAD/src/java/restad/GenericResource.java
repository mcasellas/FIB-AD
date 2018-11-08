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
import java.sql.Statement;
import java.util.Date;
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
+ "             <li ><a href='http://localhost:8080/RestAD/menu.jsp'>Inici</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD/registrarImagen.jsp'>Registrar Imatge</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD/webresources/generic/list'>Llista les imatges</a></li>"
+ "             <li><a href='http://localhost:8080/RestAD/buscarImagen.jsp'>Busca una imatge</a></li>"
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

private String llistarImatges(ResultSet rs) {
    boolean esPrimer = true;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        while (rs.next()) {
         if (esPrimer) {
             esPrimer = false;
             resultat = "";        
         }        
         
         String url = "http://localhost:8080/RestAD/webresources/generic/modify/1";
  
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
  + "        <form class='w3-container' action='http://localhost:8080/RestAD/webresources/generic/modify' method='POST'>"
  + "            <input type='hidden' name='id' value='" + rs.getString("id") + "'>"
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
        System.out.println("Error imprimint");
            
            System.err.println(e.getMessage());
    }
       return resultat;
    
}

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
@FormParam("description") String description, @FormParam("keywords") String keywords, @FormParam("author") String author, @FormParam("creation") String creation) throws ClassNotFoundException{
    Connection con = null;
    String resultat = "<h3>No s'ha pogut enregistrar la imatge<h3>";
    try {
        Date date = new Date();
        long time = date.getTime();
        String timestamp = Long.toString(time);
        String filename = timestamp + ".jpg";
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
        
        int id = 0;
        
        PreparedStatement getid = con.prepareStatement("SELECT MAX(id) FROM imatges");
            ResultSet rs = getid.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            } 

        PreparedStatement pujafoto = con.prepareStatement("INSERT INTO imatges(filename,id,titol,descripcio,tags,autor,datac,timestamp,username) VALUES(?,?,?,?,?,?,?,?,?)");
                pujafoto.setString(1, filename);
                pujafoto.setInt(2, id);
                pujafoto.setString(3, title);
                pujafoto.setString(4, description);
                pujafoto.setString(5, keywords);
                pujafoto.setString(6, author);
                pujafoto.setString(7, creation);
                pujafoto.setString(8, timestamp);
                pujafoto.setString(9, "admin");
                pujafoto.executeUpdate();
       
     

        resultat = "<h3>La imatge s'ha enregistrat correctament<h3>"
+ "<div class='list-group'><div class='list-group'>"
+ "<a href='./registrarImagen.jsp' class='list-group-item active'>"
+ "Registra una altre imatge"
+ "</a>"
+ ""
+ "<a href='./webresources/generic/list' class='list-group-item'>Llista les imatges</a>"
+ ""
+ "</div>";

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Pujar imatge:" + mig + resultat + footer;
}

/**
* GET method to modify by id
* @param id
* @return
*/
@Path("modify")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_HTML)
public String modifyImage (@FormParam("id") int id) throws ClassNotFoundException {
    //TODO write your implementation code here:
        Connection con = null;
        String resultat = "Error";
        try {

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
        
               
            Statement statement = con.createStatement();

            statement.setQueryTimeout(30);

            } catch (SQLException e) {
                System.out.println("No es troba cap base de dades d'usuaris");
                System.err.println(e.getMessage());
            }
            try {
                
                PreparedStatement getImatge = con.prepareStatement("SELECT * FROM IMATGES WHERE ID = ?");
       
                getImatge.setInt(1, id);
                ResultSet rs = getImatge.executeQuery();
                
                while (rs.next()) { 
                    resultat = "<form class='form-signin' action='http://localhost:8080/RestAD/webresources/generic/modify_values/" + rs.getString("id") +"' method='POST'>"
                    + " <input class='form-control' value='" + rs.getString("titol") +  "' type='text' name='title' placeholder='Títol' required>"
                    + "      <input  class='form-control' value='" + rs.getString("descripcio") +  "' type='text' name='description' placeholder='Descripció' required>"
                    + "     <input class='form-control' value='" + rs.getString("tags") +  "' type='text' name='keywords' placeholder='Tags separats amb ;  Exemple: (naturalesa;animals;maincra) ' required>"
                    + "     <input  class='form-control' value='" + rs.getString("autor") +  "' type='text' name='author' placeholder='Autor' required>"
                    + "     <input  class='form-control' value='" + rs.getString("datac") +  "' type='date' name='creation' required>"
                    + " <button class='btn btn-lg btn-primary btn-block' type='submit'>Puja</button>"
                    + "  </form>";
                }
                
                
                
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }

        }
        return banner + "Modificar imatge:" + mig + resultat + footer;
}



/**
* POST method to register a new image
* @param id
* @param title
* @param description
* @param keywords
* @param author
* @param crea_date
* @return
*/
@Path("modify_values/{id}")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_HTML)
public String modifyImage (@PathParam("id") int id, @FormParam("title") String title,
@FormParam("description") String description, @FormParam("keywords") String keywords, @FormParam("author") String author, @FormParam("creation") String creation){
   
        Connection con = null;
        String resultat = "<h3>No s'ha pogut modificar la imatge<h3>";
        try {

            try {
                
                Date date = new Date();
        long time = date.getTime();
        String timestamp = Long.toString(time);
        String filename = timestamp + ".jpg";
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
    
 
        
        PreparedStatement updateFoto = con.prepareStatement("UPDATE IMATGES SET TITOL = ?, DATAC = ?, TAGS = ?, DESCRIPCIO = ?, AUTOR = ? WHERE ID = ?");
                updateFoto.setString(1, title);
                updateFoto.setString(2, creation);
                updateFoto.setString(3, keywords);
                updateFoto.setString(4, description);
                updateFoto.setString(5, author);
                updateFoto.setInt(6, id);
           
                int num = updateFoto.executeUpdate();
                
                
                resultat = "<h3>S'ha modificat la imatge correctament<h3>"
+ "<div class='list-group'><div class='list-group'>"
+ "<a href='./webresources/generic/list' class='list-group-item active'>Llista les imatges</a>"
+ ""
+ "</div>";
       
                
            
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }

        }
        return banner + "Modificar imatges:" + mig + resultat + footer;
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
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

            java.sql.Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            PreparedStatement getid = con.prepareStatement("SELECT * FROM IMATGES ORDER BY ID");
            ResultSet rs = getid.executeQuery();
            
            resultat = llistarImatges(rs);  
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
public String searchByID (@PathParam("id") int id) throws ClassNotFoundException {
    Connection con = null;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

        PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE ID = ?");
       
        getphotos.setInt(1, id);
        ResultSet rs = getphotos.executeQuery();
        resultat = llistarImatges(rs);  

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Buscar imatges per ID:" + mig + resultat + footer;
}
/**
* GET method to search images by title
* @param title
* @return
*/
@Path("searchTitle/{title}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByTitle (@PathParam("title") String title) throws ClassNotFoundException{
    Connection con = null;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

        PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE TITOL LIKE ?");
        String cerca = "%" + title + "%";
        getphotos.setString(1, cerca);
        ResultSet rs = getphotos.executeQuery();
        resultat = llistarImatges(rs);  

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Buscar imatges per títol:" + mig + resultat + footer;
}
/**
* GET method to search images by creation date
* @param creaDate
* @return
*/
@Path("searchCreationDate/{date}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByCreationDate (@PathParam("date") String date) throws ClassNotFoundException{
    Connection con = null;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

        PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE DATAC LIKE ?");
        String cerca = '%' + date + '%';
        getphotos.setString(1, cerca);
        ResultSet rs = getphotos.executeQuery();
        resultat = llistarImatges(rs);  

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Buscar imatges per data de creació:" + mig + resultat + footer;
}
/**
* GET method to search images by author
* @param author
* @return
*/
@Path("searchAuthor/{author}")
@GET
@Produces(MediaType.TEXT_HTML)
public String searchByAuthor (@PathParam("author") String author) throws ClassNotFoundException{
    Connection con = null;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

        PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE AUTOR LIKE ?");
        String cerca = '%' + author + '%';
        getphotos.setString(1, cerca);
        ResultSet rs = getphotos.executeQuery();
        resultat = llistarImatges(rs);  

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Buscar imatges per autor:" + mig + resultat + footer;
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
keywords) throws ClassNotFoundException{
    Connection con = null;
    String resultat = "<h3>No hi han imatges<h3>";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

        PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE TAGS LIKE ?");
        String cerca = '%' + keywords + '%';
        getphotos.setString(1, cerca);
        ResultSet rs = getphotos.executeQuery();
        resultat = llistarImatges(rs);  

    }
    catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            
            System.err.println(e.getMessage());
        }
    return banner + "Buscar imatges per tags:" + mig + resultat + footer;
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
