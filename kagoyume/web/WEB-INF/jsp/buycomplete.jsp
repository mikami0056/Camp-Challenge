<%-- 
    Document   : buycomplete
    Created on : 2016/05/16, 12:06:52
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
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    Map<String, Set> Cart = (LinkedHashMap<String, Set>)hs.getAttribute("Cart");    
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    //ログイン状態であればそのユーザーIDを, していなければdefaultIDを設定
    String userID = mh.getUserID(loginAccount);
    boolean exist = mh.existAccount(loginAccount);
    ItemDataBeans item = (ItemDataBeans)request.getAttribute("buyItem");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>購入完了</h1>
        <jsp:include page="/WEB-INF/jsp/loginheader.jsp"/>
        <p>購入が完了しました</p>
    </body>
    <%= mh.indexJumper()%>
</html>
