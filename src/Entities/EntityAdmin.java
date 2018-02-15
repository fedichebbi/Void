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
public class EntityAdmin extends EntityUser{

    public EntityAdmin() {
    }

    public EntityAdmin(int id, String pseudo, String password, String email, String sexe) {
        super(id, pseudo, password, email, sexe);
    }

    public EntityAdmin(String pseudo, String password, String email) {
        super(pseudo, password, email);
    }
    
    
    
    
}
