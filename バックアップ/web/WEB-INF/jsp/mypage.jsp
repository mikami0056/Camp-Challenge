 <%-- 
    Document   : mypage
    Created on : 2016/05/30, 10:27:45
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/mypage.css">
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
            <p class="title">ユーザー情報</p>
            <section class="userInfo">
                <ul>
                    <li><p>ユーザー名：<c:out value="${loginAccount.userName}"/></p></li>
                    <li><p>メールアドレス：<c:out value="${loginAccount.mail}"/></p></li>
                    <li><p>投稿写真総計：<c:out value="${loginAcoount.pictureSum}"/></p></li>
                </ul>
            </section>
            <section class="buttoms">
                <ul>
                    <li><a class="buttom" href="/WorkSpacesProto/MyPage?option=Upload">写真を投稿</a></li>
                    <li><a class="buttom" href="/WorkSpacesProto/MyPage?option=Manage">写真を管理</a></li>
                    <li><a class="buttom" href="/WorkSpacesProto/MyPage?option=MyDataUpdate">ユーザー情報を変更</a></li>
                    <li><a class="buttom" href="/WorkSpacesProto/MyPage?option=MyDataDelete">ユーザー情報を削除</a></li>
                </ul>
                <!--
                <form action="/WorkSpacesProto/MyPage" method="POST">    
                    <input type="submit" value="写真を投稿" >
                    <input type="hidden" name="option" value="Upload">
                </form>
                <form action="/WorkSpacesProto/MyPage" method="POST">
                    <input type="submit" value="写真を管理">
                    <input type="hidden" name="option" value="Manage">
                </form>
                <form action="/WorkSpacesProto/MyPage" method="POST">
                    <input type="submit" value="ユーザー情報を変更">
                    <input type="hidden" name="option" value="MyDataUpdate">
                </form>
                <form action="/WorkSpacesProto/MyPage" method="POST">
                    <input type="submit" value="ユーザー情報を削除">
                    <input type="hidden" name="option" value="MyDataDelete">
                </form>
                -->
            </section>
        </section>
        </div>
    </body>
</html>
