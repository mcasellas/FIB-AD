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
        ArrayList<String> filenameA = new ArrayList<String>();
        ArrayList<String> titolA = new ArrayList<String>();
        ArrayList<String> descripcioA = new ArrayList<String>();
        ArrayList<String> tagsA = new ArrayList<String>();
        ArrayList<String> autorA = new ArrayList<String>();
        ArrayList<String> datacA = new ArrayList<String>();
        ArrayList<String> userA = new ArrayList<String>();
       ArrayList<Integer> idA = new ArrayList<Integer>();
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
                    PreparedStatement getphotos = con.prepareStatement("SELECT filename,titol,descripcio,tags,autor,datac,username,id FROM imatges WHERE titol LIKE ? OR descripcio LIKE ? OR autor LIKE ? OR datac LIKE ? OR tags LIKE ? ORDER BY datac DESC");

                    String cerca = '%' + parts[i] + '%';
                    getphotos.setString(1, cerca);
                    getphotos.setString(2, cerca);
                    getphotos.setString(3, cerca);
                    getphotos.setString(4, cerca);
                    getphotos.setString(5, cerca);

                    ResultSet rs = getphotos.executeQuery();
                      
                    if (!rs.next())filenameA.add("ERRCODE21");
                    else{
                        filenameA.add(rs.getString(1));
                        titolA.add(rs.getString(2));
                        descripcioA.add(rs.getString(3));
                        tagsA.add(rs.getString(4));
                        autorA.add(rs.getString(5));
                        datacA.add(rs.getString(6));
                        userA.add(rs.getString(7));
                        idA.add(rs.getInt(8));
                    }
                    
                    while (rs.next())
                    {
                        filenameA.add(rs.getString(1));
                        titolA.add(rs.getString(2));
                        descripcioA.add(rs.getString(3));
                        tagsA.add(rs.getString(4));
                        autorA.add(rs.getString(5));
                        datacA.add(rs.getString(6));
                        userA.add(rs.getString(7));
                        idA.add(rs.getInt(8));
                    }
                    request.setAttribute("list",filenameA);
                    request.setAttribute("titol",titolA);
                    request.setAttribute("descripcio",descripcioA);
                    request.setAttribute("tags",tagsA);
                    request.setAttribute("autor",autorA);
                    request.setAttribute("datac",datacA);
                    request.setAttribute("user",userA);
                    request.setAttribute("id",idA);
                    RequestDispatcher rd = request.getRequestDispatcher("buscarImagen.jsp");
                    rd.forward(request, response);
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                    //response.sendRedirect("menu.jsp");
                }
                i++;
            }
            response.sendRedirect("buscarImagenOK.jsp");
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
