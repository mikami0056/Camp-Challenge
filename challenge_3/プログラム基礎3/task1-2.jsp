<%-- 
    Document   : task1-2
    Created on : 2016/03/31, 15:14:31
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task1-2</title>
    </head>
    <body>
        <p>課題1</p>
        <p>自分のプロフィール(名前、生年月日、自己紹介)を3行に分けて表示するユーザー定義メソッドを作り、メソッドを10回呼び出して下さい</p>
        <%
            String[] Names = getInfo();
            for (int i = 1; i < 11; i ++){
                out.print(i + " 回目 <br>");
                
                for (int j = 0; j < Names.length; j++){
                    out.print(Names[j] + "<br>");
                }
                out.print("<br><br>");
            }
        %>
        <%!
            String[] getInfo(){
                String[] names = {"三上祥一郎", "平成3年5月6日", "千葉県印西市"};
                return names;
        }
        %>
    </body>
</html>
