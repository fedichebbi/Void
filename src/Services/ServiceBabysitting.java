/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IBabysitting;
import java.sql.Connection;
import Config.config;
import Entities.EntityBabySitter;
import static com.oracle.nio.BufferSecrets.instance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author benka
 */
public class ServiceBabysitting implements IBabysitting {

    Connection connection = config.getInstance().getConnection();
    private Statement ste;

    public ServiceBabysitting() {
        try {
            ste = connection.createStatement();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }
    
    static ServiceBabysitting instance ;
    
    public static ServiceBabysitting getInstance()
    {
        if(instance==null)
        {
            instance = new ServiceBabysitting();
        }
        return instance;
    }
    
    private void redirecting(String path,String title,Event event) throws Exception
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public void add(EntityBabySitter b) throws SQLException {

        try {
            java.util.Date date = new java.util.Date();
            java.sql.Date Date_dispo = new java.sql.Date(date.getTime());
            String req = "insert into baby_sitter (id,date_dispo,horaire,lieux,prix,n_tel,description,id_user)value (?,?,?,?,?,?,?,?)";
            PreparedStatement prepareStatement;
            prepareStatement = connection.prepareStatement(req);
            prepareStatement.setInt(1, b.getId());
             prepareStatement.setDate(2,Date_dispo);
            prepareStatement.setString(3, b.getHoraire());
           
            prepareStatement.setString(4, b.getLieux());
            prepareStatement.setInt(5, (int) (float) b.getPrix());
            prepareStatement.setInt(6, b.getN_tel());
            prepareStatement.setString(7, b.getDescription());
            prepareStatement.setInt(8, b.getId_user());
            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("non ajouté");
            System.out.println(ex);

        }

    }

    public void update(EntityBabySitter b) throws SQLException {

        try {
            java.util.Date date = new java.util.Date();
            java.sql.Date Date_dispo = new java.sql.Date(date.getTime());
            String req = "update baby_sitter set date_dispo=?, horaire=?,lieux=?,prix=?,n_tel=?,description=?,id_user=1 where id=? ";
            PreparedStatement prepareStatement;
            prepareStatement = connection.prepareStatement(req);
            prepareStatement.setDate(1, Date_dispo);
            prepareStatement.setString(2, b.getHoraire());
            prepareStatement.setString(3, b.getLieux());
            prepareStatement.setInt(4, (int) b.getPrix());
            prepareStatement.setInt(5, b.getN_tel());
            prepareStatement.setString(6, b.getDescription());
           // prepareStatement.setInt(6,b.getId_user());
            prepareStatement.setInt(7,b.getId() );
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("non modifié");
            System.out.println(ex);
        }

    }

    public void remove(int id) {
        String req = "delete from baby_sitter where id =?";

        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("non supprimé");
            System.out.println(ex);
        }
    }
    


    public EntityBabySitter findById(Integer id) {
        EntityBabySitter entitybabysitter = null;
        String req = "select * from baby_sitter where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                entitybabysitter = new EntityBabySitter(resultSet.getInt("id"), resultSet.getDate(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8));
            }
        } catch (SQLException ex) {
            System.out.println("non trouvé");
            System.out.println(ex);
        }

        return entitybabysitter;

    }

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

         entitybabysitter = new EntityBabySitter(resultSet.getInt(1), resultSet.getDate(2), resultSet.getString(3), resultSet.getString("lieux"), resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8));
         entitybabysitters.add(entitybabysitter);
            }
        } catch (SQLException ex) {
            System.out.println("non trouvé");
            System.out.println(ex);
        }

        return entitybabysitters ;

    }
    
    

    public ObservableList getAllBB() {
     ObservableList List = FXCollections.observableArrayList();
       

            
        try {
            String req = "select * from baby_sitter ";
            PreparedStatement preparedstatement;
            preparedstatement = connection.prepareStatement(req);
             ResultSet resultSet = preparedstatement.executeQuery();
            while (resultSet.next()) {
   
               // EntityBabySitter entitybabysitter = new EntityBabySitter(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
                EntityBabySitter entitybabysitter = new EntityBabySitter(resultSet.getInt(1),resultSet.getDate("date_dispo"),resultSet.getString("horaire"), resultSet.getString("lieux"), resultSet.getFloat("prix"), resultSet.getInt("n_tel"), resultSet.getString("description"));
               List.add(entitybabysitter);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBabysitting.class.getName()).log(Level.SEVERE, null, ex);
        }
           

       

        return List;

    }

  
}
