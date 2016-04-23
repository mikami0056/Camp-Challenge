<%@page import="jums.JumsHelper"%>                                              <!-- 追加点(課題1) -->
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <!-- 変更点(課題3) 以下のif文の条件文を変更 -->
    <% if((Boolean)hs.getAttribute("check")){ %>
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>"><!-- 追加点(課題2) -->
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <!-- 追加点(課題3)ここから -->
        <p>以下の内容が未入力です</p>
        <%= hs.getAttribute("caution")%><!-- 未入力内容を表示 -->
        <!-- 追加点(課題3)ここまで -->
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>"><!-- 追加点(課題2) -->
        </form>
        <%= JumsHelper.getInstance().home() %>                                  <!-- 追加点(課題1) -->
    </body>
</html>
