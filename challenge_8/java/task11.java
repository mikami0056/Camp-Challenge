/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHO
 */
public class task11 extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        //task11.jspより値を取得
        int id = Integer.parseInt(request.getParameter("ID"));
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String birthdate = request.getParameter("birthdate"); 
        
        //mysql接続用ドライバクラスをロード
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
            //データベースへ接続
            con = DriverManager.getConnection(url,user,password);
            String sql = "UPDATE profiles SET name = ?, tell = ?, age = ?, birthday = ? WHERE profilesID = ? ";
            db_st = con.prepareStatement(sql);
            
            //パラメータに値を代入
            db_st.setString(1, name);
            db_st.setString(2, tel);
            db_st.setInt(3, age);
            db_st.setString(4, birthdate);
            db_st.setInt(5, id);
            
            //SQL文を実行
            db_st.executeUpdate();
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>task10</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"./task11.jsp\">");
            out.print(sql + "の実行が終了しました<br>");
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
