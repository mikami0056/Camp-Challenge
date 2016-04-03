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
            int a = 0;                                                          //10回終了の判断用変数
            for (int i = 1; i < 11; i ++){   
                out.print(i + " 回目 <br>");
                String[] Names = getInfo();
                
                for (int j = 0; j < Names.length; j++){
                    out.print(Names[j] + "<br>");
                    
                }
                a = i;
                
            }
            boolean type = getType(a);
                if(type){
                    out.print("この処理は正しく実行出来ました。<br>");
                        
                } else {
                    out.print("この処理は正しく実行出来ませんでした。<br>");
         
                }       
        %>
        
        <%!
            String[] getInfo(){
                String[] names = {"三上祥一郎", "平成3年5月6日", "千葉県印西市"};
                return names;
                
        }
        %>
        
        <%!
            boolean getType(int i){
                return i == 10;
            
        }
        %>
    </body>
</html>
