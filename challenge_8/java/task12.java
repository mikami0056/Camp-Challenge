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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHO
 */
public class task12 extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String birthdate = request.getParameter("birthdate"); 

        //データベースとの接続準備及び初期化
        Connection con = null; 
        //SQL用
        Statement db_st = null;
        //結果取得用
        ResultSet db_data = null;                                               
        //検索条件確認用インスタンスを生成
        task12a search = new task12a();
        
        search.setName(name);
        search.setAge(age);
        search.setBirthdate(birthdate);
        
        //検索条件が無記入の場合, 入力フォームに戻す
        if(search.confirmation()){
            try{
            //mysql接続用ドライバクラスをロード
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //各変数
            String url = "jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding=utf8";
            String user = "sho";
            String password = "shopass";
            //データベースへ接続
            con = DriverManager.getConnection(url,user,password);
            db_st = con.createStatement(); 
           
            String sql = search.getSql();
            db_data = db_st.executeQuery(sql);
                      
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>task12</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"./task12.jsp\">");
            
            while(db_data.next()){
               out.print("ID：" + db_data.getString("profilesID") + "<br>");
               out.print("名前：" + db_data.getString("name") + "<br>");
               out.print("電話番号：" + db_data.getString("tell") + "<br>");
               out.print("年齢：" + db_data.getString("age") + "<br>");
               out.print("誕生日：" + db_data.getString("birthday") + "<br>");
               out.print("<br>");
            }
            
            out.println("<input type=\"submit\" value=\"戻る\">");                        
            out.println("</body>");
            out.println("</html>");
 
        db_st.close();
        db_data.close();
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
        
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>task12</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>検索条件が入力されていません.</p>");
            out.println("<form action=\"./task12.jsp\">");
            out.println("<input type=\"submit\" value=\"戻る\">");                        
            out.println("</body>");
            out.println("</html>");
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
        } catch (SQLException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task12.class.getName()).log(Level.SEVERE, null, ex);
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
