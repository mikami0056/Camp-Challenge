<%-- 
    Document   : index
    Created on : 2016/05/28, 10:21:14
    Author     : gest
--%>
<jsp:include page="/WEB-INF/includedpages/recaptcha.jsp"/>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
        <!--<link rel="stylesheet" href="common/css/style.css">-->
        <link rel="stylesheet" href="common/css/pageHeader.css">
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/login.css">
        <script src="https://www.google.com/recaptcha/api.js?hl=ja"></script>
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
        <h1>WorkSpaces</h1>
        <hr>
        </header>
        <div id="login">
            <section class="title">
            <p>ログイン</p>
            </section>
            <form action="/WorkSpacesProto/Login" method="POST">
            <p class="username">ユーザー名<br>
            <input type="text" name="username"></p>
            <p class="password">パスワード<br>
            <input type="password" name="password"></p>
            <% if("error".equals(request.getParameter("flag"))){out.print("ログインに失敗しました");} %>
            <section id="g">
            <div class="g-recaptcha" data-sitekey="6Ldh7yATAAAAAFXQSTDIvh6WOkkP0TXRcB12KZR9">
            </div>
            </section>
            <div class="buttom" >
            <input type="submit" value="ログイン">
            </div>
            </form>
            <p class="regist">新規登録される方は<a href="Registration">こちら</a></p>
        </div>
        </div>
    </body>
</html>
    