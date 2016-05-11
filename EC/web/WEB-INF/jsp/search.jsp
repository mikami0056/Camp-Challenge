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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean flag = false;
    if(loginAccount != null){
        flag = true;
    }
    ModelHelper mh = ModelHelper.getInstance();
    LinkedHashMap<String, HashMap<String, Element>> abc = (LinkedHashMap<String, HashMap<String, Element>>)hs.getAttribute("abc");
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
        <%if(flag){
            out.print(loginAccount.getName()+"さん, こんにちは<br>");
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        
        検索条件:<%= request.getAttribute("query")%><br>
        <% for(String index : abc.keySet()){
            out.print(index+ ":<br>");
            Element medium = (abc.get(index)).get("Medium");
            Element name = (abc.get(index)).get("Name");
            Element price = (abc.get(index)).get("Price");
        %>
        <img src="<%= medium.getTextContent()%>"><br>
        <a href="Item?index=<%= index%>"><%= name.getTextContent()%></a><br>
        <%= price.getTextContent() + "円<br>"%>
        <% } %>
    </body>
</html>
