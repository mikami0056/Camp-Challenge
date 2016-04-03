<%-- 
    Document   : task2-2
    Created on : 2016/04/01, 15:10:07
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task2-2</title>
    </head>
    <body>
        <p>課題2</p>
        <p>引数として数値を受け取り、その値が奇数か偶数か判別＆表示する処理をメソッドとして制作し、適当な数値に対して奇数・偶数の判別を行ってください</p>
        <p>任意の数値を使用したい場合クエリストリングを使用してください。
           例：(15を使用したい場合).....URL?a=15</p>
        <%
            String a = request.getParameter("a");                               //クエリストリングよりパラメータを取得            
            int v = (int)(Math.random()*10 + 1);                                //デフォルト値をランダムに決定
            
            if ( a != null){                                                    //aに任意の数値がある場合, それを使用。
                v = Integer.parseInt(a);                                        //文字列を数値に変換
            }
          
            out.print(v + "<br>");                                              //変数確認用
            out.print(getOddeven(v));                                           //メソッドに変数を渡す
        %>
        
        <%!
            String getOddeven(int i){
                int rem = i % 2;                                                //余りを計算
                String mess = "";                                               //メッセージ用の変数
                
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
