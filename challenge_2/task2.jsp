<%-- 
    Document   : task2.jsp
    Created on : 2016/03/28, 12:40:28
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>switch2</title>
    </head>
    <body>
        <%
            String[] score = {"A", "あ", ""};
            int i = (int)(Math.random()*3);
            
            switch (score[i]){
                case "A":
                    out.println("英語");
                break;

                case "あ":
                    out.println("日本語");
                break;
            }
        %>
    </body>
</html>
