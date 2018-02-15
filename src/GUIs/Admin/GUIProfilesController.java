/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Admin;

import Entities.EntityAdmin;
import Entities.EntityUser;
import Services.ServiceUser;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button deleteButton;
    @FXML
    private JFXTextField pseudo;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField email;
    @FXML
    private Button ajouter;
    @FXML
    private JFXTextField modifpseudo;
    @FXML
    private JFXPasswordField modifPass;
    @FXML
    private JFXTextField modifMail;
    @FXML
    private Button modifier;
    @FXML
    private JFXTextField modifId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.ServiceUser usr = new ServiceUser();

        data = FXCollections.observableArrayList();
        try {
            data = usr.LoadDb();
        } catch (SQLException ex) {
            Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProfileList.setItems(data);
        setCellTable();

    }

    private void setCellTable() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnPseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnType_M.setCellValueFactory(new PropertyValueFactory<>("type_M"));
        columnSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        columnSpecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));

    }

    @FXML
    private void deleteProfile(ActionEvent event) throws SQLException {
        EntityUser entity = ProfileList.getSelectionModel().getSelectedItem();
        ServiceUser usr = new ServiceUser();
        //Session.iactualiteService.deletebynamedate(act.getNom_event(), act.getDate_event());
        usr.supprimerUser(entity.getId());
        int selectedIndex = ProfileList.getSelectionModel().getSelectedIndex();
        ProfileList.getItems().remove(selectedIndex);
    }

    @FXML
    private void ajouterAdmin(ActionEvent event) throws SQLException {
        ServiceUser usr = new ServiceUser();
        EntityAdmin admin = new EntityAdmin(pseudo.getText(), password.getText(), email.getText());
        usr.ajouterAdmin(admin);
        data = usr.LoadDb();
        ProfileList.setItems(data);
    }

    @FXML
    private void modifierProfile(ActionEvent event){
        EntityUser entity = ProfileList.getSelectionModel().getSelectedItem();
        entity.setPseudo(modifpseudo.getText());
        if(modifPass.getText().equals(""))
        entity.setPassword(entity.getPassword());
        else entity.setPassword(modifPass.getText());
        entity.setEmail(modifMail.getText());
        ServiceUser usr=new ServiceUser();
        try {
            usr.modifierUser(entity, entity.getId());
        } catch (SQLException ex) {
            //Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            data = usr.LoadDb();
        } catch (SQLException ex) {
            //Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProfileList.setItems(data);
    }

    @FXML
    private void remplirModification(MouseEvent event) {
        EntityUser entity = ProfileList.getSelectionModel().getSelectedItem();
        modifId.setText(String.valueOf(entity.getId()));
        modifId.setEditable(false);
        modifpseudo.setText(entity.getPseudo());
        modifMail.setText(entity.getEmail());
        modifPass.setText(entity.getPassword());
    }

}
