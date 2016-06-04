/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gest
 */
public class dbmanager {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.0.27:3306/workspaces?useUnicode=true&characterEncoding=utf8";
            String user = "sho2";
            String pass = "sho2";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("DBConnected!!");
            return conn;
            
        } catch(ClassNotFoundException cnfe){
            cnfe = new ClassNotFoundException("クラスが存在しません");
            System.out.println(cnfe);
            cnfe.printStackTrace();
            
        } catch(SQLException sqle){
            sqle = new SQLException("SQL文のエラーが発生しました");
            System.out.println(sqle);
            sqle.printStackTrace();
            
        }
        return conn;
    }
}
