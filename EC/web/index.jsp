<%-- 
    Document   : index
    Created on : 2016/05/02, 11:17:34
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ModelHelper"%>
<%@page import="model.Common"%>
<%@page import="model.ItemSearch"%>
<%@page import="java.util.Map"%>

<%
    Common con = new Common();
    System.out.println("======ECサイトスタート=======");
    ModelHelper mh = ModelHelper.getInstance();
    Map<String, String> categories = con.getCategories();
    Map<String, String> sortOrder = con.getSortOrder();
    String place = "index";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
        <!-- 名前変更 [index.jsp] から [top.jsp]-->
    </head>
    <body>
        <h1>検索フォーム</h1>
        <form action="Search" method="GET">
            <p>キーワード:
            <input type="text" name="query" placeholder="キーワードを入力"></p>
            
            <p>分類:
            <select name="category">
                <option value="">----</option>
                <%for(String key : categories.keySet()){%>
                <option value="<%= key%>"><%= categories.get(key)%></option>
                <%}%>
            </select></p>
            
            <p>列び順:
            <select name="sort">
                <option value="">----</option>
                <%for(String key : sortOrder.keySet()){%>
                <option value="<%=key%>"><%= sortOrder.get(key)%></option>
                <%}%>
            </select></p>
            <input type="submit" name="search" value="検索">
            <br><br>
            <%-- クエリストリングではなくリクエストスコープの方がいいかも --%>
            <%
                String flag = request.getParameter("flag");
                if("error".equals(flag)){
                    out.print("検索フォームに何も入力されていません");
                }
            %>
        </form>
        <%= mh.loginJumper()%>
    </body>
</html>
