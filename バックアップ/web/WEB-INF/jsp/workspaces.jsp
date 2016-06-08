<%-- 
    Document   : workspaces
    Created on : 2016/05/28, 16:17:45
    Author     : gest
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.PictureDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    String jumper = "/WorkSpacesProto/PictureDetail?ID=";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpace</title>
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/searchandcategories.css">
        <link rel="stylesheet" href="common/css/ranking.css">
        <!--<link rel="stylesheet" href="common/css/style.css">-->
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
        <h1 id="siteTitel">WorkSpaces</h1>
        <nav class="global">
            <ul>
            <li class="current"><a href="/WorkSpacesProto/WorkSpaces">ホーム</a></li>
            <li><a href="/WorkSpacesProto/WorkSpaces?option=MyPage">マイページ</a></li>
            <li><a href="/WorkSpacesProto/WorkSpaces?option=Logout">ログアウト</a></li>
            <li><a href="/WorkSpacesProto/WorkSpaces?option=Contact">お問い合わせ</a></li>
            </ul>
        </nav>
        </header>
        <div id="pageBodySub">
            <section class="search">
            <p><input type="text" name="search" placeholder="キーワードを入力"></p>
            <input type="submit" value="検索">
            </section>
            <section class="category">
            <p class="categorytitle">カテゴリー</p>
            <ul>
                <li><a href="/WorkSpaces/Search">自宅</a></li>
                <li><a href="/WorkSpaces/Search">会社</a></li>
                <li><a href="/WorkSpaces/Search">いろいろ</a></li>
            </ul>
            </section>
        </div>
        <section class="ranking">
        <h1 class="title">ランキング</h1>
        <%
            if((String)hs.getAttribute("Rank") == null){
            Map<Integer, PictureDataBeans> picturesByRank = (HashMap<Integer, PictureDataBeans>)hs.getAttribute("picturesByRank");
            int i = 1;
            for(Integer pictureID : picturesByRank.keySet()){ 
            PictureDataBeans picture = picturesByRank.get(pictureID);
        %>
            <p class="rank">総合<%=i%>位</p>
            <p class="img"><a href=<%=jumper +  picture.getPictureID() + "&option=Rank"%>><span class="img" style="background-image: url('<%=picture.getPath()%>')"></span></a></p>
            <p class="subject">題名:<a href=<%=jumper +  picture.getPictureID() + "&option=Rank"%>><%=picture.getName()%></a></p>
            <p class="sum">総評価獲得数：<%=picture.getSum()%></p>
            <% i++;}%>
            <%}else{%>
            <p>まだ誰も評価していません...</p>
            <p class="link"><a href="/WorkSpacesProto/Upload">写真を投稿する</a></p>
            <%}%>
        </section>
        <section class="newpicture">
        <p><h1 class="title">新着写真</h1><p>
        <%
            if((String)hs.getAttribute("Date") == null){
            Map<Integer, PictureDataBeans> picturesByTime = (HashMap<Integer, PictureDataBeans>)hs.getAttribute("picturesByDate");
            int i = 1;
            for(Integer pictureID : picturesByTime.keySet()){ 
            PictureDataBeans picture = picturesByTime.get(pictureID);
        %>
        <p class="rank">総合<%=i%>位</p>
        <p class="img"><a href=<%=jumper +  picture.getPictureID() + "&option=Date"%>><span class="img" style="background-image: url('<%=picture.getPath()%>')"></span></a></p>
        <p class="subject"><a href=<%=jumper +  picture.getPictureID() + "&option=Date"%>>題名：<%=picture.getName()%></a></p>
        <p class="date">投稿日：<%=picture.getDateTime()%></p>
        <% i++;}%>
        <%}else{%>
        <p>まだ誰も投稿していません...</p>
        <p class="link"><a href="/WorkSpacesProto/Upload">写真を投稿する</a></p>
        <%}%>    
        </section>
        <section class="newcomment">
        <p><h1 class="title">新着コメント</h1></p>
        <%
            if((String)hs.getAttribute("Comment") == null){
            Map<Integer, PictureDataBeans> picturesByComment = (HashMap<Integer, PictureDataBeans>)hs.getAttribute("picturesByComment");
            int i = 1;
            for(Integer pictureID : picturesByComment.keySet()){ 
            PictureDataBeans picture = picturesByComment.get(pictureID);
        %>
        <p>総合<%=i%>位</p>
        <p><a href=<%=jumper +  picture.getPictureID() + "&option=Comment"%>><span class="img" style="background-image: url('<%=picture.getPath()%>')"></span></a></p>
        <p><a href=<%=jumper +  picture.getPictureID() + "&option=Comment"%>>題名：<%=picture.getName()%></a></p>
        <p>投稿者コメント：<%=picture.getComment()%></p>
        <% i++;}%>
        <%}else{%>
        <p>まだ誰もコメントしていません...</p>
        <p class="link"><a href="/WorkSpacesProto/Upload">写真を投稿する</a></p>
        <%}%>    
        </section>
        </div>
    </body>
</html>
