/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.Article;
import Entities.Conseil_Expert;
import Services.ArticleService;
import Services.Conseil_ExpertService;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fedi
 */
public class Void extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        Date d=new Date(2017, 12, 12);
        System.out.println(d);
        Article a=new Article(1, "grosesse", "aa", "aaa", 1, d);
        Article a4=new Article(4, "maman", "aa", "aaa", 1, d);
         Article a2=new Article(2, "enfant", "eee", "ee", 22, d);
          Article a3=new Article(3, "bébé", "bbb", "bb", 22, d);
         ArticleService ar=new ArticleService();
        //ar.ajouterArticle(a);
        //ar.ajouterArticle(a4);
        //ar.ajouterArticle(a2);
        //ar.ajouterArticle(a3);
        //a.setCategorie("maman");
        //ar.modifierArticle(a);
        //ar.supprimerArticle(2);
        //System.out.println("Test de methode rechercheByID: "+ ar.rchercheByID(1).toString());
        //System.out.println("Test de methode rechercheByCategorie: "+ ar.rchercheByCategorie("maman").toString());
        //System.out.println("Test de methode getAll: "+ar.getAll());
        Conseil_Expert c1=new Conseil_Expert(1, "grosesse", "gggggggg", 1);
        Conseil_Expert c2=new Conseil_Expert(2, "allaitement", "article pour jeune maman", 1);
        Conseil_Expert c3=new Conseil_Expert(3, "allaitement", "article pour jeune maman", 1);
        Conseil_ExpertService ce=new Conseil_ExpertService();
        //ce.ajouterConseil(c1);
        //ce.ajouterConseil(c2);
       // ce.ajouterConseil(c3);
        c1.setContenu("c'est un conseil de gynecologue");
        ce.modifierConseil(c1);
         //ce.supprimerConseil(3);
         System.out.println("test de methode recherchebyID "+ce.rchercheByID(2));
         System.out.println("test de methode recherchebyTitre "+ce.rchercheByTitre("allaitement"));
         System.out.println("test de methode getAll()  "+ce.getAll());
         
    }
    
}
