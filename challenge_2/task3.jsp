<%-- 
    Document   : task3.jsp
    Created on : 2016/03/28, 12:54:22
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>switch1</title>
    </head>
    <body>
        <%
            long v = 1;              //変数の初期化
            final int c = 8;        //定数の宣言
            out.print("8を20回掛けます。" + "<br>");
                for(int i = 1; i <= 20; i++){
                   v = v * c;
                   out.print(i + "回目：" + v + "<br>");
                }
        %>
    </body>
</html>
