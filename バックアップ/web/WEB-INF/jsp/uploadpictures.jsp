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
        <title>WorkSpaces</title>
        <script src="/commom/javascript/uploadpictures.js"></script>
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/mypage.css">
        <link rel="stylesheet" href="common/css/uploadpictures.css">
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
        <h1 id="siteTitel">WorkSpaces</h1>
        <nav class="global">
            <ul>
            <li><a href="/WorkSpacesProto/WorkSpaces">ホーム</a></li>
            <li class="current"><a href="/WorkSpacesProto/WorkSpaces?option=MyPage">マイページ</a></li>
            <li><a href="/WorkSpacesProto/WorkSpaces?option=Logout">ログアウト</a></li>
            <li><a href="/WorkSpacesProto/WorkSpaces?option=Contact">お問い合わせ</a></li>
            </ul>
        </nav>
        </header>
        <section id="pageBody">
        <p class="title">写真投稿</p>
        <form action="/WorkSpacesProto/Upload" enctype="multipart/form-data" method="POST">
            <p class="upload">投稿する写真ファイル<br>
            <input type="file" name="filename" size="30" id="file"></p>
            <p id="output" class="output"></p>
            <p id="error" class="error none"></p>
            <div id="output"></div>
            <div class="category" >
            <p class="category">カテゴリー</p>
            <select name="category">
                <%for(int i = 1; i < 6; i++){%>
                <option value="<%=i%>">カテゴリー<%=i%></option>
                <%}%>
            </select>
            </div>
            <p class="subject">題名を入力<br>
            <input type="text" name="pictureName" placeholder="写真名を入力してください"></p>
            <p class="comment">投稿者コメント<br>
            <textarea class="comment" name="comment" placeholder="こだわった部分を教えてください"></textarea></p>
            <p class="buttom"><input type="submit" value="投稿"></p>
        </form>
        </section>
        </div>
    </body>
</html>
