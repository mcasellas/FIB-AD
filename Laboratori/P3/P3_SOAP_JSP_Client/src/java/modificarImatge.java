/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/modificarImatge"})
public class modificarImatge extends HttpServlet {

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
        ImageWS imatge = new ImageWS();
        
        imatge.setAutor(request.getParameter("autor"));
        imatge.setDescripcio(request.getParameter("descripcio"));
        imatge.setTags(request.getParameter("tags"));
        imatge.setDatac(request.getParameter("datac"));
        imatge.setTitol(request.getParameter("titol"));
        imatge.setId(Integer.parseInt(request.getParameter("id")));
       
        
        server.FotOkWS port = service.getFotOkWSPort();
        port.modifyImage(imatge);
        
        response.sendRedirect("UploadOK.jsp");
    }

}
