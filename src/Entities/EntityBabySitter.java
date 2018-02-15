/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import static java.util.Collections.list;
import java.util.Objects;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableColumn;

/**
 *
 * @author benka
 */
public class EntityBabySitter {
    
    private int  id ;
    private Date date_dispo ;
    private String horaire ;
    private String lieux ;
    private float prix ;
    private int n_tel;
    private String description ;
    private int id_user ;
   // list<EntityBabySitter>list;
    public EntityBabySitter(int id,Date date_dispo, String horaire, String lieux, float prix, int n_tel, String description,int id_user) {
        this.id = id;
        this.date_dispo=date_dispo;
        this.horaire = horaire;
        this.lieux = lieux;
        this.prix = prix;
        this.n_tel = n_tel;
        this.description = description;
        this.id_user=id_user;
    }
     public EntityBabySitter(int id ,Date date_dispo, String horaire, String lieux, float prix, int n_tel, String description) {
        this.id = id;
        this.date_dispo=date_dispo;
        this.horaire = horaire;
        this.lieux = lieux;
        this.prix = prix;
        this.n_tel = n_tel;
        this.description = description;
       
    }
     public EntityBabySitter(Date date_dispo, String horaire, String lieux, float prix, int n_tel, String description,int id_user) {
       
        this.date_dispo=date_dispo;
         this.horaire = horaire;
        this.lieux = lieux;
        this.prix = prix;
        this.n_tel = n_tel;
        this.description = description;
        this.id_user=id_user;
    }
     
     public EntityBabySitter(Date date_dispo, String horaire, String lieux, float prix, int n_tel, String description) {
       this.date_dispo=date_dispo;
        this.horaire = horaire;
        this.lieux = lieux;
        this.prix = prix;
        this.n_tel = n_tel;
        this.description = description;
       
    }

    public void setDate_dispo(Date date_dispo) {
        this.date_dispo = date_dispo;
    }

    public Date getDate_dispo() {
        return date_dispo;
    }


    public int getId() {
        return id;
    }

    public String getHoraire() {
        return horaire;
    }

    public String getLieux() {
        return lieux;
    }

    public float getPrix() {
        return prix;
    }

    public int getN_tel() {
        return n_tel;
    }

    public String getDescription() {
        return description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setN_tel(int n_tel) {
        this.n_tel = n_tel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
  // public StringProprety horaireProprety(){return horaire;}

    @Override
    public String toString() {
        return "EntityBabySitter{" + "id=" + id + ", date_dispo=" + date_dispo + ", horaire=" + horaire + ", lieux=" + lieux + ", prix=" + prix + ", n_tel=" + n_tel + ", description=" + description + ", id_user=" + id_user + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final EntityBabySitter other = (EntityBabySitter) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.horaire, other.horaire)) {
            return false;
        }
        if (!Objects.equals(this.lieux, other.lieux)) {
            return false;
        }
        if (!Objects.equals(this.n_tel, other.n_tel)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_dispo, other.date_dispo)) {
            return false;
        }
        return true;
    }

    

    public void setHoraire(TableColumn<EntityBabySitter, String> id_horaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getLieux(TableColumn<EntityBabySitter, String> id_lieu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getN_tel(TableColumn<EntityBabySitter, String> id_num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getPrix(TableColumn<EntityBabySitter, Float> id_salaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getDescription(TableColumn<EntityBabySitter, String> id_desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
}
