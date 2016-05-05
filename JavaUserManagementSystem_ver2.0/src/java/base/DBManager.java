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
            //追加点
            String url = "jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8";
            String user = "sho";
            String pass = "shopass";
            //変更点
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}
