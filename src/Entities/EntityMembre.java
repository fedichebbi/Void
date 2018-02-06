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
public class EntityMembre extends EntityUser {

    String type;

    public EntityMembre() {
    }

    public EntityMembre(int id, String pseudo, String password, String nom, String prenom, String email, String adresse, String date_naissance,String statut) {
        super(id, pseudo, password, nom, prenom, email, adresse, date_naissance,statut);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    

}
