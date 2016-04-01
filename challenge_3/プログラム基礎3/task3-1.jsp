<%-- 
    Document   : task3
    Created on : 2016/03/30, 22:54:39
    Author     : SHO
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task3</title>
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
           typeがfalseの時はその値を表示、trueのときはさらに2乗して表示する。<br></p>
        
        <p>以下結果</p>
        
        <%
            int v = (int)(Math.random()*10 + 1);
            int c = 5;
            boolean type; type = false;  
            
            out.print(getMulti(type, v, c));
            
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
        
        <%!
            Integer getMulti(boolean type, Integer var){
            
            int sum = var * 5;
            
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
