<%-- 
    Document   : registerresult
    Created on : 2016/05/08, 14:07:18
    Author     : SHO
--%>
<%@page import="model.UserDataBeans"%>
<%
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
        名前:<%= udb.getName()%>
        <p>パスワード:<%for(int i = 0; i < udb.getPassWord().length(); i++){
            out.print("●");
        }%></p>
        <p>メール:<%= udb.getMail()%></p>
        <p>住所:<%= udb.getAddress()%></p>
    </body>
</html>
