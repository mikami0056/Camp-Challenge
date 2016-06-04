<%-- 
    Document   : mydatadelete
    Created on : 2016/06/02, 14:50:12
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
        <h1>ユーザー情報削除</h1>
        <h2>このユーザーを削除します</h2>
        <form action="MyDataDelete" method="GET">
        <p>ユーザー名：${loginAccount.userName}</p>
        <p>メールアドレス：${loginAccount.mail}</p>
        <p>写真総数：${loginAccount.pictureSum}</p>
        <input type="submit" value="ユーザーを削除">
        
        </form>
    </body>
</html>
