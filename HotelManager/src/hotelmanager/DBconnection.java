/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author junyung
 */
public class DBconnection {
    static Connection conn =null;
    public static Connection makeConn()
    {
        //Load and Register the driver    
    try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
    // Establish the Connection
    String url ="jdbc:sqlserver://GUAPOJUN:1433;databaseName=Hotel_Manager";
    try{
       conn=DriverManager.getConnection(url,"sa","1234");
         JOptionPane.showMessageDialog(null, "getConnected");
         return conn;
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
    return null;
    }

        
        
    }
    
}
