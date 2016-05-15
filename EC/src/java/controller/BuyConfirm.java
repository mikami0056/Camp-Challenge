/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import model.ItemDetails;
import model.UserDataBeans;
import model.UserDataDAO;
import model.UserDataDTO;

/**
 *
 * @author SHO
 */
public class BuyConfirm extends HttpServlet {

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
        System.out.println("[Notice]BuyConfirm.java start");
        //セッションスコープを取得
        HttpSession session = request.getSession();
        
        //ログイン状態を確認
        //ログイン確認用変数
        boolean loginStatus = false;
        UserDataBeans loginAccount = null;
        if(session.getAttribute("loginAccount") != null){
            loginAccount = (UserDataBeans)session.getAttribute("loginAccount");
            loginStatus = true;
        } else {
            System.out.println("未ログインのため, フォワード");
            response.sendRedirect("/EC/Login");
            return;
        }
        System.out.println("login is done");
        //商品カートを取得
        //Map<String, List> CartWithUserID = (LinkedHashMap<String, List>)session.getAttribute("Cart");
        Map<String, Set> Cart = (LinkedHashMap<String, Set>)session.getAttribute("Cart");
        //商品カート内の商品リストを取得
        //List<ItemDetails> itemsInCart = null;
        Set<ItemDetails> items = items = Cart.get(loginAccount.getName());
        /*
        if(loginStatus){
            //itemsInCart = CartWithUserID.get(loginAccount.getName());
            items = Cart.get(loginAccount.getName());
        }else{
            //itemsInCart = CartWithUserID.get("defaultID");
            items = Cart.get("defaultID");
        }
        */
        
        //購入物を追加するための購入物リスト
        //List<ItemDetails> itemsBoughtByUser = (ArrayList<ItemDetails>)session.getAttribute("itemsBoughtByUser");
        Set<ItemDetails> itemsBoughtByUser = (LinkedHashSet<ItemDetails>)session.getAttribute("itemsBoughtByUser");
        
        //存在しなければ購入物リストを生成
        if(itemsBoughtByUser == null){
            itemsBoughtByUser = new LinkedHashSet<>();
        }
        
        request.setCharacterEncoding("UTF-8");
        //セッションスコープから商品IDと紐付いている商品インスタンスを取得
        String productID = request.getParameter("productID");
        //商品リストから購入する商品を取り出し, 購入物リストに追加
        for(ItemDetails item : items){
            if(item.getProductID().equals(productID)){
                itemsBoughtByUser.add(item);
                loginAccount.setSum(item.getNumber() * item.getPrice());
                items.remove(item);
                break;
            }
        }
        
        UserDataDTO dto = new UserDataDTO();
        loginAccount.UDB2DTOMapping(dto);
        try {
            UserDataDAO.getInstance().updateTotalMoney2User(dto);
            UserDataDAO.getInstance().insertTotalMoneyByParchase(dto);
        } catch (SQLException ex) {
            Logger.getLogger(BuyConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //購入物リストをセッションに保存
        session.setAttribute("itemsBoughtByUser", itemsBoughtByUser);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buyconfirm.jsp");
        dispatcher.forward(request, response);
        
        //商品カートIDリストを取得
        //List<String> productIDList = (ArrayList<String>)session.getAttribute("productIDList");
        //cart.jspより購入する商品IDを取得
        //String productID = request.getParameter("ItemProductID");     
        
        //Map<String, ItemDetails> itemsBoughtByUser = new LinkedHashMap<>();
        
        /*
        //カート内から
        for(String codeID : itemsInCart.keySet()){
            if(codeID.equals(productID)){
                itemsBoughtByUser.add(itemsInCart.get(codeID));
                //購入した商品をカートから削除
                itemsInCart.remove(codeID);
                break;
            }
        }
        
        for(String codeID : productIDList){
            if(codeID.equals(productID)){
                session.removeAttribute(codeID);
                productIDList.remove(codeID);
                break; //エラー回避用, 削除すべきIDを削除し終わったらループを終了させる
            }
        }
        */
        
        
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
