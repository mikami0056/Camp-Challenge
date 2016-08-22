<%-- 
    Document   : login
    Created on : 2016/08/20, 0:49:35
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン機能</title>
    </head>
    <body>
        <h1>ログイン画面</h1>
        <form action="LoginController" method="post">
            <input type="date" name="date">
            <input type="time" name="time">
        <input type="text" name="username" placeholder="ユーザー名">
        <input type="password" name="password" placeholder="パスワード">
        <input type="submit" value="ログイン">
        </form>
    </body>
</html>
