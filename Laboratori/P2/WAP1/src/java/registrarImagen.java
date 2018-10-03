/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.Date;
import javax.servlet.http.Cookie;

/**
 *
 * @author rando
 */
@WebServlet(name="registrarImagen", urlPatterns = {"/registrarImagen"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class registrarImagen extends HttpServlet {
    
       private final static Logger LOGGER =
       Logger.getLogger(FileUploadServlet.class.getCanonicalName());

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");

    // Create path components to save the file
    final String path = ("C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\web\\Image");
    final Part filePart = request.getPart("imatge");
    String fileName = getFileName(filePart);  
    int id;
    String titol = request.getParameter("titol");
    String descripcio = request.getParameter("descripcio");
    String tags = request.getParameter("tags");
    String autor = request.getParameter("autor");
    String datac = request.getParameter("datac");
    
    String user=null;
     Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")) user = cookie.getValue();
        }
        }
        
    Date date= new Date();
    long time = date.getTime();
    String timestap = Long.toString(time);
    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();
    Connection conn = null;
    
    
     int lastDot = fileName.lastIndexOf('.');
    fileName = timestap + fileName.substring(lastDot);
    
    try {
        
        Class.forName("org.sqlite.JDBC");
            
            // Connexió Sergi
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                Statement statement = conn.createStatement();
                statement.setQueryTimeout(30);
            }
            // Connexió Marc
            catch(SQLException e) {
                try{
                conn = DriverManager.getConnection("jdbc:sqlite:FotOK.db");
                Statement statement = conn.createStatement();
                statement.setQueryTimeout(30);
                }
                catch(SQLException ex){
                    System.out.println("No es troba cap base de dades d'usuaris");
                }
                
            }
            
        PreparedStatement getid = conn.prepareStatement("SELECT MAX(id) FROM imatges");
        ResultSet rs = getid.executeQuery();
        if(rs.next()) id = rs.getInt(1)+1;
        else id=0;
        
        
        PreparedStatement pujafoto = conn.prepareStatement("INSERT INTO imatges(filename,id,titol,descripcio,tags,autor,datac,timestap,username) VALUES(?,?,?,?,?,?,?,?,?)");
        pujafoto.setString(1,fileName);
        pujafoto.setInt(2,id);
        pujafoto.setString(3,titol);
        pujafoto.setString(4,descripcio);
        pujafoto.setString(5,tags);
        pujafoto.setString(6,autor);
        pujafoto.setString(7,datac);
        pujafoto.setString(8,timestap);
        pujafoto.setString(9,user);
        pujafoto.executeUpdate();
       
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        writer.println("New file " + fileName + " created at " + path);
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                new Object[]{fileName, path});
         response.sendRedirect("UploadOK.jsp");
    } 
    
    
    catch (FileNotFoundException fne) {
        writer.println("You either did not specify a file to upload or are "
                + "trying to upload a file to a protected or nonexistent "
                + "location.");
        writer.println("<br/> ERROR: " + fne.getMessage());

        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                new Object[]{fne.getMessage()});
    }      catch (SQLException ex) {
               Logger.getLogger(registrarImagen.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(registrarImagen.class.getName()).log(Level.SEVERE, null, ex);
           } finally {
        if (out != null) {
            out.close();
        }
        if (filecontent != null) {
            filecontent.close();
        }
        if (writer != null) {
            writer.close();
        }
         try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }  
    }
     
}

private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
