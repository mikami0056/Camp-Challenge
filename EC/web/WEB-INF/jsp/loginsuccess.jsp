<%-- 
    Document   : loginsuccess
    Created on : 2016/05/09, 11:51:05
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = ModelHelper.getInstance();
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    StringBuffer fromPlace = (StringBuffer)hs.getAttribute("fromPlace");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="3;URL=<%=fromPlace.toString()%>">
        <title>かごゆめ</title>
    </head>
    <body>
        <%if((String)request.getAttribute("done") != null){%>
            <p>ログインしています</p>
        <%} else {%>
        <p>ログインが成功しました</p>
        <%}%>
        <p>こんにちは, <%= loginAccount.getName()%>さん</p>
        <form action="/EC/Login" method="POST">
            <input type="submit" name="logout" value="ログアウト">
            <input type="hidden" name="logout" value="logout">
        </form>
    </body>
    <%= mh.indexJumper()%>
</html>
