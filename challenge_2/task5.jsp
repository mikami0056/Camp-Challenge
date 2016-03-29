<%-- 
    Document   : task5.jsp
    Created on : 2016/03/28, 14:32:54
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for3Gauss</title>
    </head>
    <body>
        <%
            int sum = 0;
            
            for (int i = 1; i <= 100; i++){
                sum = sum + i;
                out.println(i + "：" + sum + "<br>");
            }
        %>
    </body>
</html>
