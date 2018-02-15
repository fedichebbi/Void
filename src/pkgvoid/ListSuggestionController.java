/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.EntitySuggestion;

import Services.ServiceSuggestion;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
//import sun.security.krb5.internal.EncAPRepPart;

/**
 * FXML Controller class
 *
 * @author benka
 */
public class ListSuggestionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
    private TableView<EntitySuggestion> table;

    ServiceSuggestion sug = ServiceSuggestion.getInstance();
     @FXML
    private TableColumn<EntitySuggestion, String> id_horaire;
    @FXML
    private TableColumn<EntitySuggestion, String> id_Nom;
    @FXML
    private TableColumn<EntitySuggestion, String> id_Adress;
    @FXML
    private TableColumn<EntitySuggestion, Integer> id_tel;
    @FXML
    private TableColumn<EntitySuggestion, String> id_type;
    @FXML
    private TableColumn<EntitySuggestion, String> id_note;
    @FXML
    private Button id_delete;
    @FXML
    private TextField id_rech;
    @FXML
    private Button id_recher;
    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_adress;
    @FXML
    private TextField idnote;
    @FXML
    private Button id_modif;
    @FXML
    private Button id_recup;
    @FXML
    private TextField idtype;
    @FXML
    private TextField idtel;
    @FXML
    private TextField idhoraire;
    @FXML
    private TextField idd;
    @FXML
    private TextField idfk;
    @FXML
    private TableColumn<EntitySuggestion, Date> dat_deb;
    
    @FXML
    private TableColumn<EntitySuggestion, Date> date_fin;
    @FXML
    private Button Ajouter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficher() {
        ObservableList<EntitySuggestion> data = sug.getAll();
        id_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        id_Adress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        id_horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        id_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        id_tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        id_note.setCellValueFactory(new PropertyValueFactory<>("note"));
        dat_deb.setCellValueFactory(new PropertyValueFactory<>("date_deb"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        table.setItems(null);
        table.setItems(data);
        
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        EntitySuggestion entity = table.getSelectionModel().getSelectedItem();
        ServiceSuggestion ss = new ServiceSuggestion();
        
      ss.remove(entity.getId());
              System.out.println("id="+entity.getId());
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedIndex);
        
    }

    @FXML
    private void recherchepartype(ActionEvent action) {
       String lieux = id_rech.getText();
       ObservableList<EntitySuggestion> data = sug.findByType(lieux);
        id_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        id_Adress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        id_horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        id_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        id_tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        id_note.setCellValueFactory(new PropertyValueFactory<>("note"));
        dat_deb.setCellValueFactory(new PropertyValueFactory<>("date_deb"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        //table.setItems(null);
        table.setItems(data);
    }
    
    /*
     @FXML
    private void rechercherparLieux(ActionEvent event) {
        String lieux = id_rech.getText();
         ObservableList<EntityBabySitter> data = bb.findByLieux(lieux);
        id_horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        id_lieu.setCellValueFactory(new PropertyValueFactory<>("lieux"));
            id_salaire.setCellValueFactory(new PropertyValueFactory<>("prix"));
                id_num.setCellValueFactory(new PropertyValueFactory<>("n_tel"));
        id_desc.setCellValueFactory(new PropertyValueFactory<>("description")); 
        
       table2.setItems(data);          
        
    }
    */

    @FXML
    private void Modifier(ActionEvent event) 
    {
        table.setEditable(true);
        EntitySuggestion entitySuggestion =table.getSelectionModel().getSelectedItem();
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        int id = entitySuggestion.getId();
        table.getItems().set(selectedIndex, entitySuggestion);
        id_adress.setText(entitySuggestion.getAdresse());
        id_nom.setText(entitySuggestion.getNom());
        idhoraire.setText(entitySuggestion.getHoraire());
        idtel.setText(""+entitySuggestion.getTelephone());
        idtype.setText(entitySuggestion.getType());
        idnote.setText(entitySuggestion.getNote());
        idd.setText(""+entitySuggestion.getId());
        dat_deb.setText(""+entitySuggestion.getDate_deb());
        date_fin.setText(""+entitySuggestion.getDate_fin());
        idfk.setText(""+entitySuggestion.getId_user());
        
        
       
}

    @FXML
    private void modifierSuggestion(ActionEvent event) throws SQLException {
       EntitySuggestion entitySuggestion = table.getSelectionModel().getSelectedItem();
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        entitySuggestion.setNom(id_nom.getText());
        entitySuggestion.setAdresse(id_adress.getText());
        entitySuggestion.setHoraire(idhoraire.getText());
        //entitySuggestion.setTelephone(""+id_tel.getText());
         entitySuggestion.setType(idtype.getText());
         entitySuggestion.setNote(idnote.getText());
        ServiceSuggestion serviceSuggestion = new ServiceSuggestion();
        serviceSuggestion.update(entitySuggestion);
        table.getItems().set(selectedIndex, entitySuggestion);
        Afficher();
        
    }
    
        @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("SuggestionAdd.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /*modifierArticle(ActionEvent event) {
         java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
         Article article = tableView_C.getSelectionModel().getSelectedItem();
         int selectedIndex = tableView_C.getSelectionModel().getSelectedIndex();
        ///Article article=new Article( categorietext.getText(), titretext.getText(), contenuetext.getText(), 1, date_sql);
       article.setCategorie(contenuetext.getText());
         article.setTitre(titretext.getText());
         article.setContenue(contenuetext.getText());
         ArticleService ar=new ArticleService();
         ar.modifierArticle(article);
          tableView_C.getItems().set(selectedIndex, article);
         afficher();
    }*/
    
    
}
