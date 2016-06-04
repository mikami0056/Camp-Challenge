/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.RequestDispatcher;
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
public class PictureDetail extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        Integer ID = Integer.parseInt(request.getParameter("ID"));
        String option = request.getParameter("option");
        PictureDataBeans picture = new PictureDataBeans();
        
        switch(option){
            
            case "Rank":
            Map<Integer, PictureDataBeans> pictureByRank = (Map<Integer, PictureDataBeans>)session.getAttribute("picturesByRank");
            Enumeration names  = session.getAttributeNames();
            while(names.hasMoreElements()){
                System.out.println(names.nextElement());
            }
            picture = pictureByRank.get(ID);
            System.out.println(picture.getUserName());
            break;
            
            case "Time":
            Map<Integer, PictureDataBeans> pictureByTime = (Map<Integer, PictureDataBeans>)session.getAttribute("pictureByTime");
            picture = pictureByTime.get(ID);
            
            break;
            
            case "Comment":
            Map<Integer, PictureDataBeans> pictureByComment = (Map<Integer, PictureDataBeans>)session.getAttribute("pictureByComment");
            picture = pictureByComment.get(ID);
            break;
            
        }
        
        session.setAttribute("picture4Detail", picture);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/picturedetail.jsp");
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
