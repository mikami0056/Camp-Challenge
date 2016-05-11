/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemDetails;
import org.w3c.dom.Element;

/**
 *
 * @author SHO
 */
public class Item extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        
        try{
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            //セッションから商品一覧を取得
            Map<String, ItemDetails> itemSearchList = (Map<String, ItemDetails>)session.getAttribute("itemSearchList");
            
            //クエリストリングからindexを取得し, 商品一覧から特定の商品を取得
            ItemDetails item = itemSearchList.get(request.getParameter("index"));            
            request.setAttribute("productID",item.getProductID());
            
            //商品IDと商品を紐付けてセッションスコープに保存(ない場合)
            if((ItemDetails)session.getAttribute(item.getProductID()) == null){
                System.out.println("商品をセッションに追加:[商品名]["+item.getName() + "]");
                session.setAttribute(item.getProductID(), item);
            } else {
                System.out.println("商品名["+item.getName() + "]はもうセッション内にあります");
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e){
            request.setAttribute("error", e.getMessage());
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
        processRequest(request, response);
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
