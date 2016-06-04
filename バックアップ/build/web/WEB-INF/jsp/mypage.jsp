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
        <link rel="stylesheet" href="common/css/style.css">
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
            <h1 id="siteTitel">WorkSpaces</h1>
            <hr>
            <nav class="global">
                <ul>
                <li><a href="/WorkSpacesProto/WorkSpaces">ホーム</a></li>
                <li class="current"><a href="/WorkSpacesProto/WorkSpaces?option=Mypage">マイページ</a></li>
                <li><a href="/WorkSpacesProto/WorkSpaces?option=Logout">ログアウト</a></li>
                <li><a href="/WorkSpacesProto/WorkSpaces?option=Contact">お問い合わせ</a></li>
                </ul>
            </nav>
        </header>
        <section id="pageBody">
            <section class="userInfo">
                <p>ユーザー名：<c:out value="${loginAccount.userName}"/></p>
                <p>メールアドレス：<c:out value="${loginAccount.mail}"/></p>
                <p>投稿写真総計：<c:out value="${loginAcoount.pictureSum}"/></p>
            </section>
            <section class="buttom">
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
            </section>
        </section>
        </div>
    </body>
</html>
