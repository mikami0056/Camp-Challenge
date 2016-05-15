<%-- 
    Document   : myupdateresult
    Created on : 2016/05/14, 21:19:10
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
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
        以下の内容で情報を更新しました.
        <p align="right"><%= mh.loginJumper("")%>
        <%
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        %></p>
        <p>ユーザー名:<%= loginAccount.getName()%></p>
        <p>パスワード:<%for(int i = 0; i < loginAccount.getPassWord().length(); i++){
            out.print("●");
        }%></p>
        <p>メールアドレス:<%= loginAccount.getMail()%></p>
        <p>住所:<%= loginAccount.getAddress()%></p>
    </body>
    <%= mh.indexJumper() + "<br>"%>
    <%= mh.loginJumper()%>
</html>
