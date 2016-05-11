<%-- 
    Document   : cart
    Created on : 2016/05/11, 17:04:26
    Author     : SHO
--%>

<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="model.ItemDetails"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
        <% for(String productID : itemsInCart.keySet()){%>
         商品名:<%= itemsInCart.get(productID).getName()%><br>
         個数:<%= itemsInCart.get(productID).getNumber()%><br><br>
         <form action="/EC/Buy" method="POST">
             <input type="submit" name="buy" value="購入">
         </form>
         <form action="/EC/Cart" method="POST">
             <input type="submit" name="delete" value="削除">
             <input type="hidden" name="ItemProductID" value="<%=itemsInCart.get(productID).getProductID()%>">
         </form>
        <%}%>
    </body>
</html>
