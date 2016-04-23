<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JUMSトップ</title>
</head>
<body>
    <h1>ユーザー情報管理トップ</h1><br>
    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
    <a href="insert">新規登録</a><br>
    <%
        //追加点(課題4):セッションスコープ内のインスタンスの有無確認用
        HttpSession hs = request.getSession();
        Boolean existing = false;
        hs.setAttribute("existing",existing);
    %>
    <a href="" >検索(修正・削除)</a><br>
</body>
</html>
