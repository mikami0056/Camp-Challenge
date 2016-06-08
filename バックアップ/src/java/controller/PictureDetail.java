/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.CountLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CountDataBeans;
import model.PictureDataBeans;
import model.UserDataBeans;
import net.arnx.jsonic.JSON;

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
        
        String strID = request.getParameter("ID");
        Integer ID = Integer.parseInt(strID);
        String option = request.getParameter("option");
        UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
        PictureDataBeans picture = new PictureDataBeans();
        
        
        CountDataBeans countData = (CountDataBeans)session.getAttribute(strID);
        if(countData == null){
            countData = new CountDataBeans();
            CountLogic.getInstance().getDataFromDB(countData);
        }
        
        switch(option){
            
            case "Rank":
            Map<Integer, PictureDataBeans> pictureByRank = (Map<Integer, PictureDataBeans>)session.getAttribute("picturesByRank");
            picture = pictureByRank.get(ID);
            countData.setUserID(loginAccount.getUserID());
            countData.setPictureID(picture.getPictureID());
            System.out.println(picture.getUserName());
            break;
            
            case "Time":
            Map<Integer, PictureDataBeans> pictureByTime = (Map<Integer, PictureDataBeans>)session.getAttribute("pictureByTime");
            picture = pictureByTime.get(ID);
            countData.setUserID(loginAccount.getUserID());
            countData.setPictureID(picture.getPictureID());
            break;
            
            case "Comment":
            Map<Integer, PictureDataBeans> pictureByComment = (Map<Integer, PictureDataBeans>)session.getAttribute("pictureByComment");
            picture = pictureByComment.get(ID);
            countData.setUserID(loginAccount.getUserID());
            countData.setPictureID(picture.getPictureID());
            break;
            
        }
        CountLogic.getInstance().getDataFromDB(countData);
        session.setAttribute("picture4Detail", picture);
        session.setAttribute(strID, countData);
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
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");
        
        HttpSession session = request.getSession();
        
        /*
        UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
        */
        PictureDataBeans picture4Detail = (PictureDataBeans)session.getAttribute("picture4Detail");
        String strID = request.getParameter("pictureID");
        CountDataBeans countData = (CountDataBeans)session.getAttribute(strID);
        String param = request.getParameter("param");
        int returnParam = CountLogic.getInstance().countAndGetDataFromDB(countData, param, picture4Detail);
        out.print(JSON.encode(returnParam));
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
