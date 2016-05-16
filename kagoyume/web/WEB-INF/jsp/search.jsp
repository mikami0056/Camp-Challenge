<%-- 
    Document   : search
    Created on : 2016/05/16, 10:33:27
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
<%@page import="model.SearchLogic"%>
<%@page import="model.ItemDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
    Map<String, ItemDataBeans> itemDetailsList = (LinkedHashMap<String, ItemDataBeans>)hs.getAttribute("itemSearchList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <jsp:include page="/WEB-INF/jsp/loginheader.jsp"/>
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
    <%= mh.indexJumper()%>
</html>
