/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Membre;

import Entities.EntityUser;
import java.io.IOException;
import java.net.URL;
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
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIMembreController {

    @FXML
    private Label membre;

    private EntityUser usr = new EntityUser();
    @FXML
    private AnchorPane holderPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void getUser(EntityUser user)
    {
        membre.setText(user.getPseudo());
        usr=new EntityUser(user.getId(), user.getPseudo(),user.getPassword(),user.getEmail(),user.getSexe());
    }
    
    public EntityUser User()
    {
        return usr;
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
