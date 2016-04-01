<%-- 
    Document   : task3-2
    Created on : 2016/04/01, 10:33:51
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task3-2</title>
    </head>
    <body>
        <%
            int v = (int)(Math.random()*10 + 1);        //適当な変数1を生成   
            int c = 0;                                  //変数2を初期化
            
            String a = request.getParameter("a");       //クエーリストリングより変数2用の数値を「文字列」として取得
            if ( a != null){                            //aに記述がある場合, それをcに数値として代入
                c = Integer.parseInt(a);                
            }
            
            String b = request.getParameter("b");       //クエーリストリングよりタイプを「文字列」として取得                                          
            boolean type = Boolean.valueOf(b);          //文字列typeをbooleanに変換
            
            if (a != null && b == null){                //a:数値あり, bに数値なし 
                type = false;                           //タイプのデフォルト値を設定
                
            } else if (a == null){            //
                c = 5;                                  
                
            } else if (a == null && b == null){
                c = 5;                 //文字列aを整数に変換
                type = false;
                
            }
            
            out.print(getMulti(type, v, c) + "<br>");
            
            out.print("変数1：" + v + "<br>");
            out.print("変数2 (デフォルト値 = 5)：" + c + "<br>");
            out.print("運勢(デフォルト値 = false)：" + type + "<br><br>");
            
            out.print("「変数2」と「運勢」を変更する場合は, クエリストリングを使用<br>");
            out.print("URL? a=変数2&b=trueまたはfalse");
            
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
