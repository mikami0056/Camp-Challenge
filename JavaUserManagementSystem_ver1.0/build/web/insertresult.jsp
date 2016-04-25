<!-- 追加点(課題7) -->
<%@page import="jums.RegisteredUser"%>
<!-- 追加点(課題1) -->
<%@page import="jums.JumsHelper"%>                                              
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    //追加点(課題7)
    RegisteredUser user = (RegisteredUser)hs.getAttribute("user"); //スコープに保存したインスタンスを取得
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        <!-- 変更点(課題7):表示する変数を全てuserインスタンスから取得 -->
        名前:<%= user.getName() %><br>
        生年月日:<%= user.getYear() +"年"+ user.getMonth() +"月"+ user.getDay()+"日"%><br>
        種別:<%= user.getType() %><br>
        電話番号:<%= user.getTell() %><br>
        自己紹介:<%= user.getComment() %><br>
        以上の内容で登録しました。<br>
        <!-- 追加点(課題1) -->
        <%=JumsHelper.getInstance().home()%>
        <!-- 追加点(課題5):セッションスコープを破棄 -->
        <% hs.invalidate(); %>
    </body>
</html>
