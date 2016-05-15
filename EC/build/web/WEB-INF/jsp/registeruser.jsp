<%-- 
    Document   : registeruser
    Created on : 2016/05/07, 22:40:50
    Author     : SHO
--%>
<%@page import="model.UserDataBeans"%>
<%@page import="model.ModelHelper"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
    String caution = (String)hs.getAttribute("caution");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめユーザ新規登録画面</title>
    </head>
    <body>
        <form action="RegisterConfirm" method="POST">
        <h1>ユーザ新規登録</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <% if(caution != null){out.print(caution + "が入力されていません");}%>
        <p>ユーザー名:<input type="text" name="userName" value="<%if(udb != null){out.print(udb.getName());}%>" placeholder="姓">
        <p>パスワード:<input type="password" name="password" value="<%if(udb != null){out.print(udb.getPassWord());}%>"></p>
        <p>メールアドレス:<input type="text" name="mail" value="<%if(udb != null){out.print(udb.getMail());}%>"></p>
        <p>住所:<input type="text" name="address" value="<%if(udb != null){out.print(udb.getAddress());}%>" placeholder="住所"></p>
        <input type="submit" name="regist" value="確認画面へ">
        <input type="hidden" name="id" value="<%= hs.getAttribute("idForRegist")%>">
        <!--<input type="reset" name="reset" value="情報をクリア" >-->
        </form>
        <%= mh.indexJumper()%>
    </body>
</html>
