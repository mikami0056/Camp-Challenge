<%@page import="jums.JumsHelper"%>                                              <!-- 追加点(課題1) -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%out.println("エラーです。");%>
        <%=request.getAttribute("error")%>
        <%=JumsHelper.getInstance().home()%>                                    <!-- 追加点(課題1) -->
    </body>
</html>
