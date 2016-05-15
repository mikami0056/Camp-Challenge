<%-- 
    Document   : index
    Created on : 2016/05/02, 11:17:34
    Author     : SHO
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="model.UserDataBeans"%>
<%@page import="model.ModelHelper"%>
<%@page import="model.Common"%>
<%@page import="model.ItemSearch"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    System.out.println("======ECサイトスタート=======");
    HttpSession hs = request.getSession();
    ModelHelper mh = (ModelHelper)hs.getAttribute("mh");
    if(mh == null){
        mh = new ModelHelper();
        hs.setAttribute("mh", mh);
    }
    Common con = (Common)hs.getAttribute("con");
    if(con == null){
        con = new Common();
        hs.setAttribute("con", con);
    }
    Map<String, String> categories = con.getCategories();
    Map<String, String> sortOrder = con.getSortOrder();
    UserDataBeans loginAccount = (UserDataBeans)hs.getAttribute("loginAccount");
    boolean exist = mh.existAccount(loginAccount);
    hs.setAttribute("URL", request.getRequestURL());
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
        <p align="right"><%= mh.loginJumper("")%>
        <%if(exist){
            out.print(mh.userPageJumper(loginAccount.getName()));
            out.print(mh.cartJumper());
            out.print(mh.loginJumper("ログアウト"));
        } else {
            out.print(mh.loginJumper("ログイン"));
        }%></p>
        <form action="Search" method="GET">
            <p>キーワード:
            <input type="text" name="query" placeholder="キーワードを入力" required></p>
            
            <p>分類:
            <select name="category">
                <option value="指定なし">----</option>
                <%for(String key : categories.keySet()){%>
                <option value="<%= key%>"><%= categories.get(key)%></option>
                <%}%>
            </select></p>
            
            <p>並び順:
            <select name="sort">
                <option value="指定なし">----</option>
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
