<%-- 
    Document   : item
    Created on : 2016/05/04, 12:06:05
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.ItemDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    String productID = (String)request.getAttribute("productID");
    ItemDetails itemDetails = (ItemDetails)hs.getAttribute(productID);
    String stock="";
    switch(itemDetails.getStock()){
                case "instock":
                stock = "在庫あり";
                break;
                
                case "outofstock":
                stock = "在庫切れ";
                break;
    }
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean flag = false;
    if(loginAccount != null){
        flag = true;
    }
    ModelHelper mh = ModelHelper.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(flag){
            out.print(loginAccount.getName()+"さん, こんにちは<br>");
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <img src="<%= itemDetails.getImgUrl()%>"><br>
        名前:<%= itemDetails.getName()%><br>
        値段:<%= itemDetails.getPrice()%><br>
        在庫:<%= stock%><br>
        <form action="/EC/Add" method="POST">
            <select name="buyNumber">
            <%for(int i = 1; i < 30; i++){ %>
            <option value="<%= i%>"><%= i%></option>
            <%}%>
            </select>
            <input type="submit" name="add" value="カートに追加">
            <input type="hidden" name="productID" value="<%= productID%>">
        </form>
        <form action="/EC/Search" method="POST">
            <input type="submit" name="Search" value="一覧へ戻る">
            
        </form>
    </body>
</html>
