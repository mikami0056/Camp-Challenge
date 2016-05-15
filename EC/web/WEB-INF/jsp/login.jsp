<%-- 
    Document   : login
    Created on : 2016/05/07, 22:23:09
    Author     : SHO
--%>
<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    if(mh == null){
        mh = new ModelHelper();
    }
    boolean logout = false;
    if((String)request.getAttribute("logout") != null){
        logout = true;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%if(logout){out.print("<meta http-equiv=\"refresh\" content=\"3;URL=http://localhost:8084/EC/index.jsp\">");}%>
        <title>かごゆめログイン画面</title>
    </head>
    <body>
        <%if(logout){%>
        <h2>ログアウト</h2>
        <p>ログアウトしました</p>
        3秒後にトップページへジャンプします
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
