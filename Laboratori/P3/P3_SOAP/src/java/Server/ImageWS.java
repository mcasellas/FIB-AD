package Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rando
 */
public class ImageWS {
  String filename;
  int id;
  String titol;
  String descripcio;
  String tags;
  String autor;
  String datac;
  String timestamp;
  String username;

    public ImageWS(String filename, int id, String titol, String descripcio, String tags, String autor, String datac, String timestamp, String username) {
        this.filename = filename;
        this.id = id;
        this.titol = titol;
        this.descripcio = descripcio;
        this.tags = tags;
        this.autor = autor;
        this.datac = datac;
        this.timestamp = timestamp;
        this.username = username;
    }

    public ImageWS() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDatac() {
        return datac;
    }

    public void setDatac(String datac) {
        this.datac = datac;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
  
}
