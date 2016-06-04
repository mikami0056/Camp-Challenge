<%-- 
    Document   : uploadpictures
    Created on : 2016/05/29, 14:48:37
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Work Spaces</title>
        <script src="/commom/javascript/uploadpictures.js"></script>
    </head>
    <body>
        <h1>写真投稿</h1>
        <form action="/WorkSpacesProto/Upload" enctype="multipart/form-data" method="POST">
            <p>投稿する写真ファイル
            <input type="file" name="filename" size="30" id="file"></p>
            <p id="output" class="output"></p>
            <p id="error" class="error none"></p>
            <div id="output"></div>
            <p><input type="text" name="pictureName" placeholder="写真名を入力してください"></p>
            <p><%for(int i = 1; i < 6; i++){%>
                <label id="<%=i%>">カテゴリ<%=i%>：<input type="radio" name="category" value="<%=i%>" for="<%=i%>"></label>
            <%}%></p>
            <p></p>
            <p><textarea name="comment" cols="50" rows="5" placeholder="こだわった部分を教えてください"></textarea></p>
            <p><input type="submit" value="投稿"></p>
        </form>
    </body>
</html>
