<%-- 
    Document   : task2.jsp
    Created on : 2016/03/28, 11:26:31
    Author     : SHO
--%>

<%
String ms1 = "groove";
String ms2 = "-";
String ms3 = "gear";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GrooveGear</title>
    </head>
    <body>
        <%
            out.print(ms1 + ms2 + ms3 +"<br>");
            out.print("groove" + "-" + "gear");
        %>
    </body>
</html>
