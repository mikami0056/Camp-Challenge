<%-- 
    Document   : registrationform
    Created on : 2016/05/29, 0:12:14
    Author     : gest
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Work Spaces</title>
    </head>
    <body>
        <h1>新規登録</h1>
        <form action="/WorkSpacesProto/Registration" method="POST">
        <p><input type="text" name="username" placeholder="ユーザー名"></p>
        <p><input type="password" name="password" placeholder="パスワード"></p>
        <p><input type="password" name="password" placeholder="パスワード再入力"></p>
        <p><input type="mail" name="mail" placeholder="メールアドレス"></p>
        <select name="questionID">
            <option value="1">質問1</option>
            <option value="2">質問2</option>
            <option value="3">質問3</option>
            <option value="4">質問4</option>
            <option value="5">質問5</option>
        </select> 
        <p><input type="text" name="answer" placeholder="回答"></p>
        <p><input type="checkbox" name="confirm" id="confirm"><label for="confirm">上記の内容で問題なければチェックしてください</label></p>
        <p><input type="submit" value="登録"></p>
        <input type="hidden" name="operation" value="REGIST">
        </form>
    </body>
</html>
