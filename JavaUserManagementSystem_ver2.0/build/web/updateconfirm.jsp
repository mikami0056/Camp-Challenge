<%-- 
    Document   : updateconfirm
    Created on : 2016/05/06, 10:57:03
    Author     : SHO
--%>

<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    //追加点:セッションスコープよりユーザー情報を取得
    String caution = (String)request.getAttribute("caution");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新確認画面</title>
    </head>
    <body>
        <% if(caution==null) { 
            UserDataDTO rd = (UserDataDTO)hs.getAttribute("resultData");//旧ユーザー情報
            UserDataDTO ud = (UserDataDTO)hs.getAttribute("updateData");//新ユーザー情報
        %>
        <!-- 旧ユーザー情報 -->
        <table border=1>
            <!-- 変更点:表を可変にするためにfor文の範囲を変更 -->
            <h2>登録情報変更</h2>
            <thread>
            <tr>
                <th>分類</th>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            </thread>
            <tbody>
            <tr>
                <td>旧</td>
                <td><%= rd.getName() %></td>
                <td><%= rd.getBirthday() %></td>
                <td><%= jh.exTypeNum(rd.getType())%></td>
                <td><%= rd.getNewDate()%></td>
            </tr>            
        <!-- 新ユーザー情報 -->
            <tr>
                <td>新</td>
                <td><%= ud.getName() %></td>
                <td><%= ud.getStrBirthday() %></td>
                <td><%= jh.exTypeNum(ud.getType())%></td>
                <td>DB登録時に打刻される時刻</td>
            </tr>
            </tbody>
        </table>
            <div style="display:inline-flex">
            <form action="UpdateResult" method="POST">
                <input type="submit" name="updateData" value="更新" style="width:100px"><br>
            </form>
            <form action="Update" method="POST">
                <input type="submit" name="return" value="戻る" style="width:100px">
            </form>
            </div>
        <% } else { %>
            以下の内容が入力されていません.<br>
            <%= caution %><br>
            <form action="Update" method="POST">
            <input type="submit" name="return" value="戻る" style="width:100px">
            </form>
        <% } %>
    </body>
</html>
