/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Interfaces.ISuggestion;
import java.sql.Connection;
import Config.config;
import Entities.EntitySuggestion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author benka
 */
public class ServiceSuggestion extends ISuggestion {
    
    Connection connection = config.getInstance().getConnection();
    private Statement ste ;
    
    public  ServiceSuggestion() 
    {
      try 
      {
          ste = connection.createStatement();
      }catch (SQLException ex)
      {
          System.err.println(ex);
      }
       
    }
    
    
    static ServiceSuggestion instance ;
    
    public static ServiceSuggestion getInstance()
    {
        if(instance==null)
        {
            instance = new ServiceSuggestion();
        }
        return instance;
    }

    
    public void add (EntitySuggestion sug) throws SQLException
    {
       
       try 
       {   
           // java.util.Date date = new java.util.Date();
           //date= Date.valueOf(localDate);
           //  LocalDate localDate = date.getValue();
           // java.sql.Date Date_dispo = new java.sql.Date(date.getTime());
          
           String req ="insert into suggestion (id,nom,adresse,horaire,telephone,type,note,date_deb,date_fin,id_user)value (?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement prepareStatement;
           prepareStatement = connection.prepareStatement(req);
           prepareStatement.setInt(1, sug.getId());
           prepareStatement.setString(2, sug.getNom());
           prepareStatement.setString(3, sug.getAdresse());
           prepareStatement.setString(4, sug.getHoraire());
           prepareStatement.setInt(5, sug.getTelephone());
           prepareStatement.setString(6, sug.getType());
           prepareStatement.setString(7, sug.getNote());
            
             prepareStatement.setDate(8, sug.getDate_deb());
              prepareStatement.setDate(9, sug.getDate_fin());
              prepareStatement.setInt(10, sug.getId_user());
           prepareStatement.executeUpdate();
           
       }
       catch (SQLException ex) {
            System.out.println("non ajouté");
            System.out.println(ex);
            
                    //System.out.println(""+Date.valueOf(localDate));
       
    }
    
    }
    
    public void update (EntitySuggestion b) throws SQLException
     {
         
         try 
         {
           String req ="update suggestion set nom=?,adresse=?,horaire=?,telephone=?,type=?,note=?,date_deb=?,date_fin=?,id_user=1 where id=? ";
           PreparedStatement prepareStatement;
           prepareStatement = connection.prepareStatement(req);
           prepareStatement.setString(1, b.getNom());
           prepareStatement.setString(2, b.getAdresse());
           prepareStatement.setString(3, b.getHoraire());
           prepareStatement.setInt(4, b.getTelephone());
           prepareStatement.setString(5, b.getType());
           prepareStatement.setString(6, b.getNote());
           prepareStatement.setDate(7, b.getDate_deb());
           prepareStatement.setDate(8, b.getDate_fin());
          // prepareStatement.setInt(7, b.getId_user());
           prepareStatement.setInt(9, b.getId());
           prepareStatement.executeUpdate();
         }
         catch (SQLException ex)
         {
              System.out.println("non modifié");
              System.out.println(ex);
         }
      
         
     }
    
    
    
    public void remove(Integer id) {
        String req = "delete from suggestion where id =?";
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) 
        {
           System.out.println("non supprimé");
           System.out.println(ex); 
        }
    }    
     
    
   /* public ObservableList<EntitySuggestion> findByid(Integer id)
     {
         EntitySuggestion entitySuggestion =null;
         String req = "select * from suggestion where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
   
                entitySuggestion = new EntitySuggestion (resultSet.getInt("id"),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getInt(8));
                 }
        } catch (SQLException ex) {
            System.out.println("non trouvé");
            System.out.println(ex); 
        }
       
        return entitySuggestion;
         
     }*/
    
 
       public ObservableList<EntitySuggestion> findByType (String type)
     {
         EntitySuggestion entitysuggestion =null;
         ObservableList <EntitySuggestion>entitysuggestions =FXCollections.observableArrayList();
         String req = "select * from suggestion where type =?";
             PreparedStatement preparedStatement;
        try {
            
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                entitysuggestion = new EntitySuggestion(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString("type"),resultSet.getString(7),resultSet.getDate(8),resultSet.getDate(9),resultSet.getInt(10)) ;
          entitysuggestions.add(entitysuggestion);
            }
        } catch (SQLException ex) {
            System.out.println("non trouvé");
            System.out.println(ex); 
        }
       
        return entitysuggestions;
         
     }
       
   /*
        public ObservableList<EntityBabySitter> findByLieux(String lieux) {
       EntityBabySitter entitybabysitter = null;
        ObservableList <EntityBabySitter>entitybabysitters =FXCollections.observableArrayList();
        try {
             String req = "select * from baby_sitter where lieux =?";
             PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, lieux);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

         entitybabysitter = new EntityBabySitter(resultSet.getInt(1), resultSet.getString(2), resultSet.getString("lieux"), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
         entitybabysitters.add(entitybabysitter);
            }
        } catch (SQLException ex) {
            System.out.println("non trouvé");
            System.out.println(ex);
        }

        return entitybabysitters ;

    }
       */   
             public ObservableList getAll() 
       {
              //EntitySuggestion entitysuggestion =null;
              //List<EntitySuggestion> entitysuggestions = new ArrayList<>();
           ObservableList List = FXCollections.observableArrayList();
            
             
          
        try {
             String req = "select * from suggestion ";
           PreparedStatement preparedstatement;
            preparedstatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedstatement.executeQuery();
           while (resultSet.next())
           {
               
              //EntitySuggestion entitysuggestion = new EntitySuggestion(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getInt(8));
               EntitySuggestion entitysuggestion = new EntitySuggestion(resultSet.getInt(1),resultSet.getString("nom"),resultSet.getString("adresse"),resultSet.getString("horaire"),resultSet.getString("type"),resultSet.getInt("telephone"),resultSet.getString("note"),resultSet.getDate("date_deb"),resultSet.getDate("date_fin"));
  // EntitySuggestion entitysuggestion = new EntitySuggestion(resultSet.getInt(1),resultSet.getString("nom"),resultSet.getString("adresse"),resultSet.getString("horaire"),resultSet.getString("type"),resultSet.getInt("telephone"),resultSet.getString("note"));

               List.add(entitysuggestion);
               
              // EntityBabySitter entitybabysitter = new EntityBabySitter(resultSet.getInt(1),resultSet.getString("horaire"), resultSet.getString("lieux"), resultSet.getFloat("prix"), resultSet.getString("n_tel"), resultSet.getString("description"));
              // List.add(entitybabysitter);
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSuggestion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
            
            return List ;
           
          
           
       }
     
    
    
    
}


