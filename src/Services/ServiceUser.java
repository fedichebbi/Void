/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.config;
import Entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fedi
 */
public class ServiceUser {

    Connection con = config.getInstance().getConnection();
    private Statement ste;

    public ServiceUser() {
        try {

            ste = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterUser(EntityUser user) throws SQLException {

        String req = "INSERT INTO user (pseudo,password,nom,prenom,email,adresse,date_naiss,statut,type) "
                + "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPseudo());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getNom());
        preparedStatement.setString(4, user.getPrenom());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getAdresse());
        preparedStatement.setString(7, user.getDate_naissance());
        preparedStatement.setString(8, user.getStatut());
        preparedStatement.setString(9, "membre");
        //preparedStatement.setString(9, user.get;

        preparedStatement.executeUpdate();

    }

    public void supprimerUser(int id) throws SQLException {
        String req = "DELETE FROM user WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
        System.out.println(req);
    }
    
    public void modifierUser(EntityUser user,int id) throws SQLException{
        String req="UPDATE user SET "
                + "password=?,"
                + "nom=?,"
                + "prenom=?,"
                + "email=?,"
                + "adresse=?,"
                + "date_naiss=?,"
                + "statut=?"
                + "WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getNom());
        preparedStatement.setString(3, user.getPrenom());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getAdresse());
        preparedStatement.setString(6, user.getDate_naissance());
        preparedStatement.setString(7, user.getStatut());
        preparedStatement.setInt(8,id);
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }
}
