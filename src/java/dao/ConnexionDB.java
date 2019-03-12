/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hicham
 */
public class ConnexionDB {
    private static  Connection connection ;
    
    static {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiant_ti","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static Connection getConnection() {
        return connection;
    }
}
