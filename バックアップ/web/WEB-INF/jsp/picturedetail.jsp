<%-- 
    Document   : picturedetail
    Created on : 2016/06/03, 16:53:10
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession hs = request.getSession(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
    </head>
    <body>
        <h1>写真詳細</h1>
        <p><img src="${picture4Detail.path}"></p>
        <p>題名：${picture4Detail.name}</p>
        <p>投稿者：${picture4Detail.userName} / 投稿日：${picture4Detail.dateTime}</p>
        <p>投稿者コメント：${picture4Detail.comment}</p>
        <p>評価：
        <button>キレイ</button>[${picture4Detail.beautiful}] <button>カッコイイ</button>[${picture4Detail.cool}] <button>オシャレ</button>[${picture4Detail.stylish}] 合計[${picture4Detail.sum}]</p>
        
    </body>
</html>
