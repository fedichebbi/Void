/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.Membre;

import Entities.EntityTopic;
import Entities.EntityUser;
import GUIs.Admin.GUIProfilesController;
import Services.ServiceTopic;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

        showTable();

    }

    public void showTable() {
        ServiceTopic st = new ServiceTopic();
        data = FXCollections.observableArrayList();
        try {
            data = st.LoadDb();
        } catch (SQLException ex) {
            Logger.getLogger(GUIProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TopicList.setItems(data);
        setCellTable();
    }

    private void setCellTable() {
        columnTopic.setCellValueFactory(new PropertyValueFactory<>("titre"));
        columnPar.setCellValueFactory(new PropertyValueFactory<>("id_user"));
    }

    @FXML
    private void addTopic(ActionEvent event) throws IOException {
        //((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUIAddTopic.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
