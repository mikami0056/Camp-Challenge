<%-- 
    Document   : task6.jsp
    Created on : 2016/03/28, 12:22:28
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ランダム</title>
    </head>
    <body>
        <%
            long v = Math.round(Math.random()*2);    //1〜4の変数を生成
            v++;
            out.print("値 = " + v + "<br>");
                if (v == 1) {
                    out.print("値は" + v + "です!");
                }  else if ( v == 2){
                    out.print("プログラミングキャンプ!");
                } else {
                    out.print("その他です!");
                }
        %>
    </body>
</html>
