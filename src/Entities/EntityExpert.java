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
public class EntityExpert extends EntityUser
{
    String specialite;
    
    public EntityExpert()
    {
        
    }


    public EntityExpert(String specialite, int id, String pseudo, String password, String email, String sexe) {
        super(id, pseudo, password, email, sexe);
        this.specialite = specialite;
    }


    public EntityExpert(String pseudo, String password, String email, String sexe,String specialite) {
        super(pseudo, password, email, sexe);
        this.specialite = specialite;
    }
    
    


    
    
    
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
}
