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
        System.out.println("Introdueix el teu nom d'usuari");
        Scanner us = new Scanner(System.in);
        String usrnm = us.nextLine();

        

        
        boolean sortir = false;
        while (!sortir) {
            System.out.println("1 - Registrar Imatge");
            System.out.println("2 - Modificar Imatge");
            System.out.println("3 - Llistar imatges");
            System.out.println("4 - Buscador d'imatges");
            System.out.println("5 - Exit");
            
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
                    System.out.println("Entra la ID de la imatge a modificar");
                    ImageWS resultat = new ImageWS();
                    resultat = searchById(sc.nextInt());
                    boolean acabat = false;
                    while (!acabat) {
                        System.out.println("-- Sel·lecciona el camp que vols modificar --");
                        System.out.println("1. Títol: " + resultat.getTitol());
                        System.out.println("2. Descripció: " + resultat.getDescripcio());
                        System.out.println("3. Autor: " + resultat.getAutor());
                        System.out.println("4. Data creació: " + resultat.getDatac());
                        System.out.println("5. Tags: " + resultat.getTags());
                        System.out.println("6. Sortir ");
                        System.out.println(" ");

                        int valor = sc.nextInt();
                        Scanner mod = new Scanner(System.in);
                        switch (valor) {
                            case 1:
                                System.out.println("Entra el nou títol");
                                resultat.setTitol(mod.nextLine());
                                break;
                            case 2:
                                System.out.println("Entra la nova descripció:");
                                resultat.setDescripcio(mod.nextLine());
                                break;
                            case 3:
                                System.out.println("Entra el nou autor:");
                                resultat.setAutor(mod.nextLine());
                                break;
                            case 4:
                                System.out.println("Entra la nova data de creació (format 2018-10-26):");
                                resultat.setDatac(mod.nextLine());
                                break;
                            case 5:
                                System.out.println("Entra els nous tags separats per ';':");
                                resultat.setTags(mod.nextLine());
                                break;
                            case 6:
                                acabat = true;
                                modifyImage(resultat);
                                break;
                        }
                    }

                    break;
                case 3:
                    List<Object> res = new ArrayList<Object>();
                    res = listImages();
                    Iterator<Object> it = res.iterator();

                    while (it.hasNext()) {
                        Object image = it.next();
                        ImageWS mobj = ImageWS.class.cast(image);
                        System.out.println("Id: " + mobj.getId());
                        System.out.println("Títol: " + mobj.getTitol());
                        System.out.println("Descripció: " + mobj.getDescripcio());
                        System.out.println("Autor: " + mobj.getAutor());
                        System.out.println("Data creació: " + mobj.getDatac());
                        System.out.println("Tags: " + mobj.getTags());
                        System.out.println("Username: " + mobj.getUsername());
                        System.out.println(" ");
                    }

                    System.out.println("1 - Modificar una imatge");
                    System.out.println("2 - Sortir");

                    Scanner entrance = new Scanner(System.in);
                    int value = entrance.nextInt();
                    if (value == 2) break;
                    else {
                    System.out.println("Introdueix el id de la imatge que vols modificar:");    
                    Scanner usmodif = new Scanner(System.in);
                    ImageWS modif = new ImageWS();
                    modif = searchById(usmodif.nextInt());
                    System.out.println("username: " + modif.getUsername());
                    if (modif.getUsername().equals(usrnm)){
                        boolean acabataux = false;
                        while (!acabataux) {
                        System.out.println("-- Sel·lecciona el camp que vols modificar --");
                        System.out.println("1. Títol: " + modif.getTitol());
                        System.out.println("2. Descripció: " + modif.getDescripcio());
                        System.out.println("3. Autor: " + modif.getAutor());
                        System.out.println("4. Data creació: " + modif.getDatac());
                        System.out.println("5. Tags: " + modif.getTags());
                        System.out.println("6. Sortir ");
                        System.out.println(" ");

                        int valor = sc.nextInt();
                        Scanner mod = new Scanner(System.in);
                        switch (valor) {
                            case 1:
                                System.out.println("Entra el nou títol");
                                modif.setTitol(mod.nextLine());
                                break;
                            case 2:
                                System.out.println("Entra la nova descripció:");
                                modif.setDescripcio(mod.nextLine());
                                break;
                            case 3:
                                System.out.println("Entra el nou autor:");
                                modif.setAutor(mod.nextLine());
                                break;
                            case 4:
                                System.out.println("Entra la nova data de creació (format 2018-10-26):");
                                modif.setDatac(mod.nextLine());
                                break;
                            case 5:
                                System.out.println("Entra els nous tags separats per ';':");
                                modif.setTags(mod.nextLine());
                                break;
                            case 6:
                                acabataux = true;
                                modifyImage(modif);
                                break;
                        }
                    }

                    }
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
                            System.out.println("Introdueix la ID");
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
                            System.out.println("Introdueix el títol");
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
                            System.out.println("Introdueix l'autor");
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
                            System.out.println("Introdueix el tag");
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
                            System.out.println("Introdueix la data de creació");
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
                        case 6:
                            sortir = true;
                            break;

                    }
                    break;
            }
        }
        
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
