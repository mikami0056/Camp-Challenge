<%-- 
    Document   : cart
    Created on : 2016/05/15, 23:45:40
    Author     : SHO
--%>
<%@page import="java.util.Set"%>
<%@page import="model.UserDataBeans"%>
<%@page import="java.util.Map"%>
<%@page import="model.ModelHelper"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="model.ItemDataBeans"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/jsphelper.jsp" %><%-- セッションの取得や, ModelHelperの取得を行う --%>
<%
    Map<String, Set> Cart = (LinkedHashMap<String, Set>)hs.getAttribute("Cart");    
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    //ログイン状態であればそのユーザーIDを, していなければdefaultIDを設定
    String userID = mh.getUserID(loginAccount);
    boolean exist = mh.existAccount(loginAccount);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート確認</title>
    </head>
    <body>
        <h1>カートの中身</h1>
        <jsp:include page="/WEB-INF/jsp/loginheader.jsp"/>
        <%-- CartWithUserIDが存在し, 商品が最低でも一つ入っている--%>
        <%if(Cart != null && Cart.get(userID).size() != 0){
            Integer sum = 0;
            Set<ItemDataBeans> items = Cart.get(userID);
            for(ItemDataBeans item : items){%>
            <img src="<%= item.getImgUrl()%>"><br>
            商品名:<%= item.getName()%><br>
            個数:<%= item.getNumber()%><br>
            値段:<%= item.getPrice()%><br>
            <form action="/kagoyume/Buy" method="POST">
                <input type="submit" name="buy" value="購入確認"><%if(!exist){out.println("未ログインのため, ログイン画面にジャンプします");}%>
                <input type="hidden" name="productID" value="<%= item.getProductID()%>">
                <input type="hidden" name="confirm" value="confirm">
            </form>
            <form action="/kagoyume/Delete" method="POST">
                <input type="submit" name="delete" value="削除">
                <input type="hidden" name="productID" value="<%= item.getProductID()%>">
            </form>
            <hr>
            <%}%>
            <%= mh.indexJumper()%>
        <%}else{%>
            カートは空です<br>
            <%= mh.indexJumper()%>
        <%}%>
    </body>
</html>
