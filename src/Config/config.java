/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
//jjjkjj
/**
 *
 * @author Fedi
 */

public class config {

    static config data;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/pidev";
    private Connection conn;
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    
    private config() {
        try { 
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
        } catch (SQLException ex) {
            System.out.println("construct config");
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static config getInstance() {
         if (data == null) {
          data = new config();   
         }
         return data;
        }

}