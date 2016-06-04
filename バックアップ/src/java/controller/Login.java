/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.HandleRecaptchaLogic;
import Logic.LoginLogic;
import Logic.WordCheckLogic;
import java.io.IOException;
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
public class Login extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        
        //reCAPTCHA API用パラメータを取得
        String remoteIp = request.getRemoteAddr();
        String recap = request.getParameter("g-recaptcha-response");
        
        //ログイン用パラメータを取得
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        //セッション内にアカウント情報があれば遷移
        if(session.getAttribute("loginAccount") != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WorkSpaces");
            dispatcher.forward(request, response);
        }
        
        try{
            //データベース内にログイン情報があるかを確認
            boolean check = WordCheckLogic.getInstance().parameterCheck(userName, passWord);
            if(!check){
                //なければログイン画面に戻す
                response.sendRedirect("index.jsp?flag=error");
                System.out.println("フォーム入力エラーです.");
                return;
            }
            
            //reCAPTCHA API
            boolean varified = HandleRecaptchaLogic.getInstance(recap, remoteIp).connection2Google();
            if(varified){
                UserDataBeans loginAccount = LoginLogic.getInstance().LoginExecute(userName, passWord);
                if(loginAccount == null){
                    response.sendRedirect("index.jsp?flag=error");
                    System.out.println("アカウントが存在しません.");
                    return;
                }
                session.setAttribute("loginAccount", loginAccount);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WorkSpaces");
                dispatcher.forward(request, response);
                /*/DBなし
                UserDataBeans loginAccount = new UserDataBeans(userName, passWord);
                loginAccount.setMail("testmail");
                loginAccount.setPictureSum(10);
                loginAccount.setUserID(1);
                */
            }else{
                response.sendRedirect("index.jsp?flag=error");
                System.out.println("ボットである可能性があります.");
            }
        
        }catch(Exception e){
            response.sendRedirect("index.jsp?flag=caution");
            System.out.println("何かしらのエラーが発生しました.");
            e.printStackTrace();
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
