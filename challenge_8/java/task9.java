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
public class task9 extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        
        //task9.jspより情報を取得
        int id = Integer.parseInt(request.getParameter("ID"));
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String birthdate = request.getParameter("birthdate");
        
        //データベース接続準備
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.getStackTrace();
        }
        
        //データベースとの接続準備及び初期化
        Connection con = null; 
        //SQL用
        PreparedStatement db_st = null;

        //各変数
        String url = "jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8";
        String user = "sho";
        String password = "shopass"; 
        
        try{
           //データベースへ接続後, SQL文を登録
           con = DriverManager.getConnection(url,user,password);
           String sql = "INSERT INTO profiles VALUES (?, ?, ?, ?, ?)";
           db_st = con.prepareStatement(sql);
           
           db_st.setInt(1, id);
           db_st.setString(2, name);
           db_st.setString(3, tel);
           db_st.setInt(4, age);
           db_st.setString(5, birthdate);
           
           //SQL文を実行           
           db_st.executeUpdate();
           
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>task9</title>");            
           out.println("</head>");
           out.println("<body>");
           out.println("<form action=\"./task9.jsp\">");
           out.println("SQL文の実行が終了しました<br>");
           out.println("<input type=\"submit\" value=\"戻る\">");                        
           out.println("</body>");
           out.println("</html>");
           
           db_st.close();
           con.close();
           
        } catch (SQLException e_sql) {  
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
