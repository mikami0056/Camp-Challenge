/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.UpdateLogic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserDataBeans;

/**
 *
 * @author gest
 */
public class MyDataUpdate extends HttpServlet {

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
         String destination = "";
         
        if(request.getParameter("flag") != null){
            
            //ユーザー情報更新画面から入力された情報を取得
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String mail = request.getParameter("mail");
            
            try {
                
                //ログインしているユーザー情報を取得
                UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
                String oldName = loginAccount.getUserName();
                //入力された情報を新ユーザーに格納
                loginAccount.setProperties(userName, passWord, mail);
                //ユーザー情報を更新
                UpdateLogic.getInstance().updateUserData(loginAccount, oldName);
                request.setAttribute("detail", "ユーザー情報更新");
                //遷移先を保存
                destination = "/WEB-INF/jsp/complete.jsp";
                
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MyDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } else {
            
            destination = "/WEB-INF/jsp/mydataupdate.jsp";
            
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
        /*
         HttpSession session = request.getSession();
         String destination = "";
         
        if(request.getParameter("flag") != null){
            
            //ユーザー情報更新画面から入力された情報を取得
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String mail = request.getParameter("mail");
            
            try {
                
                //ログインしているユーザー情報を取得
                UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
                //入力された情報を新ユーザーに格納
                loginAccount.setProperties(userName, passWord, mail);
                //ユーザー情報を更新
                UpdateLogic.getInstance().updateUserData(loginAccount);
                request.setAttribute("detail", "ユーザー情報更新");
                //遷移先を保存
                destination = "/WEB-INF/jsp/complete.jsp";
                
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MyDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } else {
            
            destination = "/WEB-INF/jsp/mydataupdate.jsp";
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
        dispatcher.forward(request, response);
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
