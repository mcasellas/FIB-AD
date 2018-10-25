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

                int entrada2 = sc.nextInt();
                Scanner sc2 = new Scanner(System.in);
                switch (entrada2) {
                    case 1:
                        int entradaaux1 = sc.nextInt();

                        Object image = searchById(entradaaux1);
                        ImageWS mobj = ImageWS.class.cast(image);
                        System.out.println("Títol: " + mobj.getTitol());
                        System.out.println("Descripció: " + mobj.getDescripcio());
                        System.out.println("Autor: " + mobj.getAutor());
                        System.out.println("Data creació: " + mobj.getDatac());
                        System.out.println("Tags: " + mobj.getTags());
                        System.out.println("Username: " + mobj.getUsername());
                        System.out.println(" ");

                        break;
                    case 2:
                        String entradaaux2 = sc2.nextLine();
                        List<Object> resultataux2 = new ArrayList<Object>();
                        resultataux2 = searchByTitle(entradaaux2);
                        Iterator<Object> itaux2 = resultataux2.iterator();

                        while (itaux2.hasNext()) {
                            Object imageaux2 = itaux2.next();
                            ImageWS mobjaux2 = ImageWS.class.cast(imageaux2);
                            System.out.println("Títol: " + mobjaux2.getTitol());
                            System.out.println("Descripció: " + mobjaux2.getDescripcio());
                            System.out.println("Autor: " + mobjaux2.getAutor());
                            System.out.println("Data creació: " + mobjaux2.getDatac());
                            System.out.println("Tags: " + mobjaux2.getTags());
                            System.out.println("Username: " + mobjaux2.getUsername());
                            System.out.println(" ");
                        }
                        break;
                    case 3:
                        String entradaaux3 = sc2.nextLine();
                        List<Object> resultataux3 = new ArrayList<Object>();
                        resultataux3 = searchByAuthor(entradaaux3);
                        Iterator<Object> itaux3 = resultataux3.iterator();

                        while (itaux3.hasNext()) {
                            Object imageaux2 = itaux3.next();
                            ImageWS mobjaux2 = ImageWS.class.cast(imageaux2);
                            System.out.println("Títol: " + mobjaux2.getTitol());
                            System.out.println("Descripció: " + mobjaux2.getDescripcio());
                            System.out.println("Autor: " + mobjaux2.getAutor());
                            System.out.println("Data creació: " + mobjaux2.getDatac());
                            System.out.println("Tags: " + mobjaux2.getTags());
                            System.out.println("Username: " + mobjaux2.getUsername());
                            System.out.println(" ");
                        
                        }
                        break;
                    case 4:
                        String entradaaux4 = sc2.nextLine();
                        List<Object> resultataux4 = new ArrayList<Object>();
                        resultataux4 = searchByKeywords(entradaaux4);
                        Iterator<Object> itaux4 = resultataux4.iterator();

                        while (itaux4.hasNext()) {
                            Object imageaux2 = itaux4.next();
                            ImageWS mobjaux2 = ImageWS.class.cast(imageaux2);
                            System.out.println("Títol: " + mobjaux2.getTitol());
                            System.out.println("Descripció: " + mobjaux2.getDescripcio());
                            System.out.println("Autor: " + mobjaux2.getAutor());
                            System.out.println("Data creació: " + mobjaux2.getDatac());
                            System.out.println("Tags: " + mobjaux2.getTags());
                            System.out.println("Username: " + mobjaux2.getUsername());
                            System.out.println(" ");
                        }
                        break;
                    case 5:
                       String entradaaux5 = sc2.nextLine();
                        List<Object> resultataux5 = new ArrayList<Object>();
                        resultataux5 = searchByCreaDate(entradaaux5);
                        Iterator<Object> itaux5 = resultataux5.iterator();

                        while (itaux5.hasNext()) {
                            Object imageaux2 = itaux5.next();
                            ImageWS mobjaux2 = ImageWS.class.cast(imageaux2);
                            System.out.println("Títol: " + mobjaux2.getTitol());
                            System.out.println("Descripció: " + mobjaux2.getDescripcio());
                            System.out.println("Autor: " + mobjaux2.getAutor());
                            System.out.println("Data creació: " + mobjaux2.getDatac());
                            System.out.println("Tags: " + mobjaux2.getTags());
                            System.out.println("Username: " + mobjaux2.getUsername());
                            System.out.println(" ");
                        }
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
