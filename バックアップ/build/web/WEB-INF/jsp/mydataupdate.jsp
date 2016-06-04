<%-- 
    Document   : mydataupdate
    Created on : 2016/06/02, 14:49:49
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
    </head>
    <body>
        <h1>ユーザー情報更新</h1>
        <h2>ユーザー情報を更新します</h2>
        <form action="MyDataUpdate" method="POST">
        <p>ユーザー名<br>
        <input type="text" name="userName" value="${loginAccount.userName}"></p>
        <p>パスワード<br>
        <input type="password" name="passWord" value="${loginAccount.passWord}"></p>
        <p>パスワード再入力<br>
        <input type="password" name="RePassWord" placeholder="パスワードを再入力"></p>
        <p>メールアドレス<br>
        <input type="text" name="mail" value="${loginAccount.mail}"></p>
        <input type="hidden" name="flag" value="ON">
        <input type="submit" value="ユーザー情報を更新">
        </form>
    </body>
</html>
