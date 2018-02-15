/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hendro Steven
 */
public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/dbkaryawan";
    private static final String USER = "root";
    private static final String PASS = "hst12345";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
