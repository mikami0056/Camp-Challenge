/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SHO
 */
public class RegisterConfirm extends HttpServlet {

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
        processRequest(request, response);
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
        
        try{
            String chkId = request.getParameter("id");
            if(chkId == null || (Integer)session.getAttribute("idForRegist") != Integer.parseInt(chkId)){
                System.out.println("[WARNING]:unauthorized access!! Please return to index.jsp. At RegisterConfirm.java");
                throw new Exception("不正なアクセスです");
            }
           
            String userName = request.getParameter("userName").trim();
            String passWord = request.getParameter("password");
            String mail = request.getParameter("mail");
            String address = request.getParameter("address");
            
            UserDataBeans udb = new UserDataBeans();
            udb.setName(userName);
            udb.setPassWord(passWord);
            udb.setMail(mail);
            udb.setAddress(address);
            System.out.println("[Notice]:USER's information had been iserted to UDB completely. At RegisterConfirm.java");
            
            session.setAttribute("udb", udb);
            System.out.println("[Notice]:UDB which has information is inputed in the session At RegisterConfirm.java");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerconfirm.jsp");
            System.out.println("[Notice]:dispacher generated");
            dispatcher.forward(request, response);
        
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
        //processRequest(request, response);
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
