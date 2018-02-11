/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.Article;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GUIAjouterArticleController implements Initializable {
     @FXML
    private TextField idtext;
    @FXML
    private TextField categorietext;
    @FXML
    private TextField titretext;
        @FXML
    private TextField contenuetext;
         @FXML
    private TextField notetext;
         @FXML
    private DatePicker dte_creationtext;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    private void clicked(ActionEvent event) throws SQLException {
         Article article=new Article(idtext.getText(), categorietext.getText(), titretext.getText(), contenuetext.getText(), 0, dte_creationtext.get)
    }
}
