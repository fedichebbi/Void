/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.EntityBabySitter;
import Services.ServiceBabysitting;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benka
 */
public class ListBabySitterrController implements Initializable {

    @FXML
    private TableColumn<EntityBabySitter,String> id_horaire;
    @FXML
    private TableColumn<EntityBabySitter,String> id_lieu;
    @FXML
    private TableColumn<EntityBabySitter,Float> id_salaire;
    @FXML
    private TableColumn<EntityBabySitter,String> id_num;
    @FXML
    private TableColumn<EntityBabySitter,String> id_desc;
    @FXML
    private TableView<EntityBabySitter> table2;
     ServiceBabysitting bb = ServiceBabysitting.getInstance();
    //@FXML
    //private Button display;
    @FXML
    private Button delete;
    @FXML
    private Button id_update;
    @FXML
    private TextField id_rech;
    @FXML
    private Button id_recherche;
    @FXML
    private TextField idlieux;
    @FXML
    private TextField idsalaire;
    @FXML
    private TextField idNt;
    @FXML
    private TextField idhoraire;
    @FXML
    private TextArea ides;
    @FXML
    private Button id_mod;
    private TextField id;
    @FXML
    private Label idfk;
    @FXML
    private TextField idce;
    @FXML
    private TextField idd;
    @FXML
    private TableColumn<EntityBabySitter,Date> id_date;
    @FXML
    private Button id_ajou;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficher() {
        ObservableList<EntityBabySitter> data = bb.getAllBB();
        id_lieu.setCellValueFactory(new PropertyValueFactory<>("lieux"));
        id_salaire.setCellValueFactory(new PropertyValueFactory<>("prix"));
        id_num.setCellValueFactory(new PropertyValueFactory<>("n_tel"));
        id_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        id_date.setCellValueFactory(new PropertyValueFactory<>("date_dispo"));
        id_horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));

        table2.setItems(null);
        table2.setItems(data);
    }

    @FXML
    private void Supprimer(ActionEvent event)  throws SQLException {
       
        EntityBabySitter entity = table2.getSelectionModel().getSelectedItem();
        ServiceBabysitting ss = new ServiceBabysitting();
        
      ss.remove(entity.getId());
              //System.out.println("id="+entity.getId());
        int selectedIndex = table2.getSelectionModel().getSelectedIndex();
        table2.getItems().remove(selectedIndex);
  
    }
    


    @FXML
    private void modifier(ActionEvent event) throws SQLException {
    
         table2.setEditable(true);
        EntityBabySitter entityBabySitter =table2.getSelectionModel().getSelectedItem();
        int selectedIndex = table2.getSelectionModel().getSelectedIndex();
        int id = entityBabySitter.getId();
        table2.getItems().set(selectedIndex, entityBabySitter);
        idhoraire.setText(entityBabySitter.getHoraire());
        //int id2=entityBabySitter.getId();
                
        //this.id.setText(""+id);
        idNt.setText(""+entityBabySitter.getN_tel());
        idd.setText(""+entityBabySitter.getId());
        idfk.setText(""+entityBabySitter.getId_user());
        idlieux.setText(entityBabySitter.getLieux());
        ides.setText(entityBabySitter.getDescription());
       // id_date.set(entityBabySitter.getDate_dispo());
        
        
    }
    
    
     @FXML
    private void modifierBabysitter(ActionEvent event) throws SQLException {
         EntityBabySitter entityBabySitter = table2.getSelectionModel().getSelectedItem();
        int selectedIndex = table2.getSelectionModel().getSelectedIndex();
        entityBabySitter.setHoraire(idhoraire.getText());
        
       //entityBabySitter.setId(idd.getText());
        entityBabySitter.setLieux(idlieux.getText());
        //entityBabySitter.setN_tel(idNt.getText());
         //entityBabySitter.setPrix(idsalaire.getText());
         entityBabySitter.setDescription(ides.getText());
        // entityBabySitter.setDescription(id_date.getText());
        ServiceBabysitting serviceBabysitting = new ServiceBabysitting();
        serviceBabysitting.update(entityBabySitter);
        table2.getItems().set(selectedIndex, entityBabySitter);
        Afficher();
    }

        
   /*
    AnnoncesService AS=new AnnoncesService();
         Annonces a = new Annonces();
      a.setTitre(title_field.getText());
      a.setCategorie(categorie_field.getText());
      a.setVille(city_combo.getValue());
      a.setDescription(description_area.getText());
      a.setPrix(parseFloat(price_field.getText()));
      a.setType(type_combo.getValue());
     // a.setAnnée(parseInt(year_field.getText()));
      //a.setValide(false);
      a.setRegion(Region_Field.getText());
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
    //  a.setDate(d2);
      AS.update(a);
    */

    @FXML
    private void rechercherparLieux(ActionEvent event) {
        String lieux = id_rech.getText();
         ObservableList<EntityBabySitter> data = bb.findByLieux(lieux);
         id_date.setCellValueFactory(new PropertyValueFactory<>("date_dispo"));
        id_horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        id_lieu.setCellValueFactory(new PropertyValueFactory<>("lieux"));
            id_salaire.setCellValueFactory(new PropertyValueFactory<>("prix"));
                id_num.setCellValueFactory(new PropertyValueFactory<>("n_tel"));
        id_desc.setCellValueFactory(new PropertyValueFactory<>("description")); 
        
       table2.setItems(data);          
        
    }
   /*
    @FXML
    private void recherchef(KeyEvent event) {
       
        String nom=id_recherche.getText();//id_recherche l id ta3 label ili fou9 tableau
 
        
            ObservableList<Evenement> data = evenenement_service.getEventByID(nom);
             
           
      col_name.setCellValueFactory(new PropertyValueFactory<>("nom_evenement"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("lieu"));
          col_start.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         col_date.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        col_number.setCellValueFactory(new PropertyValueFactory<>("nbr_max_participant"));
         
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_yesno.setCellValueFactory(new PropertyValueFactory<>("participer"));
          col_namec.setCellValueFactory(new PropertyValueFactory<>("name_creator"));
        
       
   
        all_events_tab.setItems(data);
         
       
        
    }
    */ 

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("BabySitterAdd.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    
}
