/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Conseil_Expert;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import techniques.DataSource;

/**
 *
 * @author hp
 */
public class Conseil_ExpertService {
     Connection conn = DataSource.getInsatance().getConnection();
    private Statement ste;

    public Conseil_ExpertService() {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void ajouterConseil(Conseil_Expert c) throws SQLException {
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            String req = "insert into conseil_e(id_conseil,titre,contenu,id_user) values(?,?,?,?)";
            
           PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, c.getId_conseil());
            preparedStatement.setString(2, c.getTitre());
            preparedStatement.setString(3, c.getContenu());
            preparedStatement.setInt(4, c.getId_user());
            preparedStatement.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void modifierConseil(Conseil_Expert c){
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
             String req = "update conseil_e set titre=?,contenu=?,id_user=? where id_conseil = ?";
        PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, c.getTitre());
            preparedStatement.setString(2, c.getContenu());
            preparedStatement.setInt(3, c.getId_user());
            preparedStatement.setInt(4, c.getId_conseil());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
      public void supprimerConseil(Integer i)
    {
        try {
        String req = "delete from conseil_e where id_conseil =?";
        PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, i);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      
       public Conseil_Expert rchercheByID(Integer i)
    {
        Conseil_Expert conseil = null;
        String req = "select * from conseil_e where id_conseil =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                conseil = new Conseil_Expert(resultSet.getInt("id_conseil"), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conseil;
    }
       
        public Conseil_Expert rchercheByTitre(String c)
    {
        Conseil_Expert conseil = null;
        String req = "select * from conseil_e where titre =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, c);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                conseil = new Conseil_Expert(resultSet.getInt(1), resultSet.getString("titre"), resultSet.getString(3), resultSet.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conseil;
    }
         public List<Conseil_Expert> getAll() {
        Conseil_Expert conseil = null;
        List<Conseil_Expert> conseils = new ArrayList<>();
        String req = "select * from conseil_e";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                conseil = new Conseil_Expert(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                conseils.add(conseil);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conseils;
    }
}
