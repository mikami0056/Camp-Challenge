<%-- 
    Document   : complete
    Created on : 2016/06/02, 15:41:23
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    String detail = (String)request.getAttribute("detail");
    int type = 0; String URL = "/WorkSpacesProto/MyPage?option=0"; String title = detail; String destination = "ホーム画面";
    if(detail.equals("ユーザー情報削除")){
        type = 1;
        URL = "/WorkSpacesProto/index.jsp";
        destination = "ログイン画面";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="3;URL=<%=URL%>">
        <title>WorkSpaces</title>
    </head>
    <body>
        <h1><%=title%>が完了しました</h1>
        <p>3秒後に<%=destination%>へ移動します</p>
        
    </body>
</html>
