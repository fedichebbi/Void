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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public EntityExpert(String specialite) {
        this.specialite = specialite;
    }

    public EntityExpert(String specialite, int id, String pseudo, String password, String nom, String prenom, String email, String adresse, String date_naissance,String statut) {
        super(id, pseudo, password, nom, prenom, email, adresse, date_naissance,statut);
        this.specialite = specialite;
    }
    
    
}
