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
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GUIAfficherArticleController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TableColumn<Article, Integer> note;

    @FXML
    private TableColumn<Article, String> categorie;

    @FXML
    private TableColumn<Article, String> contenue;

    @FXML
    private TableColumn<Article, String> titre;

    //@FXML
    //private TableColumn<?, ?> action;

    @FXML
    private TableColumn<Article, Integer> id;

    @FXML
    private TextField rechercheText;

    @FXML
    private TableColumn<Article, Date> date_creation;
     @FXML
    private TableView<Article> tableView_C;
     @FXML
      List<Article> list;
     ArticleService ar=new ArticleService();
     @FXML
      ObservableList<Article> champs = FXCollections.observableArrayList(ar.displayallarticle());
       @FXML
    private Button ajouter_btn;

    @FXML
    private Button supprimer_btn;
       @FXML
    private Button modifier_btn;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
      
          }    
    
    public void afficher()
    {
           
          tableView_C.setItems(champs);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
          titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        contenue.setCellValueFactory(new PropertyValueFactory<>("contenue"));
        note.setCellValueFactory(new PropertyValueFactory<>("note"));
        date_creation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
          // poster_name.setCellValueFactory(new PropertyValueFactory<>(""));
         for (int i = 1; i < list.size(); i++) {
              tableView_C.getItems().add(new Article(list));
    }
}
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("GUIAjouterArticle.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
   private  void supprimer(ActionEvent event) {
         Article act = tableView_C.getSelectionModel().getSelectedItem();
       
        ar.supprimerArticle(act.getId());
        int selectedIndex = tableView_C.getSelectionModel().getSelectedIndex();
        tableView_C.getItems().remove(selectedIndex);      
    }
    @FXML
    void modifier(ActionEvent event) {
        Article article = tableView_C.getSelectionModel().getSelectedItem();
        ar.modifierArticle(article);
        int selectedIndex = tableView_C.getSelectionModel().getSelectedIndex();
        tableView_C.getItems().set(selectedIndex,article);
        
    }
}