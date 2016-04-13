/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operatingData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.util.*;
import java.net.*;


/**
 *
 * @author SHO
 */
public class task1 extends HttpServlet {
    ArrayList<String> info = new ArrayList<String>();

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
        
        //リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        //String family;                                                          //名前
        //String first;
        //String gender;                                                          //性別
        //String hobbies;                                                         //趣味
        //String blood;
        
        String family = request.getParameter("family");
        infoadd(family);
        Cookie fname = new Cookie("fname", URLEncoder.encode(family, "UTF-8"));
        response.addCookie(fname);
        
        String first = request.getParameter("first");
        infoadd(first);
        
        String gender = request.getParameter("gender");
        infoadd(gender);
        
        String hobbies = request.getParameter("hobbies");
        infoadd(hobbies);
        
        String blood = request.getParameter("blood");
        infoadd(blood);
        
        //エラー
        String errorMessage = "";                                               //初期化
        if(family == null || family.length() == 0){                                 //名前未入力時
            errorMessage = errorMessage + "姓が入力されていません。<br>";
        } 
        
        if(first == null || first.length() == 0){
            errorMessage = errorMessage + "名が入力されていません。<br>";
        }
        
        if(gender == null || gender.length() == 0){                             //性別未選択時
            errorMessage = errorMessage + "性別が選択されていません。<br>";    
        } else {
            if("男性".equals(gender)){
            gender = "男性";    
            } else if ("女性".equals(gender)){
            gender = "女性";    
            }
        }

        if(hobbies == null || hobbies.length() == 0){                           //趣味が未入力
            hobbies = "無趣味の様";
        }  
   
        //表示するメッセージ
        String message = family + first + "さん(" + gender + ")を登録しました。<br>" + family + "さんの趣味は「" + hobbies + "」です。<br>"
                         + first + "さんの血液型は" + blood + "型です";
        if(errorMessage.length() != 0){                                         //エラーメッセージ有りの場合
            message = errorMessage;
        } 
        
        //HTMLを出力
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>task1</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<p>" + message + "</p>");
        out.println("</body>");
        out.println("</html>");
    
        
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

    public ArrayList<String> infoadd(String t){
        this.info.add(t);
        return info;
    }
}
