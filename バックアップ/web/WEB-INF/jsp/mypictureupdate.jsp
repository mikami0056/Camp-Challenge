<%-- 
    Document   : mypictureupdate
    Created on : 2016/06/01, 14:24:30
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
    </head>
    <body>
        <h1>写真情報更新</h1>
        <img src="${picture4Update.path}">
        <form action="Manage" method="POST">
        <p>題名：<input type="text" name="name" value="${picture4Update.name}"></p>
        <p>投稿者コメント：<input type="text" name="comment" value="${picture4Update.comment}"></p>
        <p><%for(int i = 1; i < 6; i++){%>
            <label id="<%=i%>">カテゴリ<%=i%>：<input type="radio" name="category" value="<%=i%>" for="<%=i%>"></label>
        <%}%></p>
        <input type="hidden" name="option" value="Update">
        <input type="submit" value="更新">
        </form>
    </body>
</html>
