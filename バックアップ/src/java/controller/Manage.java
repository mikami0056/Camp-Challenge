/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.DeleteLogic;
import Logic.PictureGetLogic;
import Logic.UpdateLogic;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PictureDataBeans;
import model.UserDataBeans;

/**
 *
 * @author gest
 */
public class Manage extends HttpServlet {
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
            
        request.setCharacterEncoding("UTF-8");
        String destination = "";
        HttpSession session = request.getSession();
        
        try{
            
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            String contextPath = this.getServletContext().getContextPath();
            
            String option = (String)request.getAttribute("option");
            String name = "";
            switch(option){
                
                case "mypicturemanage":
                    //本番用
                    Map<String, PictureDataBeans> pictures = PictureGetLogic.getInstance().PictureGet(loginAccount, contextPath);
                    session.setAttribute("pictures", pictures);
                    destination = "/WEB-INF/jsp/mypicturemanager.jsp";
                    System.out.println("写真管理画面に進みます.");
                    
                break;
                
                case "Update":
                    name = request.getParameter("id");
                    Map<String, PictureDataBeans> pictures4Update = (HashMap<String, PictureDataBeans>)session.getAttribute("pictures");
                    PictureDataBeans pdb4Update = PictureGetLogic.getInstance().getPictureFromList(name, pictures4Update);
                    session.setAttribute("picture4Update", pdb4Update);
                    destination = "/WEB-INF/jsp/mypictureupdate.jsp";
                    System.out.println("写真更新画面に進みます.");
                break;
                
                case "Delete":
                    name = request.getParameter("id");
                    Map<String, PictureDataBeans> pictures4Delete = (Map<String, PictureDataBeans>)session.getAttribute("pictures");
                    PictureDataBeans pdb4Delete = PictureGetLogic.getInstance().getPictureFromList(name, pictures4Delete);
                    session.setAttribute("picture4Delete", pdb4Delete);
                    destination = "/WEB-INF/jsp/mypicturedelete.jsp";
                    System.out.println("写真削除画面に進みます.");
                break;
            }
            
            //RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
            //dispatcher.forward(request, response);
            
        } catch(Exception e){
            System.out.println("エラーが発生しました / "+e.getMessage());
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
        
        request.setCharacterEncoding("UTF-8");
        String destination = "";
        
        try{
            
            HttpSession session = request.getSession();
            UserDataBeans loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            String option = (String)request.getAttribute("option");
            if(option == null){
                option = request.getParameter("option");
            }
            //System.out.println("["+option+"]");
            
            switch(option){
                
                case "mypicturemanage":
                    String contextPath = this.getServletContext().getContextPath();
                    Map<String, PictureDataBeans> pictures = PictureGetLogic.getInstance().PictureGet(loginAccount, contextPath);
                    session.setAttribute("pictures", pictures);
                    destination = "/WEB-INF/jsp/mypicturemanager.jsp";
                    System.out.println("写真管理画面に進みます.");
                break;
                    
                case "Update":
                    
                    PictureDataBeans pdb4Update = (PictureDataBeans)session.getAttribute("picture4Update");
                    String oldName = pdb4Update.getName();
                    pdb4Update.reInputName4Path(request.getParameter("name"));
                    pdb4Update.setName(request.getParameter("name"));
                    pdb4Update.setComment(request.getParameter("comment"));
                    pdb4Update.setCategory(Integer.parseInt(request.getParameter("category")));
                    System.out.println("テスト" + pdb4Update.getPath());
                    UpdateLogic.getInstance().updatePictureData(pdb4Update, loginAccount, oldName);
                    session.setAttribute("picture4Update", pdb4Update);
                    destination = "/WEB-INF/jsp/mypage.jsp";
                    
                break;
                
                case "Delete":
                    PictureDataBeans pdb4Delete = (PictureDataBeans)session.getAttribute("picture4Delete");
                    DeleteLogic.getInstance().deletePictureData(pdb4Delete, loginAccount);
                    
                    destination = "/WEB-INF/jsp/mypage.jsp";
                break;
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
            dispatcher.forward(request, response);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
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
