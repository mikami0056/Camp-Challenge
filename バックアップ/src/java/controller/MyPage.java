/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author gest
 */
public class MyPage extends HttpServlet {

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
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
        dispatcher.forward(request, response);
        
        /*
        String view = (String)request.getAttribute("view");
        String destination = "";
        
        if(view != null){
            switch(view){
                
                case "mypage":
                destination = "/WEB-INF/jsp/mypage.jsp";
                break;
                
            }
        }
        /*
        int option = Integer.parseInt(request.getParameter("option"));
        
        String destination = "";
        
        //遷移分岐
        switch(option){
            case 0://マイページ画面遷
            destination = "/WEB-INF/jsp/mypage.jsp";
            break;

            case 11:
            destination = "Upload";
            break;
            
            case 12:
            destination = "Manage?option=11";
            break;
                
            case 13://ユーザー情報変更画
            destination = "MyData";
            break;
        }
        */
        
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
        
        /*
        @ 各ページから遷移先をパラメータとして取得
        @ option:サーブレット遷移用, 主にcontrollerフォルダ内のファイル
        */
        String option = request.getParameter("option");
        String destination = "";
        
        if(option != null){
            
            switch(option){
                
                //写真投稿遷移
                case "Upload":
                destination = option;
                request.setAttribute("view", "uploadpicture");
                break;
                
                //写真管理遷移
                case "Manage":
                destination = option;
                request.setAttribute("option", "mypicturemanage");
                break;
                
                //ユーザー情報更新遷移
                case "MyDataUpdate":
                destination = option;
                break;
                
                //ユーザー情報削除遷移
                case "MyDataDelete":
                destination = option;
                break;
                
            }
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
