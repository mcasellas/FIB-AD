/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rando
 */
@WebServlet( name="login", urlPatterns = {"/login"})
public class login extends HttpServlet {
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
        
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
            
            // Connexió Sergi
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rando\\OneDrive\\Documents\\GitHub\\FIB-AD\\Laboratori\\P2\\WAP1\\FotOK.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);
            }
            // Connexió Marc
            catch(Exception e) {
                try{
                connection = DriverManager.getConnection("jdbc:sqlite:FotOK.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);
                }
                catch(Exception ex){
                    System.out.println("No es troba cap base de dades d'usuaris");
                }
                
            }
                
       
            
            
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM username WHERE username = ? AND password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet rs = preparedStatement.executeQuery();
        
        Statement stmts = (Statement) connection.createStatement();
        
            if(rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                Cookie userName = new Cookie("username",username);
                userName.setMaxAge(30*60);
                response.addCookie(userName);
               response.sendRedirect("menu.jsp");
            }
            else {
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
               out.println("Username or Password incorrect");
               response.sendRedirect("login.jsp");
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
          System.err.println(e.getMessage());
        }   
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
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
