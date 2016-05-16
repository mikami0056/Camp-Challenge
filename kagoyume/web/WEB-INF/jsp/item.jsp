<%-- 
    Document   : item
    Created on : 2016/05/16, 10:43:41
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.ItemDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    //商品IDをItem.javaから取得
    String productID = (String)request.getAttribute("productID");
    ItemDataBeans item = (ItemDataBeans)hs.getAttribute(productID);
    String stockStatus = mh.stockStatus(item.getStock());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>商品詳細</h1>
        <jsp:include page="/WEB-INF/jsp/loginheader.jsp"/>
        <img src="<%= item.getImgUrl()%>"><br>
        名前:<%= item.getName()%><br>
        値段:<%= item.getPrice()%><br>
        在庫:<%= stockStatus%><br>
        <form action="/kagoyume/Add" method="POST">
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
