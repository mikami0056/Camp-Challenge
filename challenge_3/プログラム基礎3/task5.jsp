<%-- 
    Document   : task5
    Created on : 2016/03/31, 13:36:49
    Author     : SHO
--%>

<%@ page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task5</title>
    </head>
    <body>
        <p>課題5</p>
        <p>戻り値としてある人物のid(数値),名前,生年月日、住所を返却するメソッドを作成<br>
           受け取った後はid以外の値を表示する</p>
        <%
            String[] Array = getArray();
            for (int i = 1; i < Array.length; i++){
                out.print(Array[i] + "<br>");
            }
            
        %>
        
        <%!
            String[] getArray(){
            String[] array = {"111", "山田", "1月1日", "北海道"};
            return array; 
        }
        %>
    </body>
</html>
