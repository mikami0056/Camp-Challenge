/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.logic.ConvertingTimeLogic;

/**
 *
 * @author gest
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
        try {
                    HttpSession session = request.getSession();

        //日付と時刻のパラメータを取得
        //日付 yyyy-MM-dd
        //時刻 HH:mm
        String strDate = request.getParameter("date");
        String strTime = request.getParameter("time");
        
        //これで、String⇨java.sql.Date,Timeへの変換が終了
        ConvertingTimeLogic ctl = new ConvertingTimeLogic();   
        java.sql.Date sqlDate = ctl.toSqlDateFromString(strDate);
        java.sql.Time sqlTime = ctl.toSqlTimeFromString(strTime);
        
        //ここでjava.sql.Date,TimeからStringへの変換が終了
        String strDate2 = ctl.toStringFromSqlDate(sqlDate);
        session.setAttribute("date",strDate2);
        String strTime2 = ctl.toStringFromSqlTime(sqlTime);
        session.setAttribute("time",strTime2);
        
        Date ddd = new Date();
        String logicTest1 = ctl.toStringDateFromUtilDate(ddd);
        String logicTest2 = ctl.toStringTimeFromUtilDate(ddd);
        
        request.getRequestDispatcher("MenuController?controller=menu").forward(request,response);
        } catch (ParseException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
