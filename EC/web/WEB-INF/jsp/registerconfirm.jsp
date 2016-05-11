<%-- 
    Document   : registerconfirm
    Created on : 2016/05/08, 0:16:16
    Author     : SHO
--%>
<%@page import="model.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ新規登録確認</title>
    </head>
    <body>
        <p>名前:<%= udb.getName()%></p>
        <p>パスワード:<%for(int i = 0; i < udb.getPassWord().length(); i++){
            out.print("●");
        }%></p>
        <p>メール:<%= udb.getMail()%></p>
        <p>住所:<%= udb.getAddress()%></p>
        以上の内容で登録します。よろしいですか?<br>
        <form action="RegisterResult" method="POST">
            <input type="submit" name="submit" value="登録">
            <input type="hidden" name="id" value="<%= hs.getAttribute("idForRegist")%>">
        </form>
            <input type="submit" name="return" value="登録内容を変更">
            <input type="hidden" name="no" value="REINPUT">
        <form>
        </form>
    </body>
</html>
