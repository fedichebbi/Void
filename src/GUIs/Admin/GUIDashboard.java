/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Admin;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIDashboard implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnPricing;
    @FXML
    private JFXButton btnContacts;
    @FXML
    private JFXButton btnWidgets;
    @FXML
    private JFXButton btnProfile;
    @FXML
    private JFXButton btnAlerts;
    @FXML
    private JFXButton btnControls;
    @FXML
    private AnchorPane holderPane;
    
   AnchorPane contacts,alerts,pricing,profiles,widgets,controls;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               try {
             //contacts = FXMLLoader.load(getClass().getResource("Contacts.fxml"));
             //alerts = FXMLLoader.load(getClass().getResource("Alerts.fxml"));
             //pricing = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
             profiles = FXMLLoader.load(getClass().getResource("GUIProfiles.fxml"));
             //widgets = FXMLLoader.load(getClass().getResource("Widgets.fxml"));
             //controls = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            setNode(profiles);
        } catch (IOException ex) {
            Logger.getLogger(GUIDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void switchPricing(ActionEvent event) {
    }

    @FXML
    private void switchContacts(ActionEvent event) {
    }

    @FXML
    private void switchWidget(ActionEvent event) {
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profiles);
    }

    @FXML
    private void switchAlert(ActionEvent event) {
    }

    @FXML
    private void switchControls(ActionEvent event) {
    }


    
}
