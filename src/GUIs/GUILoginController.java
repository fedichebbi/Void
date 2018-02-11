/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Entities.EntityUser;
import Services.ServiceUser;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUILoginController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView signup;
    @FXML
    private JFXButton confirmer;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonclicked(ActionEvent event) throws Exception {
        ServiceUser su = new ServiceUser();
        String verif = su.verifLogin(username.getText(), password.getText());
        System.out.println(verif);
        if ((verif == null)) {
            alerter("Verifier vos coordonnés");
        } 
        else if (verif.equals("admin"))
        {
            alerter("Bienvenue "+verif);
            redirecting("Admin/GUIDashboard.fxml", "Interface Admin",event);
        }
        else if (verif.equals("membre"))
        {
            alerter("Bienvenue "+verif);
        }
        
        

        ///GUIs/Admin/GUIDashboard.fxml
    }
    private void alerter(String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(message);

        alert.showAndWait();
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

    private void windows(String path, String title) throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource(path));
        anchorPane.getChildren().setAll(pane);
        /*Parent root = FXMLLoader.load(getClass().getResource(path));
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();*/
    }

    @FXML
    private void signup(MouseEvent event) throws Exception {
        windows("GUIInscription.fxml", "Inscrivez Vous !");
    }

}
