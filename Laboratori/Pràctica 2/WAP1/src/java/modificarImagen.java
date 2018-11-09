/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rando
 */
@WebServlet(name = "modificarImagen", urlPatterns = {"/modificarImagen"})
public class modificarImagen extends HttpServlet {
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
                
                
                Connection conn = null;
                int id = -1;
            try {
                
                Class.forName("org.sqlite.JDBC");
                
                
                
                // Connexió Sergi
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                    Statement statement = conn.createStatement();
                    statement.setQueryTimeout(30);
                    
                    
                }
                catch(SQLException e){
                    System.out.println("No es troba cap base de dades d'usuaris");
                }
                
                String titol = request.getParameter("titol");
                String data = request.getParameter("datac");
                String tag =  request.getParameter("tags");
                String descripcio =  request.getParameter("descripcio");
                String autor=  request.getParameter("autor");
                id = Integer.parseInt(request.getParameter("id"));
               
                
                
               

                try{
                PreparedStatement pujafoto = conn.prepareStatement("UPDATE Imatges SET titol = ?, datac = ?, tags = ?, descripcio = ?, autor = ? WHERE id = ?");
                pujafoto.setString(1,titol);
                pujafoto.setString(2,data);
                pujafoto.setString(3,tag);
                pujafoto.setString(4,descripcio);
                pujafoto.setString(5,autor);
                pujafoto.setInt(6,id);
                pujafoto.executeUpdate();
                }
                catch(SQLException e){
                     response.sendRedirect("error.jsp");
                }
            }
            catch(ClassNotFoundException ex){
                Logger.getLogger(modificarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            finally{
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
                    
                    response.sendRedirect("list.jsp");
                }
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
