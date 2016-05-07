<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //変更点:ArrayList型のインスタンスを取得
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        該当件数:<%= udd.size() %>件<br><!-- 追加点 -->
        
        <!-- 変更点:ここから -->
        <% if(!udd.isEmpty()){ %> <!-- 変更点(仕様書との相違):条件に該当するデータが無ければ何も表示しない様にしている -->
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for (UserDataDTO shows : udd) { %>
            <tr>
                <td><a href="ResultDetail?id=<%= shows.getUserID() %>"><%= shows.getName() %></a></td>
                <td><%= shows.getBirthday() %></td>
                <td><%= jh.exTypeNum(shows.getType())%></td>
                <td><%= shows.getNewDate() %></td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
            条件に該当するデータはありませんでした.
        <% } %>
        <form action="Search" method="POST">
        <input type="submit" name="return" value="検索に戻る" style="width:100px">
        </form>
        <!-- 変更点:ここまで -->
        <%=jh.home()%>
    </body>
</html>
