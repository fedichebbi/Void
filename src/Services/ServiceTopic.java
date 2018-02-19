/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.config;
import Entities.EntityTopic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fedi
 */
public class ServiceTopic {

    Connection con = config.getInstance().getConnection();
    private Statement ste;

    public ServiceTopic() {
        try {

            ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterTopic(EntityTopic topic) throws SQLException {
        String req = "INSERT INTO topic (titre,type,contenu,id_user) VALUES"
                + "(?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, topic.getTitre());
        preparedStatement.setString(2, topic.getType());
        preparedStatement.setString(3, topic.getContenu());
        preparedStatement.setInt(4, topic.getId_user());
        preparedStatement.executeUpdate();
    }

    public void supprimerTopic(int id) throws SQLException {
        String req = "DELETE FROM topic WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }

    public ObservableList<EntityTopic> LoadDb() throws SQLException {
        ObservableList<EntityTopic> data = FXCollections.observableArrayList();
        String req = "SELECT * FROM topic";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            data.add(new EntityTopic(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
        }
        return data;
    }
}
