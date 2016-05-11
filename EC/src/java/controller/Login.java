/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginLogic;
import model.UserDataBeans;
import model.UserDataDAO;
import model.UserDataDTO;

/**
 *
 * @author SHO
 */
public class Login extends HttpServlet {

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
               
        HttpSession session = request.getSession();
        
        if((UserDataBeans)session.getAttribute("loginAccount") != null){

            String done = "ログインしています";
            request.setAttribute("done", done);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp");
            dispatcher.forward(request, response);
        } else {
            //StringBuffer fromPlace = request.getRequestURL();
            //StringBuffer fromPlace =request.
            //System.out.println("ああああ"+fromPlace);
            //session.setAttribute("fromPlace", fromPlace);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
        //processRequest(request, response);
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
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
                
        if(request.getParameter("logout") != null){
            session.invalidate();
            String logout = "logout";
            request.setAttribute("logout", logout);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
        
        try{
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            
            //LoginLogicのインスタンスを取得後, ユーザー名とパスワードを使用してログインを実行
            //loginExecuteでは, UserDataBeans, UserDataDTO, UserDataDAOを使用してデータベースに接続している
            UserDataBeans loginAccount = LoginLogic.getInstance().loginExecute(userName, passWord);
            
            if(loginAccount != null){
                session.setAttribute("loginAccount", loginAccount);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp");
                dispatcher.forward(request, response);
            } else {
                //loginAccountがnullの場合で良いのでは?
                //request.setAttribute("notExist", "notExist");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp?flag=notExist");
                dispatcher.forward(request, response);
            }
            
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            
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
