<%-- 
    Document   : task3-3test
    Created on : 2016/04/03, 23:21:47
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>課題3</p>
        <p>引き数が3つのメソッドを定義する。<br>
           <<以下条件>><br>
           1.適当な数値<br>
           2.デフォルト値が5の数値<br>
           3.デフォルト値がfalse(boolean)のtype<br><br>
           上記3つを引き数として定義する。<br>
           1つ目の引き数に2つ目の引き数を掛ける計算をするメソッドを作成<br>
           typeがfalseの時はその値を表示、trueのときはさらに2乗して表示する。<br>
           「変数2」と「タイプ」を変更する場合は, クエリストリングを使用<br>
           例：変数2を10, タイプをtrueにする場合<br>URL?a=10&b=true
        </p>
        
        <p>以下結果</p>
        <%
            int v = (int)(Math.random()*10 + 1);                                //適当な変数1を生成   
            int c = 0;                                                          //変数2を初期化
            
            String a = request.getParameter("a");                               //クエリストリングより変数2用の数値を取得
            if ( a != null){                                                    //aに数値がある場合, それをcに数値として代入
                c = Integer.parseInt(a);                
            }
            
            String b = request.getParameter("b");                               //クエリストリングよりタイプを取得                                          
            boolean type = Boolean.valueOf(b);                                  //文字列typeをbooleanに変換
            
            if (a == null && b == null){                                        //a:数値なし, b:タイプなし
                c = 5;                                                          //数値, タイプのデフォルト値を設定
                type = false;
                
            } else if (a != null && b == null){                                 //a:数値あり, b:タイプなし
                type = false;                                                   //タイプのデフォルト値を設定
                
            } else if (a == null && b != null){                                 //a:数値なし, b:タイプあり
                c = 5;                                                          //数値のデフォルト値を設定
                
            }
            
            out.print(getMulti(type, v, c) + "<br>");
            out.print("変数1：" + v + "<br>");
            out.print("変数2 (デフォルト値 = 5)：" + c + "<br>");
            out.print("運勢(デフォルト値 = false)：" + type + "<br><br>");
        %>
        
        <%!
            Integer getMulti(boolean type, Integer var, Integer con){
            
            int sum = var * con;
            
            if (type){
                sum = sum * sum;
            
            } else {
                return sum;
                
            }
            return sum;
            
            }
        %>
    </body>
</html>
