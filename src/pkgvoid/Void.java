/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgvoid;

import Entities.EntityBabySitter;
import Entities.EntitySuggestion;
import Services.ServiceBabysitting;
import Services.ServiceSuggestion;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void start(Stage stage) throws IOException    {
     
   // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentController.fxml"));
   // Parent root = FXMLLoader.load(getClass().getResource("SuggestionAdd.fxml"));
  
  //Parent root = FXMLLoader.load(getClass().getResource("ListBabySitterr.fxml"));
  // Parent root = FXMLLoader.load(getClass().getResource("SuggestionAdd.fxml"));
   Parent root = FXMLLoader.load(getClass().getResource("ListSuggestion.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
       stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        launch(args);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
      
          
              Date date=(Date)sdf.parse("2018-01-01");
       // System.out.println("Affiché tous ");
                                   /*  BabySitter*/
        EntityBabySitter  b = new EntityBabySitter(1,date,"dimanche","tunis",12,123,"lllll",1);
       /* EntityBabySitter  b1 = new EntityBabySitter(2,"mardi","tunis",13,"12345","llllkkkl",2);
        EntityBabySitter  b2 = new EntityBabySitter(3,"mercredi","tunis",14,"12345","mmmm",3);*/
        ServiceBabysitting S =new ServiceBabysitting();
    // S.add(b);
       /* //S.add(b1);
        //S.add(b2);*/
        
      b.setHoraire("dimannche a 12h");
       b.setLieux("siliana");
        b.setDescription("mmmm");
       b.setN_tel(123);
       b.setPrix(65);
       S.update(b);
     // S.remove(1);
      /* // EntityBabySitter f =S.findById(2);
    //System.out.println("l'element trouvé"+f);
        
      //String lieux = S.findByLieux(lieux);
       // System.out.println("lieux trouvéé"+S.findByLieux("tunis"));*/
       
        // 
        System.out.println("Affiché tous "+ S.getAllBB());
        
       
                                   /*Suggestion */
                                   
                                  
   // EntitySuggestion sug = new EntitySuggestion(1, "mmmm", "lllll", "jjjj", 12547854, "mlopll", "hhhhhh", 1);
       // EntitySuggestion sug1 = new EntitySuggestion(2, "amal", "lllll", "jjjj", 12547854, "mlopll", "hhhhhh", 2);
        //  EntitySuggestion sug2 = new EntitySuggestion(3, "amyyal", "lll", "jj", 125854, "mlopll", "hhhhhh", 3);
         // EntitySuggestion sug3 = new EntitySuggestion(4, "aggmal", "llldddll", "jjjmmj", 17854, "mlollpll", "hllhhh", 4);
         // EntitySuggestion sug4 = new EntitySuggestion(5, "aggmal", "llldddll", "jjjmmj", 17854, "mlollpll", "hllhhh", 4);
   // ServiceSuggestion Ssug = new ServiceSuggestion();
   /* Ssug.add(sug4);*/
   // Ssug.add(sug1);
   //Ssug.add(sug2);
   //Ssug.add(sug3);
    //sug.setNom("mariouma");
    //sug.setPrenom("benkacem");
    //sug.setHoraire("kkkk");
    //sug.setAdresse("akkkk");
    //sug.setNote("disponible");
    //sug.setTelephone(125487);
    //sug.setType("garderie");
    //Ssug.update(sug);
  // Ssug.remove(1);
  
  
  //EntityBabySitter f =S.findById(2);
  //System.out.println("l'element trouvé"+f);
 
   // EntitySuggestion e =Ssug.findByid(4);
    
   //System.out.println("l'element trouvé :"+e);
   //System.out.println("l'element trouvé :"+Ssug.findByType("mlopll"));*/
 //System.out.println("Affiché tout :"+Ssug.getAll());
    
    }
    
}
