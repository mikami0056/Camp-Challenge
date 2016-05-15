<%-- 
    Document   : search
    Created on : 2016/05/02, 12:52:04
    Author     : SHO
--%>

<%@page import="model.UserDataBeans"%>
<%@page import="model.ModelHelper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URL"%>
<%@page import="model.ItemSearch"%>
<%@page import="model.ItemDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
    Map<String, ItemDetails> itemDetailsList = (LinkedHashMap<String, ItemDetails>)hs.getAttribute("itemSearchList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <hr>
        検索条件<br>
        キーワード：<b><%= request.getAttribute("query")%></b>・分類：<b><%= request.getAttribute("sort")%></b>・並び順：<b><%= request.getAttribute("category")%></b>
        での検索結果を表示しています        
        <hr>
        <%for(String index : itemDetailsList.keySet()){%>
        <div>
        <%out.print(index + ":<br>");%>
        <a href="Item?index=<%= index%>"><img src="<%= itemDetailsList.get(index).getImgUrl()%>"></a><br>
        <a href="Item?index=<%= index%>"><%= itemDetailsList.get(index).getName()%></a><br>
        <%= itemDetailsList.get(index).getPrice() + "円<br>"%>
        <hr>
        </div>
        <%}%>
    </body>
</html>
