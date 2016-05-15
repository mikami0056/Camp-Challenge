<%-- 
    Document   : registerresult
    Created on : 2016/05/08, 14:07:18
    Author     : SHO
--%>
<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    System.out.println("テスト1");
    boolean exist = mh.existAccount(loginAccount);
    System.out.println("テスト2");
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ新規ユーザ登録完了</title>
    </head>
    <body>
        <h1>以下の情報でユーザ登録が完了しました</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        名前:<%= udb.getName()%>
        <p>パスワード:<%for(int i = 0; i < udb.getPassWord().length(); i++){
            out.print("●");
        }%></p>
        <p>メール:<%= udb.getMail()%></p>
        <p>住所:<%= udb.getAddress()%></p>
    </body>
    <%= mh.indexJumper()%>
</html>
