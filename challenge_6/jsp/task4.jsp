<%-- 
    Document   : task4
    Created on : 2016/04/11, 14:37:30
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" contentType="text/html"%>
<%@page import = "java.text.*" contentType="text/html"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task4</title>
    </head>
    <body>
       <%
           Date time = new Date();
           SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String t = f.format(time);
           
           HttpSession hs = request.getSession(true);
           hs.setAttribute("LastLogin", t);
           
           //HttpSession hs = request.getSession(true);
           out.print("最後のログインは、" + hs.getAttribute("LastLogin") + "です。");
       %>
    </body>
</html>
