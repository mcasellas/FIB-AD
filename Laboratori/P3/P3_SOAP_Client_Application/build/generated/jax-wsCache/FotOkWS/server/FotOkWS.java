
package server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FotOkWS", targetNamespace = "http://Server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FotOkWS {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listImages", targetNamespace = "http://Server/", className = "server.ListImages")
    @ResponseWrapper(localName = "listImagesResponse", targetNamespace = "http://Server/", className = "server.ListImagesResponse")
    @Action(input = "http://Server/FotOkWS/listImagesRequest", output = "http://Server/FotOkWS/listImagesResponse")
    public List<Object> listImages();

    /**
     * 
     * @param creaDate
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchByCreaDate", targetNamespace = "http://Server/", className = "server.SearchByCreaDate")
    @ResponseWrapper(localName = "searchByCreaDateResponse", targetNamespace = "http://Server/", className = "server.SearchByCreaDateResponse")
    @Action(input = "http://Server/FotOkWS/searchByCreaDateRequest", output = "http://Server/FotOkWS/searchByCreaDateResponse")
    public List<Object> searchByCreaDate(
        @WebParam(name = "creaDate", targetNamespace = "")
        String creaDate);

    /**
     * 
     * @param keywords
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchByKeywords", targetNamespace = "http://Server/", className = "server.SearchByKeywords")
    @ResponseWrapper(localName = "searchByKeywordsResponse", targetNamespace = "http://Server/", className = "server.SearchByKeywordsResponse")
    @Action(input = "http://Server/FotOkWS/searchByKeywordsRequest", output = "http://Server/FotOkWS/searchByKeywordsResponse")
    public List<Object> searchByKeywords(
        @WebParam(name = "keywords", targetNamespace = "")
        String keywords);

    /**
     * 
     * @param author
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchByAuthor", targetNamespace = "http://Server/", className = "server.SearchByAuthor")
    @ResponseWrapper(localName = "searchByAuthorResponse", targetNamespace = "http://Server/", className = "server.SearchByAuthorResponse")
    @Action(input = "http://Server/FotOkWS/searchByAuthorRequest", output = "http://Server/FotOkWS/searchByAuthorResponse")
    public List<Object> searchByAuthor(
        @WebParam(name = "author", targetNamespace = "")
        String author);

    /**
     * 
     * @param title
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchByTitle", targetNamespace = "http://Server/", className = "server.SearchByTitle")
    @ResponseWrapper(localName = "searchByTitleResponse", targetNamespace = "http://Server/", className = "server.SearchByTitleResponse")
    @Action(input = "http://Server/FotOkWS/searchByTitleRequest", output = "http://Server/FotOkWS/searchByTitleResponse")
    public List<Object> searchByTitle(
        @WebParam(name = "title", targetNamespace = "")
        String title);

    /**
     * 
     * @param id
     * @return
     *     returns server.ImageWS
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchById", targetNamespace = "http://Server/", className = "server.SearchById")
    @ResponseWrapper(localName = "searchByIdResponse", targetNamespace = "http://Server/", className = "server.SearchByIdResponse")
    @Action(input = "http://Server/FotOkWS/searchByIdRequest", output = "http://Server/FotOkWS/searchByIdResponse")
    public ImageWS searchById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param image
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registerImage", targetNamespace = "http://Server/", className = "server.RegisterImage")
    @ResponseWrapper(localName = "registerImageResponse", targetNamespace = "http://Server/", className = "server.RegisterImageResponse")
    @Action(input = "http://Server/FotOkWS/registerImageRequest", output = "http://Server/FotOkWS/registerImageResponse")
    public int registerImage(
        @WebParam(name = "image", targetNamespace = "")
        ImageWS image);

    /**
     * 
     * @param image
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modifyImage", targetNamespace = "http://Server/", className = "server.ModifyImage")
    @ResponseWrapper(localName = "modifyImageResponse", targetNamespace = "http://Server/", className = "server.ModifyImageResponse")
    @Action(input = "http://Server/FotOkWS/modifyImageRequest", output = "http://Server/FotOkWS/modifyImageResponse")
    public int modifyImage(
        @WebParam(name = "image", targetNamespace = "")
        ImageWS image);

}
