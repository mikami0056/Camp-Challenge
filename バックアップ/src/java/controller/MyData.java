/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.DeleteLogic;
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
public class MyData extends HttpServlet {

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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mydataupdate.jsp");
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
        
            String destination = "";//遷移先保持用
            
            //ホーム画面からユーザーの行動内容を取得して, 各担当のコントローラに遷移
            int option = Integer.parseInt(request.getParameter("option"));
            HttpSession session = request.getSession();
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
        
        try {
            
            switch(option){
                
                case 1://ユーザ情報更新画面遷移
                    destination = "/WEB-INF/jsp/mydataupdate.jsp";
                    break;
                    
                case 2://ユーザ情報削除画面遷移
                    destination = "/WEB-INF/jsp/mydatadelete.jsp";
                    break;
                    
                case 21:
                    UpdateLogic.getInstance().updateUserData(loginAccount);
                    destination = "/WEB-INF/jsp/complete.jsp";
                    request.setAttribute("detail", "ユーザー情報更新");
                break;
                
                case 22:
                    DeleteLogic.getInstance().deleteUserData(loginAccount);
                    destination = "/WEB-INF/jsp/complete.jsp";
                    request.setAttribute("detail", "ユーザー情報削除");
                break;
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyData.class.getName()).log(Level.SEVERE, null, ex);
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
