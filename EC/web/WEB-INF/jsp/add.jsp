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
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
    </head>
    <body>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <%= request.getAttribute("name")%>を<%= request.getAttribute("buyNumber")%>個カートに追加しました。<br>
        <form action="/EC/Cart" method="POST">
            <input type="submit" name="cart" value="カートを確認">
            <input type="hidden" name="productID" value="<%= request.getAttribute("productID")%>">
        </form>
        <%= mh.indexJumper()%>
    </body>
</html>
