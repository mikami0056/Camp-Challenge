<%-- 
    Document   : cart
    Created on : 2016/05/11, 17:04:26
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="model.ItemDetails"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ModelHelper mh = new ModelHelper();
    HttpSession hs = request.getSession();
    LinkedHashMap<String, ItemDetails> itemsInCart = (LinkedHashMap<String, ItemDetails>)hs.getAttribute("itemsInCart");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート確認</title>
    </head>
    <body>
        <%-- itemsInCartが存在し, カートの中身が1つ以上ある場合 --%>
        <% if(itemsInCart != null && itemsInCart.size() != 0) {%>
        <% Integer sum = 0;%>
        <% for(String productID : itemsInCart.keySet()){%>
      
        <img src="<%= itemsInCart.get(productID).getImgUrl()%>"><br>
        商品名:<%= itemsInCart.get(productID).getName()%><br>
        個数:<%= itemsInCart.get(productID).getNumber()%><br>
        値段:<%= itemsInCart.get(productID).getPrice()%><br>
        <% sum += itemsInCart.get(productID).getNumber() * itemsInCart.get(productID).getPrice();%>
         <form action="/EC/Buy" method="POST">
             <input type="submit" name="buy" value="購入">
         </form>
         <form action="/EC/Delete" method="POST">
             <input type="submit" name="delete" value="削除">
             <input type="hidden" name="ItemProductID" value="<%=itemsInCart.get(productID).getProductID()%>">
         </form>
        <%}%>
        合計:<%=sum%>円
        <%= mh.indexJumper()%>
        <%} else {%>
        カートは空です
        <%= mh.indexJumper()%>
        <%}%>
    </body>
</html>
