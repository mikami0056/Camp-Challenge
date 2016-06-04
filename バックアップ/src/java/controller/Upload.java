/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.UploadLogic;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PictureDataBeans;
import model.UserDataBeans;


/**
 *
 * @author gest
 */
public class Upload extends HttpServlet {

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
        
        
        //System.out.println("[お知らせ]マイページ画面からアップロードサーブレットに遷移してきました");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uploadpictures.jsp");
        dispatcher.forward(request, response);
        
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
        
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //ユーザー管理画面から遷移してきた場合, 変数viewにuploadpictureが入る
        String view = (String)request.getAttribute("view");
        String destination = "";
        
        //写真をデータベースとサーバに保存
        if(view == null || !view.equals("uploadpicture")){
            
            HttpSession session = request.getSession();
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            //写真情報に格納するためのパスを取得
            String contextPath = this.getServletContext().getContextPath();
            //パスとログイン情報, 洗濯された写真情報をもとに, データベースにそれらを保存
            UploadLogic.getInstance().pictureUpload(request, loginAccount, contextPath);
            destination = "/WEB-INF/jsp/uploadpicturescomplete.jsp";
            
        } else {
            
            destination = "/WEB-INF/jsp/uploadpictures.jsp";
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
        dispatcher.forward(request, response);
       
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
