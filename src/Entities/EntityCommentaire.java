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
public class EntityCommentaire {
    
    int id;
    int id_user;
    int id_topic;
    String contenu;

    public EntityCommentaire(int id, int id_user, int id_topic, String contenu) {
        this.id = id;
        this.id_user = id_user;
        this.id_topic = id_topic;
        this.contenu = contenu;
    }

    public EntityCommentaire(int id_user, int id_topic, String contenu) {
        this.id_user = id_user;
        this.id_topic = id_topic;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_topic() {
        return id_topic;
    }

    public void setId_topic(int id_topic) {
        this.id_topic = id_topic;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    
}
