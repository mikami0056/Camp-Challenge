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
        <link rel="stylesheet" href="common/css/style.css">
    </head>
    <body>
        <div id="page">
        <header id="pageHead">
            <h1 id="siteTitel">WorkSpaces</h1>
            <hr>
            <nav class="global">
                <ul>
                <li><a href="/WorkSpacesProto/WorkSpaces">ホーム</a></li>
                <li class="current"><a href="/WorkSpacesProto/MyPage?option=0">マイページ</a></li>
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
                    <img src="<%=picture.getPath()%>">
                    <p>題名：<%=picture.getName()%></p>
                    <p>投稿者：${loginAccount.userName}</p>
                    <p>パス：<%=picture.getPath()%></p>
                    <p>投稿者コメント：<%=picture.getComment()%></p>
                    <p>投稿日：<%=picture.getDateTime()%></p>
                    <form action="/WorkSpacesProto/Manage" method="GET">
                        <input type="submit" value="投稿情報を変更">
                        <input type="hidden" name="option" value="Update">
                        <input type="hidden" name="id" value="<%=picture.getName()%>">
                    </form>
                    <form action="/WorkSpacesProto/Manage" method="GET">
                        <input type="submit" value="投稿情報を削除">
                        <input type="hidden" name="option" value="Delete">
                        <input type="hidden" name="id" value="<%=picture.getName()%>">
                    </form>
                    <hr>
                <%}
        } else {%>
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
