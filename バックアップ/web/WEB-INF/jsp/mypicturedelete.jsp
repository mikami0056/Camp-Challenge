<%-- 
    Document   : mypicturedelete
    Created on : 2016/06/02, 11:17:52
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
        <h1>写真情報削除</h1>
        <img src="${picture4Delete.path}">
        <p>題名：${picture4Delete.name}</p>
        <p>投稿者コメント：${picture4Delete.comment}</p>
        <p>カテゴリー：${picture4Delete.category}</p>
        <p>投稿日：${picture4Delete.dateTime}</p>
        <section>
            <p>評価<br>
            キレイ：${picture4Delete.beautiful} カッコイイ：${picture4Delete.cool} オシャレ：${picture4Delete.stylish}
            </p>
        </section>
        <form action="Manage" method="POST">
        <input type="hidden" name="option" value="Delete">
        <input type="submit" value="削除">
        </form>
    </body>
</html>
