<%-- 
    Document   : login
    Created on : 2016/05/07, 22:23:09
    Author     : SHO
--%>
<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%
    ModelHelper mh = ModelHelper.getInstance();
    HttpSession hs = request.getSession();
    boolean flag = false;
    if((String)request.getAttribute("logout") != null){
        flag = true;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめログイン画面</title>
    </head>
    <body>
        <%if(flag){%>
        <h2>ログアウト</h2>
        <p>ログアウトしました</p>
        <%= mh.loginJumper()%>
        <%} else {%>
        <h2>ログイン</h2>
        <form action="/EC/Login" method="POST">
            ユーザー名:<input type="text" name="userName" value=""><br>
            パスワード:<input type="password" name="passWord" value=""><br>
            <%
                if("notExist".equals(request.getParameter("flag"))){
                    out.print("ログインできません. ユーザー名又はパスワードを再入力してください.<br>");
                }
            %>
            <input type="submit" name="login" value="ログイン">
        </form>
        <form action="/EC/RegisterUser" method="GET">
            ユーザー新規登録の方はこちら
            <input type="submit" name="register" value="新規登録"><br>
        </form>
        <%}%>
        <%= mh.indexJumper()%>
    </body>
</html>
