package base;
/**
 *
 * @author hayashi-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            //変更点(課題5) ここから
            String url = "jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8";
            String user = "sho";
            String password = "shopass";
            con = DriverManager.getConnection(url, user, password);
            //変更点(課題5) ここまで
            
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}
