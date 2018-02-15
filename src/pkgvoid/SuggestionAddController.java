/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.EntitySuggestion;
import Services.ServiceSuggestion;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benka
 */
public class SuggestionAddController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
    private TextField id_Nom;

    @FXML
    private TextField id_Adresse;

    @FXML
    private TextField id_Horaire;

    @FXML
    private TextField id_Telephone;

    @FXML
    private TextField id_type;

    @FXML
    private TextArea id_Note;

    @FXML
    private Button id_Ajout;
    @FXML
    private JFXDatePicker id_datdeb;
    @FXML
    private JFXDatePicker id_datfin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    
    }  
    
    
    @FXML
    void AddSuggestion(ActionEvent event) throws SQLException, IOException {
          LocalDate localDate = id_datdeb.getValue();
          LocalDate localDate2 = id_datfin.getValue();
          EntitySuggestion e = new EntitySuggestion(id_Nom.getText(),id_Adresse.getText(),id_Horaire.getText(),Integer.parseInt(id_Telephone.getText()),id_type.getText(),id_Note.getText(),Date.valueOf(localDate),Date.valueOf(localDate2),1);
        ServiceSuggestion S = new ServiceSuggestion();
        S.add(e);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SuggestionAdd.fxml"));
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!"+id_datdeb.getValue());
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("ListSuggestion.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }
    
}
