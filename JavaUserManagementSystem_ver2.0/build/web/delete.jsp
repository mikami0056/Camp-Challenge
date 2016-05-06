<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= jh.exTypeNum(udd.getType())%><br><!--変更点:表示内容を数値から職種名に変更-->
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい" style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px">
    </form>
    </body>
</html>
