/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Api.Mailer;
import Services.ServiceUser;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIForgetPassController implements Initializable {

    @FXML
    private JFXTextField champMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generateCode(ActionEvent event) throws SQLException {
       // Mailer.send("fedi.chebbi@esprit.tn","chrengafrenga1","mohamed.glid@esprit.tn","hello javatpoint","ya3tek nam");
        if (champMail.getText().equals("")){
            System.out.println("Inserer mail");
       }
        else {
       Services.ServiceUser su = new ServiceUser();
       Entities.EntityUser user;
       user=su.getUserByMail(champMail.getText());
       if (user==null)
                System.out.println("Mail inexistant");
       else{
           String code=Mailer.randomString(4);
           su.addCode(code, user.getId());
           Mailer.send("fedi.chebbi@esprit.tn", "chrengafrenga1","fedi.chebbi@esprit.tn","Demande de réinstalisation du mot de pass",
                   "Votre code est : "+code);
       }
        
        }
        
    }




    
}
