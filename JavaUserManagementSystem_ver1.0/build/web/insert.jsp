<%@page import="jums.RegisteredUser"%>      <!-- 追加点(課題7) -->
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    Boolean isExisting = (Boolean)hs.getAttribute("isExisting");
    //追加点(課題7)
    RegisteredUser user = new RegisteredUser();
    if(isExisting){
        user = (RegisteredUser)hs.getAttribute("user");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        <!-- 変更及び追加点(課題4, 7)ここから -->
        <!-- 変更点(課題7):表示用の全変数はuserインスタンスから変数を取得 -->
        名前:
        <!-- 変更点(課題4):スコープ内にnameインスタンスが有る場合は取得 -->
        <input type="text" name="name" value="<% if(isExisting){out.print(user.getName());} %>" placeholder="名前を入力">
        <br><br>
        
        生年月日:
        <!-- 変更点:スコープ内に各インスタンス(year, month, day)が有る場合は取得 -->
        <select name="year">
            <% if(isExisting && user.getYear().length()>0){ %><!-- 追加点 -->
            <option value="<%= user.getYear()%>"><%= user.getYear()%></option><!-- 変更点 -->
            <% } else { %><!-- 追加点 -->
            <option value="">----</option>
            <% } %>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
            
        <select name="month">
            <% if(isExisting && user.getMonth().length() > 0){ %><!-- 追加点 -->
            <option value="<%= user.getMonth() %>"><%= user.getMonth() %></option><!-- 変更点 -->
            <% } else { %><!-- 追加点 -->
            <option value="">----</option>
            <% } %>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        
        <select name="day">
            <% if(isExisting && user.getDay().length()>0){ %><!-- 追加点 -->
            <option value="<%= user.getDay() %>"><%= user.getDay() %></option><!-- 変更点 -->
            <% } else { %><!-- 追加点 -->
            <option value="">--</option>
            <% } %>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <!-- 変更点:スコープ内にtypeインスタンスがあれば取得 -->
        <!-- 追加点:labelタグを追加 -->
        <input type="radio" name="type" value="1" <% if("1".equals(user.getType())){ out.print("checked"); } %> id="engineers"><label for="engineers">エンジニア</label><br>
        <input type="radio" name="type" value="2" <% if("2".equals(user.getType())){ out.print("checked"); } %> id="salesmen"><label for="salesmen">営業</label><br>
        <input type="radio" name="type" value="3" <% if("3".equals(user.getType())){ out.print("checked"); } %> id="others"><label for="others">その他</label><br>
        <br>

        電話番号:
        <!-- 変更点:スコープ内にtellインスタンスがあれば取得 -->
        <input type="text" name="tell" value="<% if( user.getTell() != null){ out.print(user.getTell()); } %>" placeholder="例) 000-1111-2222">
        <br><br>

        自己紹介文
        <br>
        <!-- 変更点:スコープ内にcommentインスタンスがあれば取得 -->
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" placeholder="よろしくお願いします。"><% if( user.getComment() != null){ out.print(user.getComment()); } %></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
        <input type="reset" name="reset" value="リセット">
        <!-- 変更及び追加点(課題4, 7)ここまで -->
        
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
