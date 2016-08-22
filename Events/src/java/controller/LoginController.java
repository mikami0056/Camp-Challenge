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

        String test = request.getParameter("test");
        String abc  = request.getParameter("abc");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        Date d = sdf.parse(test);
        Date t = sdf2.parse(abc);
        
        ConvertingTimeLogic ctl = new ConvertingTimeLogic();
        java.sql.Date tt1 = ctl.toSqlDate(d);
        java.sql.Time tt2 = ctl.toSqlTime(t);
        
        //Date aa = ctl.toUtilDateFromSqlDateAndSqlTime(tt1, tt2);
        
        //Date bb = ctl.toUtilDateFromSqlDate(tt1);
        String bb = ctl.toStringFromSqlDate(tt1);
        session.setAttribute("test",bb);
        //Date cc = ctl.toUtilDateFromSqlTime(tt2);
        String cc = ctl.toStringFromSqlTime(tt2);
        session.setAttribute("abc",cc);
        Date date = null;
        try {
            date = sdf.parse((test + " " + abc));
            
        } catch (ParseException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(date);
        //session.setAttribute("test",test);
        //session.setAttribute("abc",abc);
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
