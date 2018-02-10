/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Entities.EntityUser;
import Services.ServiceUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIInscriptionController implements Initializable {

    @FXML
    private JFXButton bt;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField pseudo;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXComboBox<String> sexe;
    @FXML
    private CheckBox pro;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe.getItems().addAll("Homme","Femme");
    }
    
    
    
    @FXML
    private void confirmerClicked(ActionEvent event) throws Exception {
        ServiceUser su=new ServiceUser();
        EntityUser usr=new EntityUser(pseudo.getText(), password.getText(), mail.getText(), sexe.getValue());
        su.ajouterUser(usr);
        windows("GUILogin.fxml", "Connectez Vous !");
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
        private void windows(String path, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));      
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

}
