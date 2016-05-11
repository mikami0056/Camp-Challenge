/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import model.Common;
import model.ItemDetails;
import model.ItemSearch;
import model.ItemSearchList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author SHO
 */
public class Search extends HttpServlet {

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
        //doGet, doPostメソッドにそれぞれ記述しています
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
            throws ServletException, IOException, MalformedURLException {
        
        //基本事項
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        String query = request.getParameter("query");
        String sort = request.getParameter("sort");
        String categoryID = request.getParameter("category");
        
        request.setAttribute("query", query);
        request.setAttribute("sort", sort);
        request.setAttribute("category", categoryID);
               
        //入力チェック
        if("".equals(query.trim())){
            System.out.println("キーワードが未入力でした");
            response.sendRedirect("/EC/index.jsp?flag=error");
            
        } else { 
            //商品が格納されたMapを取得
            Map<String, ItemDetails> itemSearchList = ItemSearch.getInstance().execute(query, sort, categoryID);
            session.setAttribute("itemSearchList", itemSearchList);
            
            if((Set<String>)session.getAttribute("productIDList") == null){
                Set<String> productIDList = new LinkedHashSet<>();
                session.setAttribute("productIDList", productIDList);
                System.out.println("商品コード保存用インスタンスを生成しました");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
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
