/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Membre;

import Entities.EntityTopic;
import Services.ServiceTopic;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIAddTopicController implements Initializable {

    @FXML
    private JFXTextField champTitre;
    @FXML
    private JFXTextArea champContenu;
    @FXML
    private JFXTextField champSujet;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) throws SQLException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        ServiceTopic st=new ServiceTopic();
        int id=GUIMembreController.user.getId();
        EntityTopic topic=new EntityTopic(champTitre.getText(),champSujet.getText(),champContenu.getText(),id);
        st.ajouterTopic(topic);
    }
    
    
}
