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
public class task2 extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection con = null;
        //PreparedStatement db_st = null;
        Statement db_st = null;
        ResultSet db_data = null;
        
        try{
            //ドライバクラスをロード
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //データベース接続用ローカル変数を宣言
            //String url = "jdbc:mysql://localhost:3306/challenge_db?charachterEncoding=utf8";
            String user = "sho";
            String password = "shopass";
            
            //データベースへ接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8", user, password);
            
            //データの追加
            db_st = con.createStatement();
            //SQL代入用変数
            int id = 1;
            String name = "山田太郎";
            String tell = "111-222-3333";
            int age = 88;
            String birthdate = "2000-01-01";
            
            String sql ="INSERT INTO profiles VALUES (" + id + ", \'" + name + "\', \'" + tell + "\', " + age + ", \'" + birthdate + "\')" ;
            db_st.execute(sql);
            out.print("SQL文「"+sql + "」の書き込みが終了しました");
            db_st.close();
            
        }catch (SQLException e_sql){
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(task2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
