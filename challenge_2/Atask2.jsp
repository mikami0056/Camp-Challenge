<%--
    Document   : test
    Created on : 2016/03/29, 10:36:15
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
        <%
            String Number = request.getParameter("x");  // xから数字を文字列として受け取る
            int X = Integer.parseInt(Number);           // xを整数に変換
            int Y = 0;                                  // 指数Yを初期化
            final int Z = X;                            // 表示用として保存
            out.print("元の数値：" + Z + "<br>");         
            
            if ( X % 2 == 0){                   // 2で割れる場合
                while ( X % 2 == 0 ){           // 2でできる限り割る
                    X = X / 2; 
                    Y++;                        // 2の指数をカウント
                }
                out.print(Z + "=" + "2^" + Y);   
                
            } else if ( X % 2 != 0){            // 2で割れない場合
              out.print(Z + "= 1" );            //  
              }
            
            for (int i = 3; i < 8; i+=2){      // 3,5,7で割っていく
                Y = 0;                      // 各奇数の指数を初期化
                if ( X % i == 0){                   
                    while (X % i == 0){         
                        X = X / i;
                        Y++;                    //各奇数の指数をカウント
                    } 
                    out.print("*" + i + "^" + Y);
                }
            }
            
            if (X >= 10){                   //残った数字が10以上の場合
            out.print(" * その他");
            }     
        %>
    </body>
</html>

