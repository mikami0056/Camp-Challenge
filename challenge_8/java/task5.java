/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SHO
 */
public class task5 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //データベース接続準備
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        Connection con = null;
        PreparedStatement db_st = null;
        
        //各変数
        String url = "jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8";
        String user = "sho";
        String password = "shopass";
        
        try{
            //データベースに接続
            con = DriverManager.getConnection(url,user,password);
            
            //SQL文をセット
            String sql = "SELECT * FROM profiles WHERE name LIKE ?";
            db_st = con.prepareStatement(sql);
            
            //値をSQL文にセット
            db_st.setString(1, "%茂%");
            ResultSet db_data = db_st.executeQuery();
            
            while(db_data.next()){
               out.print("ID：" + db_data.getString("profilesID") + "<br>");
               out.print("名前：" + db_data.getString("name") + "<br>");
               out.print("電話番号：" + db_data.getString("tell") + "<br>");
               out.print("年齢：" + db_data.getString("age") + "<br>");
               out.print("誕生日：" + db_data.getString("birthday") + "<br>");
               out.print("<br>");
            }
            
            db_data.close();
            db_st.close();
            con.close();
            
    }catch(SQLException e_sql){
        out.println("接続時にエラーが発生したました1：" + e_sql.toString());            
        }catch (Exception e){
            out.println("接続時にエラーが発生しました2：" + e.toString());
        }finally {
            //out.println("接続成功!!");
            if(con != null){
                try{
                    con.close();
                } catch (Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
