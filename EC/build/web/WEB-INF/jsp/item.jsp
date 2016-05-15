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
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    //商品IDをItem.javaから取得
    String productID = (String)request.getAttribute("productID");
    ItemDetails item = (ItemDetails)hs.getAttribute(productID);
    String stockStatus = mh.stockStatus(item.getStock());
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName())+"さん, こんにちは<br>");
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <img src="<%= item.getImgUrl()%>"><br>
        名前:<%= item.getName()%><br>
        値段:<%= item.getPrice()%><br>
        在庫:<%= stockStatus%><br>
        <form action="/EC/Add" method="POST">
            <select name="buyNumber">
            <%for(int i = 1; i < 30; i++){ %>
            <option value="<%= i%>"><%= i%></option>
            <%}%>
            </select>
            <input type="submit" name="add" value="カートに追加">
            <input type="hidden" name="productID" value="<%= productID%>">
        </form>
            <input type="submit" onClick='history.back();' value="一覧へ戻る">
    </body>
</html>
