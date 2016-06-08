<%-- 
    Document   : picturedetail
    Created on : 2016/06/03, 16:53:10
    Author     : gest
--%>

<%@page import="model.PictureDataBeans"%>
<%@page import="model.CountDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession hs = request.getSession();
    PictureDataBeans picture = (PictureDataBeans)hs.getAttribute("picture4Detail");
    String strID = String.valueOf(picture.getPictureID());
    CountDataBeans countData = (CountDataBeans)hs.getAttribute(strID);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="/WorkSpacesProto/common/javascript/picturedetail.js"></script>
        <title>WorkSpaces</title>
    </head>
    <body>
        <h1>写真詳細</h1>
        <p><img src="${picture4Detail.path}"></p>
        <p>題名：${picture4Detail.name}</p>
        <p>投稿者：${picture4Detail.userName} / 投稿日：${picture4Detail.dateTime}</p>
        <p>投稿者コメント：${picture4Detail.comment}</p>
        <p>評価：
        <button onClick="countBeautiful(${picture4Detail.pictureID})">キレイ</button><span id="beautiful"><%=countData.getBeautiful()%></span>
        <button onClick="countCool(${picture4Detail.pictureID})">カッコイイ</button><span id="cool"><%=countData.getCool()%></span> 
        <button onClick="countStylish(${picture4Detail.pictureID})">オシャレ</button><span id="stylish"><%=countData.getStylish()%></span> 
        <%--合計<span id="sum">[${picture4Detail.sum}]</span>--%></p>
    </body>
</html>
