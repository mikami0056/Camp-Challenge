<%-- 
    Document   : task3.jsp
    Created on : 2016/03/28, 11:32:37
    Author     : SHO
--%>
<%
    final int c = 10;   //定数cを設定
    out.print("割られる数 (定数) = " + c + "<br>");

    long v = Math.round(Math.random()*4);   //乱数で1〜5までの変数vを生成
    v++;
    out.print("割る数 (変数1〜5) = " + v + "<br>");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>四則演算</title>
    </head>
    <body>
        <%
            out.print("足し算の結果は, " + c + " + " + v + " = " + (c + v) + " です。<br>");
            out.print("引き算の結果は, " + c + " - " + v + " = " + (c - v) + " です。<br>");
            out.print("掛け算の結果は, " + c + " * " + v + " = " + (c * v) + " です。<br>");
            out.print("割り算の結果は, " + c + " / " + v + " = " + (c / v) + " で, 余りは" + (c % v) + " です。<br>");
        %>
    </body>
</html>
