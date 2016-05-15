<%-- 
    Document   : mydata
    Created on : 2016/05/14, 19:05:12
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>ユーザー情報</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        %></p>
        <p>ユーザーID:<%= loginAccount.getUserID()%></p>
        <p>名前:<%= loginAccount.getName()%></p>
        <p>住所:<%= loginAccount.getAddress()%></p>
        <p>メールアドレス:<%= loginAccount.getMail()%></p>
        <p>購入金額合計:<%= loginAccount.getSum()%></p>
        <form action="/EC/MyData" method="GET">
            <input type="submit" name="update" value="登録情報更新">
            <input type="hidden" name="operation" value="update">
        
            <input type="submit" name="delete" value="登録情報削除">
            <input type="hidden" name="operation" value="delete">
        </form>
    </body>
    <%= mh.indexJumper()%>
</html>
