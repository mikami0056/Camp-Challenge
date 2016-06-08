<%-- 
    Document   : mydataupdate
    Created on : 2016/06/02, 14:49:49
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/mypage.css">
        <link rel="stylesheet" href="common/css/mydataupdate.css">
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
            <p class="title">ユーザー情報更新</p>
            <form action="MyDataUpdate" method="POST">
            <p class="username">ユーザー名<br>
            <input type="text" name="userName" value="${loginAccount.userName}" placeholder="半角英数字を入力"></p>
            <p class="password">パスワード<br>
            <input type="password" name="passWord" value="${loginAccount.passWord}" placeholder="半角英数字を入力"></p>
            <p class="repassword">パスワード再入力<br>
            <input type="password" name="RePassWord" placeholder="パスワードを再入力"></p>
            <p class="mail">メールアドレス<br>
            <input type="text" name="mail" value="${loginAccount.mail}" placeholder="半角英数字を入力"></p>
            <input type="hidden" name="flag" value="ON">
            <div class="buttom" >
            <input type="submit" value="更新">
            </div>
            </form>
        </section>
        </div>
    </body>
</html>
