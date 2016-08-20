/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gest
 */
public class DBConnector {
    
    private final String JDBC   = "jdbc:mysql://";
    private final String SERVER = "localhost:3306/";
    private final String DB     = "BackBone";
    private final String USER   = "bbuser";
    private final String PASS   = "Launch@0816";
    
    //JDBCのロード
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    
    public static DBConnector getInstance(){
        return new DBConnector();
    }
    
    public Connection dbConnect(){
        Connection con = null;
        try{
            String mysqlHost = JDBC + SERVER + DB;
            con = DriverManager.getConnection(mysqlHost,USER,PASS);
            System.out.println("データベースに接続しました");
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return con;
    }
}
