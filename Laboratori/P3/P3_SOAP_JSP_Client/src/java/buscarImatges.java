/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import server.FotOkWS_Service;
import server.ImageWS;


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
        List<Object> resultat = new ArrayList<Object>();

        
        switch(accio) {
            case "titol":
                resultat = port.searchByTitle(text);
                break;
            case "autor":
                resultat = port.searchByAuthor(text);
                break;
            case "datac":
                resultat = port.searchByCreaDate(text);
                break;
            case "tags":
                resultat = port.searchByKeywords(text);
                break;
        }
        String estat = "correcte";
        if (resultat.isEmpty()) estat = "error";
        request.setAttribute("estat", estat);
        request.setAttribute("list", resultat);
        

        RequestDispatcher rd = request.getRequestDispatcher("buscarImagenOK.jsp");
        rd.forward(request, response);
             
    }

    }
