<%-- 
    Document   : registrationform
    Created on : 2016/05/29, 0:12:14
    Author     : gest
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Work Spaces</title>
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/registrationform.css">
        <script src="/WorkSpacesProto/common/javascript/registrationform.js" charset="utf-8"></script>
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
        <h1>WorkSpaces</h1>
        <hr>
        </header>
        <div id="form">
        <section class="title">
        <p>新規登録</p>
        </section>
        <form action="/WorkSpacesProto/Registration" method="POST" name="regist" onSubmit="return check()">
        <p class="username">ユーザー名<br>
        <input type="text" name="username" placeholder="ユーザー名" size="20"></p>
        <p class="password">パスワード<br>
        <input type="password" name="password" placeholder="パスワード" size="20"></p>
        <p class="repassword">パスワード再入力<br>
        <input type="password" name="repassword" placeholder="パスワード再入力" size="20"></p>
        <p class="mail">メールアドレス<br>
        <input type="email" name="mail" placeholder="メールアドレス"></p>
        <p class="question">秘密の質問
        <select name="questionID">
            <option value="1">質問1</option>
            <option value="2">質問2</option>
            <option value="3">質問3</option>
            <option value="4">質問4</option>
            <option value="5">質問5</option>
        </select></p> 
        <p class="answer"><input type="text" name="answer" placeholder="回答"></p>
        <p class="check"><label for="confirm">上記の内容で問題なければチェックしてください</label>
        <input type="checkbox" name="confirm" id="confirm" onClick="submitcheck(this)"></p>
        <div class="buttom" >
        <input type="submit" disabled="false" value="登録" name="button">
        </div>
        <input type="hidden" name="operation" value="REGIST">
        </form>
        </div>
        </div>
    </body>
</html>
