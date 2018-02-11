/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.EntityUser;
import Services.*;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fedi
 */
public class Void extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUIs/GUILogin.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Connectez Vous");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
        ServiceUser usr=new ServiceUser();
        //System.out.println(usr.verifLogin("admin", "admin"));
        ObservableList<EntityUser>data=usr.LoadDb();
    }
    
}
