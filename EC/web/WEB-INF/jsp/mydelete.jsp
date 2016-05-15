<%-- 
    Document   : mydelete
    Created on : 2016/05/14, 21:31:07
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
        <h1>ユーザー情報削除</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        %></p>
        <p>このユーザーをマジで削除しますか?</p>
        <form action="/EC/MyData" method="POST">
        <p>ユーザーID:<%= loginAccount.getUserID()%></p>
        <p>ユーザー名:<%= loginAccount.getName()%></p>
        <p>パスワード:<%for(int i = 0; i < loginAccount.getPassWord().length(); i++){
            out.print("●");
        }%></p>
        <p>メールアドレス:<%= loginAccount.getMail()%></p>
        <p>住所:<%= loginAccount.getAddress()%>"</p>
        <p>総購入金額:<%= loginAccount.getSum()%></p>
        <input type="submit" name="delete" value="確認画面へ">
        <input type="hidden" name="operation" value="delete">
        <input type="reset" name="reset" value="情報をクリア" >
        </form>
    </body>
    
</html>
