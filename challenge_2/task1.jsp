<%--
    Document   : task1.jsp
    Created on : 2016/03/28, 12:27:33
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
           int v = (int)(Math.random()*3) + 1;      //1〜3までの乱数を作成
           out.print("値 = " + v + "<br>");
            switch (v){
                case 1:
                    out.println("ONE");
                break;

                case 2:
                   out.println("TWO");
                break;

                default:
                    out.println("想定外やで");
                }
        %>
    </body>
</html>
