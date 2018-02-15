/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.config;
import Entities.EntityCommentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fedi
 */
public class ServiceCommentaire {
        Connection con = config.getInstance().getConnection();
    private Statement ste;

    public ServiceCommentaire() {
        try {

            ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        public void ajouterTopic(EntityCommentaire commentaire) throws SQLException{
        String req="INSERT INTO commentaire (id,id_user,id_topic,contenu) VALUES"
                + "(?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setInt(1, commentaire.getId());
        preparedStatement.setInt(2, commentaire.getId_user());
        preparedStatement.setInt(3, commentaire.getId_topic());
        preparedStatement.setString(4, commentaire.getContenu());
        preparedStatement.executeUpdate();
    }
}
