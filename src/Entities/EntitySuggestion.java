/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author benka
 */
public class EntitySuggestion 
{
     private int id ;
     private String nom;
     private String adresse;
     private String horaire;
     private int telephone;
     private String type;
     private String note;
     private Date date_deb;
     private Date date_fin;
     private int id_user;

    public EntitySuggestion(int id, String nom, String adresse, String horaire, int telephone, String type, String note,Date date_deb,Date date_fin, int id_user) {
        this.id = id;
        this.nom = nom;
       
        this.adresse = adresse;
        this.horaire = horaire;
        this.telephone = telephone;
        this.type = type;
        this.note = note;
        this.date_deb=date_deb;
        this.date_fin=date_fin;
        this.id_user = id_user;
    }
    
    
     public EntitySuggestion(int id, String nom, String adresse, String horaire, int telephone, String type, String note,Date date_deb,Date date_fin) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.horaire = horaire;
        this.telephone = telephone;
        this.type = type;
        this.note = note;
        this.date_deb=date_deb;
        this.date_fin=date_fin;
      
    }

 public EntitySuggestion( String nom, String adresse, String horaire, int telephone, String type, String note,Date date_deb,Date date_fin, int id_user) {
        
        this.nom = nom;
        this.adresse = adresse;
        this.horaire = horaire;
        this.telephone = telephone;
        this.type = type;
        this.note = note;
        this.date_deb=date_deb;
        this.date_fin=date_fin;
        this.id_user = id_user;
    }
    
     public EntitySuggestion( int id ,String nom, String adresse, String horaire, String type,int telephone,  String note,Date date_deb,Date date_fin) {
        this.id = id;
        this.nom = nom;
       
        this.adresse = adresse;
        this.horaire = horaire;
        this.telephone = telephone;
        this.type = type;
        this.note = note;
       this.date_deb=date_deb;
        this.date_fin=date_fin;
    }

    public EntitySuggestion(String text, String text0, String text1, int parseInt, String text2, String text3, String string, String string0, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

  

    public String getAdresse() {
        return adresse;
    }

    public String getHoraire() {
        return horaire;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public String getNote() {
        return note;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "EntitySuggestion{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", horaire=" + horaire + ", telephone=" + telephone + ", type=" + type + ", note=" + note + ", date_deb=" + date_deb + ", date_fin=" + date_fin + ", id_user=" + id_user + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntitySuggestion other = (EntitySuggestion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.telephone != other.telephone) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.horaire, other.horaire)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (!Objects.equals(this.date_deb, other.date_deb)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
     
     
    
}
