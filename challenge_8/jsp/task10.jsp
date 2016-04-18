<%-- 
    Document   : task10
    Created on : 2016/04/16, 17:35:00
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task10</title>
    </head>
    <body>
        <h1>削除フォーム</h1>
        <hr>
        <div>
            <form action="./task10" method="post">
            <font face = "sans-serif"><b>削除対象ID:</b></font>
            <input type="text" name="ID" size="15"maxlength="15"/>
        </div>
        <input type="submit" value="削除">
    </body>
</html>
