/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author marccasellas
 */
@WebService(serviceName = "FotOkWS")
public class FotOkWS {

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "listImages")
    public List listImages() {

        Connection con = null;
        List<ImageWS> resultat = new ArrayList<ImageWS>();

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");

            java.sql.Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            PreparedStatement getid = con.prepareStatement("SELECT * FROM IMATGES ORDER BY ID");
            ResultSet rs = getid.executeQuery();

            // int i = 0;
            while (rs.next()) {
                ImageWS temp = new ImageWS();
                temp.filename = rs.getString("filename");
                temp.id = rs.getInt("id");
                temp.titol = rs.getString("titol");
                temp.descripcio = rs.getString("descripcio");
                temp.tags = rs.getString("tags");
                temp.autor = rs.getString("autor");
                temp.datac = rs.getString("datac");
                temp.timestamp = rs.getString("timestamp");
                temp.username = rs.getString("username");

                resultat.add(temp);
            }
            //i+;
        } catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            System.err.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return null;
            }
        }

        return resultat;
    }

    /**
     * Web service operation
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "searchById")
    public ImageWS searchById(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Connection con = null;
        ImageWS temp = new ImageWS();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            java.sql.Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            PreparedStatement getid = con.prepareStatement("SELECT * FROM imatges WHERE id = ?");
            getid.setInt(1, id);
            ResultSet rs = getid.executeQuery();
            if (rs.next()) {
                temp.filename = rs.getString("filename");
                temp.id = rs.getInt("id");
                temp.titol = rs.getString("titol");
                temp.descripcio = rs.getString("descripcio");
                temp.tags = rs.getString("tags");
                temp.autor = rs.getString("autor");
                temp.datac = rs.getString("datac");
                temp.timestamp = rs.getString("timestamp");
                temp.username = rs.getString("username");
            }
        } catch (SQLException e) {
            System.out.println("Error amb la base de dades");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
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
        return temp;
    }

    /**
     * Web service operation
     *
     * @param image
     * @return
     */
    @WebMethod(operationName = "registerImage")
    public int registerImage(@WebParam(name = "image") ImageWS image) {

        Date date = new Date();
        long time = date.getTime();
        String timestamp = Long.toString(time);
        Connection conn = null;
        int id;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);

            PreparedStatement getid = conn.prepareStatement("SELECT MAX(id) FROM imatges");
            ResultSet rs = getid.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            } else {
                id = 0;
            }
            
            String filename = timestamp + ".jpg";

            try {
                PreparedStatement pujafoto = conn.prepareStatement("INSERT INTO imatges(filename,id,titol,descripcio,tags,autor,datac,timestamp,username) VALUES(?,?,?,?,?,?,?,?,?)");
                pujafoto.setString(1, filename);
                pujafoto.setInt(2, id);
                pujafoto.setString(3, image.getTitol());
                pujafoto.setString(4, image.getDescripcio());
                pujafoto.setString(5, image.getTags());
                pujafoto.setString(6, image.getAutor());
                pujafoto.setString(7, image.getDatac());
                pujafoto.setString(8, timestamp);
                pujafoto.setString(9, image.getUsername());
                pujafoto.executeUpdate();

            } catch (SQLException e) {
                return 0;
            }

        } catch (SQLException ex) {
            System.out.println("No es troba cap base de dades d'usuaris");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return 0;
            }
        }

        return 1;
    }

    /**
     * Web service operation
     *
     * @param image
     * @return
     */
    @WebMethod(operationName = "modifyImage")
    public int modifyImage(@WebParam(name = "image") ImageWS image) {
        //TODO write your implementation code here:
        Connection con = null;
        try {

            try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");


            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = con.createStatement();

                statement.setQueryTimeout(30);

            } catch (SQLException e) {
                System.out.println("No es troba cap base de dades d'usuaris");
                return 0;
            }
            try {
                PreparedStatement pujafoto = con.prepareStatement("UPDATE Imatges SET titol = ?, datac = ?, tags = ?, descripcio = ?, autor = ? WHERE id = ?");
                pujafoto.setString(1, image.getTitol());
                pujafoto.setString(2, image.getDatac());
                pujafoto.setString(3, image.getTags());
                pujafoto.setString(4, image.getDescripcio());
                pujafoto.setString(5, image.getAutor());
                pujafoto.setInt(6, image.getId());
                pujafoto.executeUpdate();
            } catch (SQLException e) {
                return 0;
            }
        } catch (ClassNotFoundException ex) {
            return 0;
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
        return 1;
    }

    /**
     * Web service operation
     *
     * @param title
     * @return
     */
    @WebMethod(operationName = "searchByTitle")
    public List searchByTitle(@WebParam(name = "title") String title) {
        //TODO write your implementation code here:
        Connection con = null;
        ArrayList<ImageWS> resultat = new ArrayList<ImageWS>();
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            try {
                PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE titol LIKE ?");
                getphotos.setString(1, title);
                ResultSet rs = getphotos.executeQuery();
                while (rs.next()) {
                    ImageWS temp = new ImageWS();
                    temp.filename = rs.getString("filename");
                    temp.id = rs.getInt("id");
                    temp.titol = rs.getString("titol");
                    temp.descripcio = rs.getString("descripcio");
                    temp.tags = rs.getString("tags");
                    temp.autor = rs.getString("autor");
                    temp.datac = rs.getString("datac");
                    temp.timestamp = rs.getString("timestamp");
                    temp.username = rs.getString("username");

                    resultat.add(temp);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }


        }
        catch (SQLException e){
                    System.err.println(e.getMessage());
                    return null;
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {

            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return null;
            }
        }

        return resultat;
    }

    /**
     * Web service operation
     *
     * @param creaDate
     * @return
     */
    @WebMethod(operationName = "searchByCreaDate")
    public List searchByCreaDate(@WebParam(name = "creaDate") String creaDate) {
        //TODO write your implementation code here:

            Connection con = null;
        ArrayList<ImageWS> resultat = new ArrayList<ImageWS>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            try {
                PreparedStatement getphotos = con.prepareStatement("SELECT * FROM imatges WHERE datac LIKE ?");
                String cerca = '%' + creaDate + '%';
                getphotos.setString(1, cerca);
                ResultSet rs = getphotos.executeQuery();
                while (rs.next()) {
                    ImageWS temp = new ImageWS();
                    temp.filename = rs.getString("filename");
                    temp.id = rs.getInt("id");
                    temp.titol = rs.getString("titol");
                    temp.descripcio = rs.getString("descripcio");
                    temp.tags = rs.getString("tags");
                    temp.autor = rs.getString("autor");
                    temp.datac = rs.getString("datac");
                    temp.timestamp = rs.getString("timestamp");
                    temp.username = rs.getString("username");

                    resultat.add(temp);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }


        }
        catch (SQLException e){
                    System.err.println(e.getMessage());
                    return null;
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {

            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return null;
            }
        }

        return resultat;
    }

    /**
     * Web service operation
     *
     * @param author
     * @return
     */
    @WebMethod(operationName = "searchByAuthor")
    public List searchByAuthor(@WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        Connection con = null;
        ArrayList<ImageWS> resultat = new ArrayList<ImageWS>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            try {
                PreparedStatement getphotos = con.prepareStatement("SELECT * FROM IMATGES WHERE AUTOR LIKE ?");
                String cerca = '%' + author + '%';
                getphotos.setString(1, cerca);
                ResultSet rs = getphotos.executeQuery();
                while (rs.next()) {
                    ImageWS temp = new ImageWS();
                    temp.filename = rs.getString("filename");
                    temp.id = rs.getInt("id");
                    temp.titol = rs.getString("titol");
                    temp.descripcio = rs.getString("descripcio");
                    temp.tags = rs.getString("tags");
                    temp.autor = rs.getString("autor");
                    temp.datac = rs.getString("datac");
                    temp.timestamp = rs.getString("timestamp");
                    temp.username = rs.getString("username");

                    resultat.add(temp);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }


        }
        catch (SQLException e){
                    System.err.println(e.getMessage());
                    return null;
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {

            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return null;
            }
        }

        return resultat;
    }

    /**
     * Web service operation
     *
     * @param keywords
     * @return
     */
    @WebMethod(operationName = "searchByKeywords")
    public List searchByKeywords(@WebParam(name = "keywords") String keywords) {
        //TODO write your implementation code here:
        Connection con = null;
        List<ImageWS> resultat = new ArrayList<ImageWS>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FotOK;user=mcasellas;password=1234");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            try {
                PreparedStatement getphotos = con.prepareStatement("SELECT * FROM IMATGES WHERE tags LIKE ?");
                String cerca = '%' + keywords + '%';
                getphotos.setString(1, cerca);
                ResultSet rs = getphotos.executeQuery();
                while (rs.next()) {
                    ImageWS temp = new ImageWS();
                    temp.filename = rs.getString("filename");
                    temp.id = rs.getInt("id");
                    temp.titol = rs.getString("titol");
                    temp.descripcio = rs.getString("descripcio");
                    temp.tags = rs.getString("tags");
                    temp.autor = rs.getString("autor");
                    temp.datac = rs.getString("datac");
                    temp.timestamp = rs.getString("timestamp");
                    temp.username = rs.getString("username");

                    resultat.add(temp);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }


        }
        catch (SQLException e){
                    System.err.println(e.getMessage());
                    return null;
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(FotOkWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {

            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
                return null;
            }
        }
        return resultat;
    }
}
