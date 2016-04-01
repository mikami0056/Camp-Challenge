<%-- 
    Document   : task4-2
    Created on : 2016/03/31, 15:24:56
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task4-2</title>
    </head>
    <body>
        <p>課題4</p>
        <p>課題1で定義したメソッドに追記する形として、戻り値　true(boolean)　を返却するように修正<br>
           メソッドの呼び出し側でtrueを受け取れたら「この処理は正しく実行できました」<br>
           そうでないなら「正しく実行できませんでした」と表示する</p>
        <%  
            boolean Type = getType();
            
            if (Type){
                String[] Names = getInfo();
                
                for (int i = 1; i < 11; i ++){
                    out.print(i + " 回目 <br>");
                
                    for (int j = 0; j < Names.length; j++){
                    out.print(Names[j] + "<br>");
                    }
                out.print("<br><br>");
                }
                
                out.print("この処理は正しく処理されました。");
                
            } else {
                out.print("この処理は正しく処理されませんでした。");
            }
        %>
        <%!
            String[] getInfo(){
                String[] names = {"三上祥一郎", "平成3年5月6日", "千葉県印西市"};
                return names;
        }
        %>
        
        <%!
            boolean getType(){
                boolean type; type = true;
                return type;
        }
        %>
    </body>
</html>
