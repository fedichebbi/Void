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

    String type_M;

    public EntityMembre() {
    }

    public EntityMembre(String type_M, int id, String pseudo, String password, String email, String sexe) {
        super(id, pseudo, password, email, sexe);
        this.type_M = type_M;
    }

    public String getType_M() {
        return type_M;
    }

    public void setType(String type_M) {
        this.type_M = type_M;
    }

}
