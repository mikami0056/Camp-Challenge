/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.PictureGetLogic;
import Logic.SomeLogics;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PictureDataBeans;

/**
 *
 * @author gest
 */
public class WorkSpaces extends HttpServlet {


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
        
        HttpSession session = request.getSession(); 
        //ホーム画面からユーザーの行動内容をパラメータとして取得し, 各担当のコントローラに遷移.
        //パラメータがなければホーム画面に遷移.
        request.setCharacterEncoding("UTF-8");
        String option = request.getParameter("option");
        if(option == null){
            option = "";
        }
        
        String destination = "";//遷移先保存用変数
        //遷移判別
        switch(option){
                
            case "MyPage"://ユーザー管理画面遷移用
            destination = option;
            request.setAttribute("view", "mypage");
            break;
                
            case "Logout"://ログアウト画面遷移用
            destination = option;
            break;
                
            case "Contact"://お問い合わせ画面遷移用
            destination = option;
            break;
                
            default: //基本画面(ホーム)遷移用
            PictureGetLogic pgl = new PictureGetLogic();
            destination = "/WEB-INF/jsp/workspaces.jsp";
            
            try {
                //写真を1〜10まで取得
                //評価の高い写真
                Map<Integer, PictureDataBeans> pictureByRank = pgl.getPicturesByMethod("Rank");
                if(!pictureByRank.isEmpty()){
                    session.setAttribute("picturesByRank", pictureByRank);
                }else{
                    session.setAttribute("Rank", "empty");
                }
                
                ///新着の写真
                Map<Integer, PictureDataBeans> pictureByTime = pgl.getPicturesByMethod("Date");
                if(!pictureByTime.isEmpty()){
                    int i = 1;
                    for(Integer key : pictureByTime.keySet()){
                        PictureDataBeans p = pictureByTime.get(key);
                        System.out.println(i+"/"+p.getDateTime());
                        i++;
                    }
                    session.setAttribute("picturesByDate", pictureByTime);
                }else{
                    session.setAttribute("Date", "empty");
                }
                
                //新着コメントがついた写真
                Map<Integer, PictureDataBeans> pictureByComment = pgl.getPicturesByMethod("Comment");
                if(!pictureByComment.isEmpty()){
                    session.setAttribute("picturesByComment", pictureByComment);
                }else{
                    session.setAttribute("Comment", "empty");
                }
                
               
                } catch (SQLException ex) {
                    Logger.getLogger(WorkSpaces.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(WorkSpaces.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
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
        ServletContext application = this.getServletContext();
        HttpSession session = request.getSession(); 
        //ホーム画面からユーザーの行動内容をパラメータとして取得し, 各担当のコントローラに遷移.
        //パラメータがなければホーム画面に遷移.
        request.setCharacterEncoding("UTF-8");
        String option = request.getParameter("option");
        if(option == null){
            option = "";
        }
        
        String destination = "";//遷移先保存用変数
        //遷移判別
        switch(option){
                
            case "MyPage"://ユーザー管理画面遷移用
            destination = option;
            break;
                
            case "Logout"://ログアウト画面遷移用
            destination = option;
            break;
                
            case "Contact"://お問い合わせ画面遷移用
            destination = option;
            break;
                
            default: //基本画面(ホーム)遷移用
            PictureGetLogic pgl = new PictureGetLogic();
            destination = "/WEB-INF/jsp/workspaces.jsp";
            
            try {
                //写真を1〜10まで取得
                //評価の高い写真
                Map<Integer, PictureDataBeans> pictureByRank = pgl.getPicturesByMethod("Rank");
                //写真情報に変更があるかを判別する
                //boolean flag = (Boolean)application.getAttribute("flag");
                //セッション内に
                //boolean isExist = SomeLogics.getInstance().checkExistInSession(session, "picturesByRank");
                
                if(!pictureByRank.isEmpty()){
                    session.setAttribute("picturesByRank", pictureByRank);
                }else{
                    session.setAttribute("Rank", "empty");
                }
                
                ///新着の写真
                Map<Integer, PictureDataBeans> pictureByTime = pgl.getPicturesByMethod("Date");
                if(!pictureByTime.isEmpty()){
                    session.setAttribute("picturesByDate", pictureByTime);
                }else{
                    session.setAttribute("Date", "empty");
                }
                
                //新着コメントがついた写真
                Map<Integer, PictureDataBeans> pictureByComment = pgl.getPicturesByMethod("Comment");
                if(!pictureByComment.isEmpty()){
                    session.setAttribute("picturesByComment", pictureByComment);
                }else{
                    session.setAttribute("Comment", "empty");
                }
                
               
                } catch (SQLException ex) {
                    Logger.getLogger(WorkSpaces.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(WorkSpaces.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
        dispatcher.forward(request, response);
        
        /*
        //ホーム画面からユーザーの行動内容をパラメータとして取得し, 各担当のコントローラに遷移.
        //パラメータがなければホーム画面に遷移.
        request.setCharacterEncoding("UTF-8");
        String option = request.getParameter("option");
        if(option == null){
            option = "";
        }
        
        String destination = "";//遷移先保存用変数
        //遷移判別
        switch(option){
                
            case "MyPage"://ユーザー管理画面遷移用
            destination = option;
            request.setAttribute("view", "mypage");
            break;
                
            case "Logout"://ログアウト画面遷移用
            destination = option;
            break;
                
            case "Contact"://お問い合わせ画面遷移用
            destination = option;
            break;
                
            default: //基本画面(ホーム)遷移用
            destination = "/WEB-INF/jsp/workspaces.jsp";
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
        dispatcher.forward(request, response);
 
        /*
        try {
            
            System.out.println("workspaces doPost");
            /*
            List<PictureDataBeans> pictureList = PictureGetLogic.getInstance().PictureGetAll("sum");
            session.setAttribute("pictureList", pictureList);
            
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/workspaces.jsp");
            dispatcher.forward(request, response);
            /*
        } catch (SQLException ex) {
            
            Logger.getLogger(WorkSpaces.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
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
