<%-- 
    Document   : mypicturemanager
    Created on : 2016/05/30, 16:52:11
    Author     : gest
--%>

<%@page import="java.util.Map"%>
<%@page import="model.PictureDataBeans"%>
<%@page import="model.PictureDataBeans"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="model.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
        <link rel="stylesheet" href="common/css/standard.css">
        <link rel="stylesheet" href="common/css/mypicturemanager.css">
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
            <h1 id="siteTitel">WorkSpaces</h1>
            <nav class="global">
                <ul>
                <li><a href="/WorkSpacesProto/WorkSpaces">ホーム</a></li>
                <li class="current"><a href="/WorkSpacesProto/WorkSpaces?option=MyPage">マイページ</a></li>
                <li><a href="/WorkSpacesProto/Logout">ログアウト</a></li>
                <li><a href="/WorkSpacesProto/Contact">お問い合わせ</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <%
            HttpSession hs = request.getSession();
            Map<String, PictureDataBeans> pictures = (HashMap<String, PictureDataBeans>)hs.getAttribute("pictures");
            if(!pictures.isEmpty()){
                for(String pictureName : pictures.keySet()){
                    PictureDataBeans picture = pictures.get(pictureName);
        %>
            <div id="outline">
                <span class="contain" style="background-image: url('<%=picture.getPath()%>')"></span>
                <p class="subject"><%=picture.getName()%> / <%=picture.getDateTime()%></p>
                <p class="commenttitle">投稿者コメント</p>
                <p class="commentblock"><%=picture.getComment()%></p>
                <a class="update" ref="WorkSpacesProto/Manage?option=Update&id=<%=picture.getName()%>">投稿情報を変更</a>
                <a class="delete" ref="WorkSpacesProto/Manage?option=Delete&id=<%=picture.getName()%>">投稿情報を削除</a>
            </div>    
            <%}%>
        <%} else {%>
            <p>投稿された写真はありません</p>
        <%}%>
        <%--
        <%for(String pictureName : pictures.keySet()){%>
        <section>
        <img src="${pageContext.request.contextPath}/common/image/${loginAccount.userName}/<%=pictureName%>"
        class="image-left">
        <p>題名：<%=pictures.get(pictureName).getName()%></p>
        <p>投稿者：${loginAccount.userName}</p>
        <p>投稿日：<%=pictures.get(pictureName).getDateTime()%></p>
        <br>
        <hr>
        </section>
        <%}%>
        --%>
        </div>
    </body>
</html>
