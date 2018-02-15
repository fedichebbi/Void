/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Fedi
 */
public class EntityTopic {
    
    int id;
    String titre;
    String type;
    String contenu;
    int id_user;

    public EntityTopic(int id, String titre, String type, String contenu,int id_user) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.contenu = contenu;
        this.id_user=id_user;
    }

    public EntityTopic(String titre, String type, String contenu,int id_user) {
        this.titre = titre;
        this.type = type;
        this.contenu = contenu;
        this.id_user=id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
    
}
