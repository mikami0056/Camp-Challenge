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
        <title>task4-1</title>
    </head>
    <body>
        <p>課題4</p>
        <p>課題1で定義したメソッドに追記する形として、戻り値　true(boolean)　を返却するように修正<br>
           メソッドの呼び出し側でtrueを受け取れたら「この処理は正しく実行できました」<br>
           そうでないなら「正しく実行できませんでした」と表示する</p>
        <%
            for (int i = 1; i < 11; i ++){
                out.print(i + " 回目 <br>");
                out.print("私の名前は " + GetName() + " です。<br>");
                out.print("生年月日は " + GetBirth() + " です。<br>");
                out.print("現住所は " + GetAddress() + " です。<br>");
                out.print("<br>");
            }
            if(GetType()){
                    out.print("この処理は正しく実行出来ました。");
                } else {
                    out.print("正しく実行出来ませんでした。");
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
        
        <%!
          boolean GetType(){
            return false;
        }
        %>
    </body>
</html>
