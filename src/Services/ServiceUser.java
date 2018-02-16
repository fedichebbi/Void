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
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        String req = "INSERT INTO user (pseudo,password,type_m,email,type,sexe,specialite) "
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPseudo());
        preparedStatement.setString(2, user.getPassword());
        if (user instanceof EntityMembre) {
            preparedStatement.setString(3, ((EntityMembre) user).getType_M());
            preparedStatement.setString(5, "membre");
        } else {
            preparedStatement.setString(3, "");
        }
        preparedStatement.setString(4, user.getEmail());

        preparedStatement.setString(6, user.getSexe());
        if (user instanceof EntityExpert) {
            preparedStatement.setString(7, ((EntityExpert) user).getSpecialite());
            preparedStatement.setString(5, "expert");
        } else {
            preparedStatement.setString(7, "");
        }
        preparedStatement.executeUpdate();

    }

    public void ajouterAdmin(EntityUser user) throws SQLException {

        String req = "INSERT INTO user (pseudo,password,email,type) "
                + "values(?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPseudo());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, "admin");
        preparedStatement.executeUpdate();

    }

    public void supprimerUser(int id) throws SQLException {
        String req = "DELETE FROM user WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }

    public void modifierUser(EntityUser user, int id) throws SQLException {
        String req = "UPDATE user SET "
                + "password=?,"
                + "email=?,"
                + "pseudo=?"
                + "WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);

        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPseudo());
        preparedStatement.setInt(4, id);
        //System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    public String verifLogin(String login, String password) throws SQLException {
        String req = "SELECT pseudo,password,type FROM user WHERE pseudo=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.setString(1, login);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            if (rs.getString(1).equals(login) && rs.getString(2).equals(password)) {
                return rs.getString(3);
            }
        }
        return null;

    }

    public ObservableList<EntityUser> LoadDb() throws SQLException {
        ObservableList<EntityUser> data = FXCollections.observableArrayList();
        String req = "SELECT id,pseudo,password,email,type_M,specialite,type,sexe FROM user";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            if (rs.getString(7).equals("admin")) {
                data.add(new EntityAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8)));
            } else if (rs.getString(7).equals("membre")) {
                data.add(new EntityMembre(rs.getString(5), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8)));
            }
            else if(rs.getString(7).equals("expert")){
                data.add(new EntityExpert(rs.getString(6),rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8)));
            }
        }
        return data;
    }

    public EntityUser getUser(String name) throws SQLException {
        String req = "SELECT id,pseudo,password,email,type_M,specialite,type,sexe FROM user WHERE pseudo=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        EntityUser usr = null;
        if (rs.next()) {
            usr = new EntityUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8));
        }

        return usr;
    }

    public EntityUser getUserById(int id) throws SQLException {
        String req = "SELECT id,pseudo,password,email,type_M,specialite,type,sexe FROM user WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(req);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        EntityUser usr = null;
        if (rs.next()) {
            usr = new EntityUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(8));
        }

        return usr;
    }

}
