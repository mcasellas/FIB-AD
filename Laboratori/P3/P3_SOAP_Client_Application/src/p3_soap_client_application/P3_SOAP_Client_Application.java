/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_soap_client_application;

import java.text.SimpleDateFormat;
import server.ImageWS;
import java.util.*;

/**
 *
 * @author rando
 */
public class P3_SOAP_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1 - Registrar Imatge");
        System.out.println("2 - Modificar Imatge");
        System.out.println("3 - Llistar imatges");
        System.out.println("4 - Buscador d'imatges");

        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();

        switch (entrada) {
            
            case 1:
                ImageWS result = new ImageWS();  
                sc.nextLine();
                        
                System.out.println("Entra el títol");
                result.setTitol(sc.nextLine());
                
                System.out.println("Entra la descripció");
                result.setDescripcio(sc.nextLine());
                
                System.out.println("Entra els tags (separats per ';')");
                result.setTags(sc.nextLine());
                
                System.out.println("Entra l'autor");
                result.setAutor(sc.nextLine());
                
                System.out.println("Entra la data de creació (format 2018-10-25)");
                result.setDatac(sc.nextLine());
                
                
                       
                registerImage(result);
                
                
                // Username
                // Filename
                // ID
                
                break;
            case 2:
                break;
            case 3:
                List<Object> resultat = new ArrayList<Object>();
                resultat = listImages();
                Iterator<Object> it = resultat.iterator();

                while (it.hasNext()) {
                    Object image = it.next();
                    ImageWS mobj = ImageWS.class.cast(image);
                    System.out.println("Títol: " + mobj.getTitol());
                    System.out.println("Descripció: " + mobj.getDescripcio());
                    System.out.println("Autor: " + mobj.getAutor());
                    System.out.println("Data creació: " + mobj.getDatac());
                    System.out.println("Tags: " + mobj.getTags());
                    System.out.println("Username: " + mobj.getUsername());
                    System.out.println(" ");
                }

                break;
            case 4:
                System.out.println("1 - Buscar per Id");
                System.out.println("2 - Buscar per Titol");
                System.out.println("3 - Buscar per Autor");
                System.out.println("4 - Buscar per Tag");
                System.out.println("5 - Buscar per Data");
                Scanner sc2 = new Scanner(System.in);
                int entrada2 = sc2.nextInt();
                switch (entrada) {
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    case 5:
                    break;
                    
                }
                break;
        }
        System.out.println(entrada);
    }

    private static java.util.List<java.lang.Object> listImages() {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.listImages();
    }

    private static int modifyImage(server.ImageWS image) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.modifyImage(image);
    }

    private static int registerImage(server.ImageWS image) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.registerImage(image);
    }

    private static java.util.List<java.lang.Object> searchByAuthor(java.lang.String author) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchByAuthor(author);
    }

    private static java.util.List<java.lang.Object> searchByCreaDate(java.lang.String creaDate) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchByCreaDate(creaDate);
    }

    private static ImageWS searchById(int id) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchById(id);
    }

    private static java.util.List<java.lang.Object> searchByKeywords(java.lang.String keywords) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchByKeywords(keywords);
    }

    private static java.util.List<java.lang.Object> searchByTitle(java.lang.String title) {
        server.FotOkWS_Service service = new server.FotOkWS_Service();
        server.FotOkWS port = service.getFotOkWSPort();
        return port.searchByTitle(title);
    }

}
