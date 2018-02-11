/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hp
 */
public class Conseil_Expert {
    private int id_conseil;
    private String titre;
    private String contenu;
    private int id_user;

    public Conseil_Expert(int id_conseil, String titre, String contenu, int id_user) {
        this.id_conseil = id_conseil;
        this.titre = titre;
        this.contenu = contenu;
        this.id_user = id_user;
    }

    public int getId_conseil() {
        return id_conseil;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_conseil(int id_conseil) {
        this.id_conseil = id_conseil;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Conseil_Expert{" + "id_conseil=" + id_conseil + ", titre=" + titre + ", contenu=" + contenu + ", id_user=" + id_user + '}';
    }
    
    
}
