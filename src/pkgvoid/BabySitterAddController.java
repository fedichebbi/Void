/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import Entities.EntityBabySitter;
import Services.ServiceBabysitting;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benka
 */
public class BabySitterAddController implements Initializable {

    
    @FXML
    private TextField id_horaire;

    @FXML
    private TextField id_lieux;

    @FXML
    private TextField id_salaire;

    @FXML
    private TextField id_num;
    

    @FXML
    private TextArea id_desc;
    @FXML
    private DatePicker date;


 
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    private void handleButtonAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("BabySitterAdd.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AddBabySitter(ActionEvent event) throws SQLException, IOException {
         LocalDate localDate = date.getValue();
        EntityBabySitter b = new EntityBabySitter(Date.valueOf(localDate), id_horaire.getText(), id_lieux.getText(),Float.parseFloat(id_salaire.getText()),Integer.parseInt(id_num.getText()), id_desc.getText(),1);
        ServiceBabysitting S = new ServiceBabysitting();
        S.add(b);
        //((Node) (event.getSource())).getScene().getWindow().hide();
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("BabySitterAdd.fxml"));
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("ListBabySitterr.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
      
      // redirecting("pkgvoid/ListBabySitterr.fxml", "test", event);        
     
                // LocalDate localDate2 = date2.getValue();
    //Evenement e2=new Evenement(nom_evenement.getText(), lieu.getText(), Date.valueOf(localDate),Date.valueOf(localDate2) , Integer.parseInt(nbr_max.getText()),yes_no.getText(), description.getText());
           
      // evenenement_service.createEvent(e2)        

    }

   /* private void redirecting(String javafxapplication2FXMLfxml, String test, ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    private void redirecting(String pkgvoidListBabySitterrfxml, String test, ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
 /* Parent root2 = loader.load();
               ListBabySitterController list = loader.getController();
            Stage stage = new Stage();
                Scene scene = null;
                stage.setScene(scene);
               stage.setScene(scene);
                stage.show();
                //.getScene().setRoot(root2);*/
       
        
        /*private void windows(String path, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

*/