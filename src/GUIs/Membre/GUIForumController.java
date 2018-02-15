/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Membre;

import Entities.EntityTopic;
import GUIs.Admin.GUIProfilesController;
import Services.ServiceTopic;
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
public class GUIForumController implements Initializable {

    @FXML
    private TableView<EntityTopic> TopicList;

    ObservableList<EntityTopic> data;
    @FXML
    private TableColumn<?, ?> columnTopic;
    @FXML
    private TableColumn<?, ?> columnPar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTopic st=new ServiceTopic();
        data = FXCollections.observableArrayList();
        try {
            data = st.LoadDb();
        } catch (SQLException ex) {
            Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TopicList.setItems(data);
        setCellTable();
        GUIMembreController controller=new GUIMembreController();
        System.out.println(controller.User().getId());
    }

    private void setCellTable() {
        columnTopic.setCellValueFactory(new PropertyValueFactory<>("titre"));
        columnPar.setCellValueFactory(new PropertyValueFactory<>("id_user"));

    }
}
