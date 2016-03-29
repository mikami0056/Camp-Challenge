<%--
    Document   : task9
    Created on : 2016/03/28, 15:36:52
    Author     : SHO
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.*"%>
        <%
            HashMap<String, String> hMap = new HashMap<>();

            hMap.put("1", "AAA");
            hMap.put("hello", "world");
            hMap.put("soeda", "33");
            hMap.put("20", "20");

            for( Map.Entry <String,String> val : hMap.entrySet()){
                out.print(val.getKey() + " ");
                out.print("-> ");
                out.print(val.getValue() + " // ");
            }
        %>
    </body>
</html>
