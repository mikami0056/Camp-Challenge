<%-- 
    Document   : task6
    Created on : 2016/03/28, 14:45:18
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>While</title>
    </head>
    <body>
        <%
        int v = 1000;
        final int c = 2;

        while (v > 100){
            out.print(v + "<br>");
            v = v / c;
        }
        
        out.print("処理終了");
        %>
    </body>
</html>
