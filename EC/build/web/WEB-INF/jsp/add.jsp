<%-- 
    Document   : add
    Created on : 2016/05/04, 16:58:56
    Author     : SHO
--%>

<%@page import="model.ModelHelper"%>
<%@page import="model.UserDataBeans"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="model.ItemDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession hs = request.getSession();
    ModelHelper mh = ModelHelper.getInstance();
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean flag = false;
    if(loginAccount != null){
        flag = true;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(flag){
            out.print(loginAccount.getName()+"さん, こんにちは<br>");
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <%= request.getAttribute("name")%>を<%= request.getAttribute("buyNumber")%>個カートに追加しました。<br>
        <form action="/EC/Cart" method="POST">
            <input type="submit" name="cart" value="カートを確認">
        </form>
    </body>
</html>
