<%-- 
    Document   : task2
    Created on : 2016/03/30, 22:30:56
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task2</title>
    </head>
    <body>
        <p>課題2</p>
        <p>引数として数値を受け取り、その値が奇数か偶数か判別＆表示する処理をメソッドとして制作し、適当な数値に対して奇数・偶数の判別を行ってください</p>
        <%
          int v = (int)(Math.random()*10 + 1);  //1〜10の変数を生成
          out.print(v + "<br>");                //変数確認用
          out.print(getOddeven(v));             //メソッドに変数を渡す
        %>
        
        <%!
            String getOddeven(int i){
              int rem = i % 2;                  //余りを計算
                String mess = "";               //メッセージ用の変数
                if (rem == 0){                  
                    mess = "これは偶数です。";
                } else if (rem != 0){
                    mess = "これは奇数です。";
                }
              return mess;
        }
        %>
    </body>
</html>
