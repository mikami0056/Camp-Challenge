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
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    StringBuffer url = (StringBuffer)hs.getAttribute("URL");
    String login = (String)request.getAttribute("done");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%if(url != null && login == null){out.print("<meta http-equiv=\"refresh\" content=\"3;URL=" + url + "\">");}%>
        <title>かごゆめ</title>
    </head>
    <body>
        <%if(login != null){%>
            <p>ログインしています</p>
        <%} else {%>
        <p>ログインが成功しました</p>
        <%if(url != null){out.println("3秒後に元のページへジャンプします<br>");}%>
        <%}%>
        <p>こんにちは, <%= loginAccount.getName()%>さん</p>
        <form action="/EC/RegisterUser" method="GET">
            ユーザー新規登録の方はこちら
            <input type="submit" name="register" value="新規登録"><br>
        </form>
        <form action="/EC/Login" method="POST">
            <input type="submit" name="logout" value="ログアウト">
            <input type="hidden" name="logout" value="logout">
        </form>
    </body>
    <%= mh.indexJumper()%>
</html>
