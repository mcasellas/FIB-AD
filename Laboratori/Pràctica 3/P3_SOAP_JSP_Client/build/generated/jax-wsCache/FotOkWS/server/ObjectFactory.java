
package server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListImages_QNAME = new QName("http://Server/", "listImages");
    private final static QName _ListImagesResponse_QNAME = new QName("http://Server/", "listImagesResponse");
    private final static QName _ModifyImage_QNAME = new QName("http://Server/", "modifyImage");
    private final static QName _ModifyImageResponse_QNAME = new QName("http://Server/", "modifyImageResponse");
    private final static QName _RegisterImage_QNAME = new QName("http://Server/", "registerImage");
    private final static QName _RegisterImageResponse_QNAME = new QName("http://Server/", "registerImageResponse");
    private final static QName _SearchByAuthor_QNAME = new QName("http://Server/", "searchByAuthor");
    private final static QName _SearchByAuthorResponse_QNAME = new QName("http://Server/", "searchByAuthorResponse");
    private final static QName _SearchByCreaDate_QNAME = new QName("http://Server/", "searchByCreaDate");
    private final static QName _SearchByCreaDateResponse_QNAME = new QName("http://Server/", "searchByCreaDateResponse");
    private final static QName _SearchById_QNAME = new QName("http://Server/", "searchById");
    private final static QName _SearchByIdResponse_QNAME = new QName("http://Server/", "searchByIdResponse");
    private final static QName _SearchByKeywords_QNAME = new QName("http://Server/", "searchByKeywords");
    private final static QName _SearchByKeywordsResponse_QNAME = new QName("http://Server/", "searchByKeywordsResponse");
    private final static QName _SearchByTitle_QNAME = new QName("http://Server/", "searchByTitle");
    private final static QName _SearchByTitleResponse_QNAME = new QName("http://Server/", "searchByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListImages }
     * 
     */
    public ListImages createListImages() {
        return new ListImages();
    }

    /**
     * Create an instance of {@link ListImagesResponse }
     * 
     */
    public ListImagesResponse createListImagesResponse() {
        return new ListImagesResponse();
    }

    /**
     * Create an instance of {@link ModifyImage }
     * 
     */
    public ModifyImage createModifyImage() {
        return new ModifyImage();
    }

    /**
     * Create an instance of {@link ModifyImageResponse }
     * 
     */
    public ModifyImageResponse createModifyImageResponse() {
        return new ModifyImageResponse();
    }

    /**
     * Create an instance of {@link RegisterImage }
     * 
     */
    public RegisterImage createRegisterImage() {
        return new RegisterImage();
    }

    /**
     * Create an instance of {@link RegisterImageResponse }
     * 
     */
    public RegisterImageResponse createRegisterImageResponse() {
        return new RegisterImageResponse();
    }

    /**
     * Create an instance of {@link SearchByAuthor }
     * 
     */
    public SearchByAuthor createSearchByAuthor() {
        return new SearchByAuthor();
    }

    /**
     * Create an instance of {@link SearchByAuthorResponse }
     * 
     */
    public SearchByAuthorResponse createSearchByAuthorResponse() {
        return new SearchByAuthorResponse();
    }

    /**
     * Create an instance of {@link SearchByCreaDate }
     * 
     */
    public SearchByCreaDate createSearchByCreaDate() {
        return new SearchByCreaDate();
    }

    /**
     * Create an instance of {@link SearchByCreaDateResponse }
     * 
     */
    public SearchByCreaDateResponse createSearchByCreaDateResponse() {
        return new SearchByCreaDateResponse();
    }

    /**
     * Create an instance of {@link SearchById }
     * 
     */
    public SearchById createSearchById() {
        return new SearchById();
    }

    /**
     * Create an instance of {@link SearchByIdResponse }
     * 
     */
    public SearchByIdResponse createSearchByIdResponse() {
        return new SearchByIdResponse();
    }

    /**
     * Create an instance of {@link SearchByKeywords }
     * 
     */
    public SearchByKeywords createSearchByKeywords() {
        return new SearchByKeywords();
    }

    /**
     * Create an instance of {@link SearchByKeywordsResponse }
     * 
     */
    public SearchByKeywordsResponse createSearchByKeywordsResponse() {
        return new SearchByKeywordsResponse();
    }

    /**
     * Create an instance of {@link SearchByTitle }
     * 
     */
    public SearchByTitle createSearchByTitle() {
        return new SearchByTitle();
    }

    /**
     * Create an instance of {@link SearchByTitleResponse }
     * 
     */
    public SearchByTitleResponse createSearchByTitleResponse() {
        return new SearchByTitleResponse();
    }

    /**
     * Create an instance of {@link ImageWS }
     * 
     */
    public ImageWS createImageWS() {
        return new ImageWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListImages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "listImages")
    public JAXBElement<ListImages> createListImages(ListImages value) {
        return new JAXBElement<ListImages>(_ListImages_QNAME, ListImages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListImagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "listImagesResponse")
    public JAXBElement<ListImagesResponse> createListImagesResponse(ListImagesResponse value) {
        return new JAXBElement<ListImagesResponse>(_ListImagesResponse_QNAME, ListImagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "modifyImage")
    public JAXBElement<ModifyImage> createModifyImage(ModifyImage value) {
        return new JAXBElement<ModifyImage>(_ModifyImage_QNAME, ModifyImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "modifyImageResponse")
    public JAXBElement<ModifyImageResponse> createModifyImageResponse(ModifyImageResponse value) {
        return new JAXBElement<ModifyImageResponse>(_ModifyImageResponse_QNAME, ModifyImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "registerImage")
    public JAXBElement<RegisterImage> createRegisterImage(RegisterImage value) {
        return new JAXBElement<RegisterImage>(_RegisterImage_QNAME, RegisterImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "registerImageResponse")
    public JAXBElement<RegisterImageResponse> createRegisterImageResponse(RegisterImageResponse value) {
        return new JAXBElement<RegisterImageResponse>(_RegisterImageResponse_QNAME, RegisterImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByAuthor")
    public JAXBElement<SearchByAuthor> createSearchByAuthor(SearchByAuthor value) {
        return new JAXBElement<SearchByAuthor>(_SearchByAuthor_QNAME, SearchByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByAuthorResponse")
    public JAXBElement<SearchByAuthorResponse> createSearchByAuthorResponse(SearchByAuthorResponse value) {
        return new JAXBElement<SearchByAuthorResponse>(_SearchByAuthorResponse_QNAME, SearchByAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByCreaDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByCreaDate")
    public JAXBElement<SearchByCreaDate> createSearchByCreaDate(SearchByCreaDate value) {
        return new JAXBElement<SearchByCreaDate>(_SearchByCreaDate_QNAME, SearchByCreaDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByCreaDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByCreaDateResponse")
    public JAXBElement<SearchByCreaDateResponse> createSearchByCreaDateResponse(SearchByCreaDateResponse value) {
        return new JAXBElement<SearchByCreaDateResponse>(_SearchByCreaDateResponse_QNAME, SearchByCreaDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchById")
    public JAXBElement<SearchById> createSearchById(SearchById value) {
        return new JAXBElement<SearchById>(_SearchById_QNAME, SearchById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByIdResponse")
    public JAXBElement<SearchByIdResponse> createSearchByIdResponse(SearchByIdResponse value) {
        return new JAXBElement<SearchByIdResponse>(_SearchByIdResponse_QNAME, SearchByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByKeywords }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByKeywords")
    public JAXBElement<SearchByKeywords> createSearchByKeywords(SearchByKeywords value) {
        return new JAXBElement<SearchByKeywords>(_SearchByKeywords_QNAME, SearchByKeywords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByKeywordsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByKeywordsResponse")
    public JAXBElement<SearchByKeywordsResponse> createSearchByKeywordsResponse(SearchByKeywordsResponse value) {
        return new JAXBElement<SearchByKeywordsResponse>(_SearchByKeywordsResponse_QNAME, SearchByKeywordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByTitle")
    public JAXBElement<SearchByTitle> createSearchByTitle(SearchByTitle value) {
        return new JAXBElement<SearchByTitle>(_SearchByTitle_QNAME, SearchByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "searchByTitleResponse")
    public JAXBElement<SearchByTitleResponse> createSearchByTitleResponse(SearchByTitleResponse value) {
        return new JAXBElement<SearchByTitleResponse>(_SearchByTitleResponse_QNAME, SearchByTitleResponse.class, null, value);
    }

}
