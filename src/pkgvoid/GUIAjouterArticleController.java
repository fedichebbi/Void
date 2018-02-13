/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.Article;
import Services.ArticleService;
import java.io.IOException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GUIAjouterArticleController implements Initializable {
     @FXML
    private AnchorPane form;
     @FXML
    private TextField idtext;
    @FXML
    private TextField categorietext;
    @FXML
    private TextField titretext;
        @FXML
    private TextArea contenuetext;
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
     private   void ajouter(ActionEvent event) throws SQLException ,IOException{
         java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
         Article article=new Article( categorietext.getText(), titretext.getText(), contenuetext.getText(), 0, date_sql);
         ArticleService ar=new ArticleService();
         ar.ajouterArticle(article);
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GUIAjouterArticle.fxml"));
    }
       @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("GUIAfficherArticle.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}
