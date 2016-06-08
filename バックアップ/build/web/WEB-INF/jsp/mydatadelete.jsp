<%-- 
    Document   : mydatadelete
    Created on : 2016/06/02, 14:50:12
    Author     : gest
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/mypage.css">
        <link rel="stylesheet" href="common/css/mydataupdate.css">
        <link rel="stylesheet" href="common/css/login.css">
        <title>WorkSpaces</title>
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
        <p class="title">ユーザー情報削除</p>
        <form action="MyDataDelete" method="POST">
        <section class="userInfo">
            <ul>
                <li><p>ユーザー名：<c:out value="${loginAccount.userName}"/></p></li>
                <li><p>メールアドレス：<c:out value="${loginAccount.mail}"/></p></li>
                <li><p>投稿写真総計：<c:out value="${loginAcoount.pictureSum}"/></p></li>
            </ul>
        </section>
        <div class="buttom" >
        <input type="submit" value="ユーザーを削除">
        </div>
        </form>
        </section>
        </div>
    </body>
</html>
