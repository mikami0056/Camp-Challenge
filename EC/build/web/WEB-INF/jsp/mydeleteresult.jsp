<%-- 
    Document   : mydeleteresult
    Created on : 2016/05/14, 21:29:42
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ModelHelper mh = new ModelHelper();
    HttpSession hs = request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="3; URL=http://localhost:8084/kagoyume/index.jsp">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>ユーザー削除</h1>
        ユーザーを削除しました
    </body>
    <%= mh.indexJumper() + "<br>"%>
    <%= mh.loginJumper()%>
</html>
