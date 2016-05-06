<%@page 
        import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報検索画面</title>
    </head>
    <body>
        <h1>検索フォーム</h1>
        <!-- 変更点:methodを[POST]から[GET]へ変更 -->
        <form action="SearchResult" method="GET">
        名前:
        <input type="text" name="name" placeholder="氏名を入力">
        <br><br>

        生年:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>年生まれ
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <%out.print("id="+i);%>>
            <label <%out.print("for="+i);%>><%=jh.exTypeNum(i)%></label>
            <% } %>
        <br>
        
        <!-- 追加点(仕様書に規定無し) ここから-->
        検索方法:
        <br> 
            <label for="and">
            <input type="radio" name="searchMethod" value="1" id="and" checked>AND  
            </label>
            <label for="or">
            <input type="radio" name="searchMethod" value="2" id="or">OR
            </label>
        <br><br>
        <!-- 追加点(仕様書に規定無し) ここまで-->

        <input type="submit" name="btnSubmit" value="検索">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
