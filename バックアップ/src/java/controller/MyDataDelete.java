/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.DeleteLogic;
import java.io.IOException;
import java.io.PrintWriter;
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
public class MyDataDelete extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mydatadelete.jsp");
        dispatcher.forward(request, response);
        /*
        try {
            HttpSession session = request.getSession();
            //ログインしているユーザー情報を取得
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            //ユーザー情報をもとにデータベースからユーザー情報を削除
            DeleteLogic.getInstance().deleteUserData(loginAccount);
            //セッションを削除
            session.invalidate();
            request.setAttribute("detail", "ユーザー情報削除");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/complete.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyDataDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyDataDelete.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        
         try {
            HttpSession session = request.getSession();
            //ログインしているユーザー情報を取得
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            //ユーザー情報をもとにデータベースからユーザー情報を削除
            DeleteLogic.getInstance().deleteUserData(loginAccount);
            //セッションを削除
            session.invalidate();
            request.setAttribute("detail", "ユーザー情報削除");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/complete.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyDataDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyDataDelete.class.getName()).log(Level.SEVERE, null, ex);
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
