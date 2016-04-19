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
public class task10 extends HttpServlet {

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
        
        //削除用IDを取得(判断用)
        String ID = request.getParameter("ID");
        
        if("".equals(ID) != true){
        
            //データベース接続準備
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }catch(ClassNotFoundException e){
                e.getStackTrace();
            }
        
            Connection con = null;
            PreparedStatement db_st = null;
            int id = Integer.parseInt(ID); 
            
            //接続用各変数
            String url ="jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&characterEncoding = uft8";
            String name = "sho";
            String password = "shopass";
        
        
            try{
                con = DriverManager.getConnection(url,name,password);
                String sql = "DELETE FROM profiles WHERE profilesID = ?";
                db_st = con.prepareStatement(sql);
                //パラメータに値を代入
                db_st.setInt(1, id);
            
                db_st.executeUpdate();
                
                //表示
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>task10</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=\"./task10.jsp\">");
                out.println("SQL文の実行が完了しました<br>");
                out.println("<input type=\"submit\" value=\"戻る\">");                        
                out.println("</body>");
                out.println("</html>");
            
                db_st.close();
                con.close();
            
            }catch (SQLException e_sql) {
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
        } else if("".equals(ID) == true){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>task10</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>削除対象IDが入力されていません.</p>");
            out.println("<form action=\"./task10.jsp\">");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(task10.class.getName()).log(Level.SEVERE, null, ex);
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
