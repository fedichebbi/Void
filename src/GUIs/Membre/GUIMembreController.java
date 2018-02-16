/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Membre;

import Entities.EntityUser;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIMembreController implements Initializable {

    @FXML
    private Label membre;
    @FXML
    private AnchorPane holderPane;

    EntityUser user = new EntityUser();
    
    public String pseudo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ServiceUser su=new ServiceUser();
        //user=su.getUser(pseudo);
        System.out.println(pseudo);
    }

    public void getUser(EntityUser user) {
        membre.setText(user.getPseudo());
    }

    public EntityUser User(){
        return user;
    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchForum(ActionEvent event) throws IOException {

        AnchorPane forum = FXMLLoader.load(getClass().getResource("GUIForum.fxml"));
        setNode(forum);
    }

}
