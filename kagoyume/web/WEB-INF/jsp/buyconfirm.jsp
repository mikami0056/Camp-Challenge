<%-- 
    Document   : buyconfirm
    Created on : 2016/05/16, 11:31:57
    Author     : SHO
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.List"%>
<%@page import="model.ItemDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/jsphelper.jsp" %><%-- セッションの取得や, ModelHelperの取得を行う --%>
<jsp:include page="/WEB-INF/jsp/logwriter.jsp?where=buyconfirm"/><%-- ログ出力用 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>購入確認</h1>
        <jsp:include page="/WEB-INF/jsp/loginheader.jsp"/>
        <h2>以下の商品を購入します</h2>
        <p>名前：<c:out value="${requestScope.buyItem.name}"/></p>
        <p>個数：<c:out value="${requestScope.buyItem.number}"/></p>
        <p>価格：<c:out value="${requestScope.buyItem.price}"/></p>
        <p>合計：<c:out value="${requestScope.buyItem.number * requestScope.buyItem.price}"/></p>
        <form action="/kagoyume/Buy" method="POST">
            <label for="1">
            <input type="radio" name="type" value="1" id="1" checked>通常発送
            </label>
            <label for="2">
            <input type="radio" name="type" value="2" id="2">お急ぎ発送
            </label>
            <label for="3">
            <input type="radio" name="type" value="3" id="3">特急発送
            </label>
            <input type="submit" value="購入">
            <input type="hidden" name="productID" value="<c:out value="${requestScope.buyItem.productID}"/>">
        </form>
    </body>
    <%= mh.indexJumper()%>
</html>
