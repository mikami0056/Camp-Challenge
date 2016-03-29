<%-- 
    Document   : task4.jsp
    Created on : 2016/03/28, 14:25:55
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for2</title>
    </head>
    <body>
        <%
            final String c = "A";
            String v = "A";
            out.println("A<br>");

            for (int i = 1; i < 30; i++){
            v = v + c;
            out.println(v + "<br>");
            }
        %>
    </body>
</html>
