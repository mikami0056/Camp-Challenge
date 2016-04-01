<%-- 
    Document   : task1
    Created on : 2016/03/30, 16:15:23
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task1-1</title>
    </head>
    <body>
        <p>課題1</p>
        <p>自分のプロフィール(名前、生年月日、自己紹介)を3行に分けて表示するユーザー定義メソッドを作り、メソッドを10回呼び出して下さい</p>
        <%
            for (int i = 1; i < 11; i ++){
                out.print(i + " 回目 <br>");
                out.print("私の名前は " + GetName() + " です。<br>");
                out.print("生年月日は " + GetBirth() + " です。<br>");
                out.print("現住所は " + GetAddress() + " です。<br>");
                out.print("<br>");
            }
        %>
        
        <%!
          String GetName(){
            return "三上祥一郎";
        }
        %>
        
        <%!
          String GetBirth(){
            return "平成3年5月6日";
        }
        %>
        
        <%!
          String GetAddress(){
            return "千葉県印西市";
        }
        %>
        
    </body>
</html>
