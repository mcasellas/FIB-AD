/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import server.FotOkWS_Service;

/**
 *
 * @author marccasellas
 */
@WebServlet(urlPatterns = {"/buscarImatges"})
public class buscarImatges extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/FotOkWS.wsdl")
    private FotOkWS_Service service;


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
        String accio = request.getParameter("accio");
        String text = request.getParameter("text");
        
        server.FotOkWS port = service.getFotOkWSPort();
        
        switch(accio) {
            case "titol":
                port.searchByTitle(text);
                break;
            case "autor":
                port.searchByAuthor(text);
                break;
            case "datac":
                port.searchByCreaDate(text);
                break;
            case "tags":
                port.searchByKeywords(text);
                break;
        }
    }

    private java.util.List<java.lang.Object> searchByCreaDate(java.lang.String creaDate) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchByCreaDate(creaDate);
    }



    

}
