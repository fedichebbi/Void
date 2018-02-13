/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Article {
    private int id;
    private String categorie;
    private String titre;
    private String contenue;
    private int note;
    private Date date_creation;
    private List<Article>articles;

    public Article(int id, String categorie, String titre, String contenue, int note, Date date_creation) {
        this.id = id;
        this.categorie = categorie;
        this.titre = titre;
        this.contenue = contenue;
        this.note = note;
        this.date_creation = date_creation;
    }
//
    public Article(String categorie, String titre, String contenue, int note, Date date_creation) {
        this.categorie = categorie;
        this.titre = titre;
        this.contenue = contenue;
        this.note = note;
        this.date_creation = date_creation;
    }

    public Article(List<Article> list) {
        list=new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenue() {
        return contenue;
    }

    public int getNote() {
        return note;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", categorie=" + categorie + ", titre=" + titre + ", contenue=" + contenue + ", note=" + note + ", date_creation=" + date_creation + '}';
    }
    
    
}
