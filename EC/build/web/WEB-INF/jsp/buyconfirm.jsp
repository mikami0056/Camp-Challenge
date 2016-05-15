<%-- 
    Document   : buyconfirm
    Created on : 2016/05/12, 16:56:00
    Author     : SHO
--%>

<%@page import="model.UserDataBeans"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="model.ModelHelper"%>
<%@page import="model.ItemDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    Set<ItemDetails> itemsBoughtByUser = (LinkedHashSet<ItemDetails>)hs.getAttribute("itemsBoughtByUser");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    int sum = 0;
    boolean exist = mh.existAccount(loginAccount);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>買い物かご</title>
    </head>
    <body>
        <h1>購入履歴</h1>
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <%for(ItemDetails item : itemsBoughtByUser){%>
        <img src="<%= item.getImgUrl()%>"><br>
        名前:<%= item.getName()%><br>
        個数:<%= item.getNumber()%>個<br>
        値段:<%= item.getPrice()%>円<br>
        小計:<%= (item.getNumber() * item.getPrice())%>円<br><br>
        <%sum += (item.getNumber() * item.getPrice());%>        
        <%}%>
        総計:<%= sum%>円<br>
    </body>
    <%= mh.indexJumper()%>
</html>
