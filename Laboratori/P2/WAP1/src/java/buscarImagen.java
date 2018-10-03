/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rando
 */
@WebServlet(urlPatterns = {"/buscarImagen"})
public class buscarImagen extends HttpServlet {


    
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
 
      
        Connection con = null;
        ArrayList<String> ar = new ArrayList<String>();
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);


            String a = request.getParameter("tags");
            String[] parts = a.split(",");
            int i=0;
            int array = parts.length;
            while (i<array){
                try {
                    PreparedStatement getphotos = con.prepareStatement("SELECT filename FROM imatges WHERE titol LIKE ? OR descripcio LIKE ? OR autor LIKE ? OR datac LIKE ? OR tags LIKE ?");

                    String cerca = '%' + parts[i] + '%';
                    getphotos.setString(1, cerca);
                    getphotos.setString(2, cerca);
                    getphotos.setString(3, cerca);
                    getphotos.setString(4, cerca);
                    getphotos.setString(5, cerca);

                    ResultSet rs = getphotos.executeQuery();
                    
                    
                        /*response.setContentType("text/html");
                        try (PrintWriter out = response.getWriter()) {
                            out.println("<html><head><title>Servlet Example</title></head><body>");
                            while (rs.next()){
                                out.println("<h1>" + cerca + "</h1>");
                                out.println("<h1>" + rs.getString("autor") + "</h1>");
                            }
                            
                            out.println("</body></html>");
                        }
                        catch (Exception e){
                            System.err.println(e.getMessage());
                        }
                    */
                    if (!rs.next())ar.add("ERRCODE21");
                    else ar.add(rs.getString(1));
                    
                    while (rs.next())ar.add(rs.getString(1));
                    request.setAttribute("list",ar);
                    RequestDispatcher rd = request.getRequestDispatcher("buscarImagen.jsp");
                    rd.forward(request, response);
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                    //response.sendRedirect("menu.jsp");
                }
                i++;
            }
            //response.sendRedirect("buscarImagenOK.jsp");
        }
        // Connexió Marc
        catch(Exception e) {
            try{
            con = DriverManager.getConnection("jdbc:sqlite:/Users/FotOK.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            }
            catch(Exception ex){
                System.out.println("No s'ha trobat cap imatge amb el teu tag");
            }
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
