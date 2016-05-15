<%-- 
    Document   : loginheader
    Created on : 2016/05/15, 23:22:46
    Author     : SHO
--%>

<%@page import="model.UserDataBeans"%>
<%@page import="model.ModelHelper"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
%>
<p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper() + " ・ " + mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper());
}%></p>
<hr>