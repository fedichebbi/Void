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
import java.sql.ResultSet;
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

        String req = "INSERT INTO user (pseudo,password,type_m,email,type) "
                + "values(?,?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPseudo());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, "simple");
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, "membre");
        //preparedStatement.setString(9, user.get;

        preparedStatement.executeUpdate();

    }

    public void supprimerUser(int id) throws SQLException {
        String req = "DELETE FROM user WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
        //System.out.println(req);
    }

    public void modifierUser(EntityUser user, int id) throws SQLException {
        String req = "UPDATE user SET "
                + "password=?,"
                + "email=?,"
                + "WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, id);
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    public String verifLogin(String login, String password) throws SQLException {
        String req = "SELECT pseudo,password,type FROM user WHERE pseudo=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.setString(1,login);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            if(rs.getString(1).equals(login) && rs.getString(2).equals(password))
                return rs.getString(3);
        }
        return null;

    }
}
