<%-- 
    Document   : myupdate
    Created on : 2016/05/14, 20:21:51
    Author     : SHO
--%>

<%@page import="model.UserDataBeans"%>
<%@page import="model.ModelHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ModelHelper mh = new ModelHelper();
    HttpSession hs = request.getSession();
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>ユーザー情報更新</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        %></p>
        <form action="/EC/MyData" method="POST">
        <p>ユーザー名:<input type="text" name="userName" value="<%= loginAccount.getName()%>" placeholder="姓">
        <p>パスワード:<input type="password" name="password" value="<%= loginAccount.getPassWord()%>"></p>
        <p>メールアドレス:<input type="text" name="mail" value="<%= loginAccount.getMail()%>"></p>
        <p>住所:<input type="text" name="address" value="<%= loginAccount.getAddress()%>" placeholder="住所"></p>
        <input type="submit" name="update" value="確認画面へ">
        <input type="hidden" name="operation" value="update">
        <input type="reset" name="reset" value="情報をクリア" >
        </form>
    </body>
</html>
