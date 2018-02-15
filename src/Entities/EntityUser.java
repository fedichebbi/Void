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
public class EntityUser {

    int id;
    String pseudo;
    String password;
    String email;
    String sexe;

    public EntityUser() {

    }

    public EntityUser(String pseudo, String password, String email, String sexe) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.sexe = sexe;
    }

    public EntityUser(String pseudo, String password, String email) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }
    
    
    
    public EntityUser(int id, String pseudo, String password, String email, String sexe) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.sexe=sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }
    
    
    
   

}
