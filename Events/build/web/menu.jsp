<%-- 
    Document   : menu
    Created on : 2016/08/20, 0:49:13
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メニュー画面</title>
    </head>
    <body>
        <h1>メニュー画面</h1>
        <button id="in_time">出勤</button>
        <button id="out_time">退勤</button>
        <form action="MenuController" method="post">
            <input type="submit" value="イベント">
            <input type="hidden" name="controller" value="events">
            <input type="hidden" name="option"     value="list"> 
        </form>
    </body>
</html>
