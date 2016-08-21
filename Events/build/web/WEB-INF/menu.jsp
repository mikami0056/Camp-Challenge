<%-- 
    Document   : menu
    Created on : 2016/08/20, 0:49:13
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メニュー画面</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="scripts/WorkStatusScript.js"></script>
        <h1>メニュー画面</h1>
        <span id="userid"></span>
            <span id="date"></span>
            <section id="inout">
                <p><button id="in" onclick="workIn()">出勤</button><span id="work_in">${workStatus.work_in}</span></p>
                <p><button id="out" onclick="workOut()">退勤</button><span id="work_out">${workStatus.work_out}</span></p>
                <span id="date"></span>
            </section>
        <form action="MenuController" method="post">
            <input type="submit" value="イベント">
            <input type="hidden" name="controller" value="events">
            <input type="hidden" name="option"     value="list"> 
        </form>
        <form action="MenuController" method="post">
            <input type="submit" value="勤怠詳細">
            <input type="hidden" name="controller" value="workstatus">
            <input type="hidden" name="option"     value="list">
        </form>
    </body>
</html>
