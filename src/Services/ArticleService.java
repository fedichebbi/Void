/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.Article;
import techniques.DataSource;

/**
 *
 * @author hp
 */
public class ArticleService {

    Connection conn = DataSource.getInsatance().getConnection();
    private Statement ste;

    public ArticleService() {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterArticle(Article a) throws SQLException {
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            String req = "insert into acticle(id_article,categorie,titre,contenu,note,date_creation) values(?,?,?,?,?,?)";
            // String req="insert into acticle(id_article,categorie,titre,contenu,note,date_creation) values(1,'aa','aa','rr',1,'1/1/2018')";
           PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            // preparedStatement.setInt(1, t.getId());
           // preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setInt(1, a.getId());
            preparedStatement.setString(2, a.getCategorie());
            preparedStatement.setString(3, a.getTitre());
            preparedStatement.setString(4, a.getContenue());
            preparedStatement.setInt(5, a.getNote());
            preparedStatement.setDate(6, date_sql);
            preparedStatement.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void modifierArticle(Article a){
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
             String req = "update acticle set categorie=?,titre=?,contenu=?,note=?,date_creation=? where id_article = ?";
        PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, a.getCategorie());
            preparedStatement.setString(2, a.getTitre());
            preparedStatement.setString(3, a.getContenue());
            preparedStatement.setInt(4, a.getNote());
            preparedStatement.setDate(5, date_sql);
            preparedStatement.setInt(6, a.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void supprimerArticle(Integer i)
    {
        try {
        String req = "delete from acticle where id_article =?";
        PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, i);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Article rchercheByID(Integer i)
    {
        Article article = null;
        String req = "select * from acticle where id_article =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                article = new Article(resultSet.getInt("id_article"), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return article;
    }
    
    public Article rchercheByCategorie(String c)
    {
        Article article = null;
        String req = "select * from acticle where categorie =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, c);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                article = new Article(resultSet.getInt(1), resultSet.getString("categorie"), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return article;
    }
     public List<Article> getAll() {
        Article article = null;
        List<Article> articles = new ArrayList<>();
        String req = "select * from acticle";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                article = new Article(resultSet.getInt(1), resultSet.getString("categorie"), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6));
                articles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return articles;
    }
    
    
}
