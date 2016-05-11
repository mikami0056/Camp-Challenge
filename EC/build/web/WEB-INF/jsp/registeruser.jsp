<%-- 
    Document   : registeruser
    Created on : 2016/05/07, 22:40:50
    Author     : SHO
--%>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめユーザ新規登録画面</title>
    </head>
    <body>
        <form action="RegisterConfirm" method="POST">
        <h1>ユーザ新規登録</h1>
        <p>ユーザー名:<input type="text" name="userName" value="" placeholder="姓">
        <p>パスワード:<input type="password" name="password" value=""></p>
        <p>メールアドレス:<input type="text" name="mail" value=""></p>
        <p>住所:<input type="text" name="address" value="" placeholder="住所"></p>
        <input type="submit" name="regist" value="確認画面へ">
        <input type="hidden" name="id" value="<%= hs.getAttribute("idForRegist")%>">
        <input type="reset" name="reset" value="情報をクリア" >
        </form>
    </body>
</html>
