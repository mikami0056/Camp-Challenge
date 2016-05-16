/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ItemDataBeans;

/**
 *
 * @author SHO
 */
public class Add extends HttpServlet {

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
        //item.jspからhiddenで送られた商品コードを取得
        String productID = request.getParameter("productID");
        System.out.println("プロダクトコードを取得:" + productID + "at Add.java");
        
        //商品コードを元にセッションスコープから商品を取得
        ItemDataBeans item = (ItemDataBeans)session.getAttribute(productID);
        System.out.println("プロダクトコードと紐付いている商品を取得 " + item.getName());
        
        //購入個数を商品情報に代入
        Integer number = Integer.parseInt(request.getParameter("buyNumber"));
        item.setNumber(number);
        //add.jsp表示用の一時的なインスタンス(購入数, 名前, 商品ID)
        request.setAttribute("buyNumber", number);
        request.setAttribute("name", item.getName());
        request.setAttribute("productID", item.getProductID());
        session.setAttribute(item.getProductID(), item);
                
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
        dispatcher.forward(request, response);
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
