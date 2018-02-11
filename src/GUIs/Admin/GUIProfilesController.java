/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Admin;

import Entities.EntityUser;
import Services.ServiceUser;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Fedi
 */
public class GUIProfilesController implements Initializable {

    @FXML
    private TableColumn<?, ?> columnId;
    @FXML
    private TableColumn<?, ?> columnPseudo;
    @FXML
    private TableColumn<?, ?> columnEmail;
    @FXML
    private TableColumn<?, ?> columnType;
    @FXML
    private TableColumn<?, ?> columnType_M;
    @FXML
    private TableColumn<?, ?> columnSexe;
    @FXML
    private TableColumn<?, ?> columnSpecialite;
    @FXML
    private TableView<Entities.EntityUser> ProfileList;
    
    ObservableList<EntityUser> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.ServiceUser usr=new ServiceUser();
        
        data =FXCollections.observableArrayList();
        try {
            data= usr.LoadDb();
        } catch (SQLException ex) {
            Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProfileList.setItems(data);
        setCellTable();
        
    }    
    
    private void setCellTable()
    {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnPseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnType_M.setCellValueFactory(new PropertyValueFactory<>("type_M"));
        columnSexe.setCellValueFactory(new PropertyValueFactory<>("sexe")); 
        columnSpecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        
    }
}
