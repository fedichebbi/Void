/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Entities.EntityExpert;
import Entities.EntityMembre;
import Entities.EntityUser;
import Services.ServiceUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static java.lang.System.in;
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
import javafx.scene.control.Label;
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
    @FXML
    private Label erreurPseudo;
    @FXML
    private Label erreurPass;
    @FXML
    private Label erreurMail;
    @FXML
    private Label erreurSexe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe.getItems().addAll("Homme", "Femme");
    }

    @FXML
    private void confirmerClicked(ActionEvent event) throws Exception {
        erreurPseudo.setText("");
        erreurPass.setText("");
        erreurMail.setText("");
        erreurSexe.setText("");
        boolean test = true;
        ServiceUser su = new ServiceUser();
        EntityUser usr = null;
        if (pro.isSelected()){
            EntityExpert expert=new EntityExpert(pseudo.getText(), password.getText(), mail.getText(), sexe.getValue(), "Medecin");
            usr=expert;
        }
        else 
        {
            EntityMembre membre=new EntityMembre(pseudo.getText(), password.getText(), mail.getText(), sexe.getValue(), "Simple");
            usr=membre;
        }
        //EntityUser usr = new EntityUser(pseudo.getText(), password.getText(), mail.getText(), sexe.getValue());
        if (pseudo.getText().equals("")) {
            erreurPseudo.setText("Insérer un pseudo");
            test = false;
        }
        if (!verifPassword(password.getText())) {
            erreurPass.setText("Insérer un mot de passe");
            test = false;
        }

        //System.out.println(verifMail(mail.getText()));
        if (!verifMail(mail.getText())) {
        erreurMail.setText("Veuillez saisir un email correcte");
        test=false;
        }
        
        if (sexe.getValue() == null) {
            erreurSexe.setText("Choisissez votre sexe");
            test = false;
        }
        if (test) {
            
        su.ajouterUser(usr);
        redirecting("GUILogin.fxml", "Connectez Vous !");
        ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    private void redirecting(String path, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public boolean verifMail(String a) {

        Boolean valide = false;
        int i, j, k;
        for (j = 1; j < a.length(); j++) {
            if (a.charAt(j) == '@') {
                if (j < a.length() - 4) {
                    for (k = j; k < a.length() - 2; k++) {
                        if (a.charAt(k) == '.') {
                            valide = true;
                        }
                    }
                }
            }
        }

        return valide;
    }
    
    public boolean verifPassword(String password)
    {
        boolean test=false;
        boolean test2=false;
        int i;
        for (i=0;i<password.length();i++)
        {
            if(Character.isDigit(password.charAt(i)))
            {
                test=true;
                i=password.length();
                System.out.println("test 1 :" +test);
            }
        }
        if(password.length()>8)
        {
            test2=true;
            System.out.println(test2);
        }
        if (test==test2)
          return test;
        return false;
    }

}
