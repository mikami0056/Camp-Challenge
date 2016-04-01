<%-- 
    Document   : task7
    Created on : 2016/03/31, 14:45:59
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task7</title>
    </head>
    <body>
        <p>課題7</p>
        <p>課題6の3人分のプロフィールのうち1人だけ住所が値nullの状態で定義し、<br>
           ループ処理で全員分のプロフィールをid以外表示する処理を実行する。<br>
           この際、歯抜けになっているデータはcontinueで飛ばす</p>
        <%
        int[] idArray = {111, 222, 333};                        //各IDを設定
                
            for (int a = 0; a < 3; a++){
                String[] Array = getInfo(idArray[a]);           //getInfoメソッドにIDを渡し, 配列をもらう
            
            for(int j = 1; j < Array.length; j++){          
                if(Array[j] == null){
                    continue;
                } 
                out.print(Array[j] + "<br>");  
            }
            }
        %>
        
        <%!
            String[] getInfo (int i){                           //文字列配列が戻り値, IDのいずれかを引数として受け取る
                switch (i){                                     //ID番号で確認
                    case 111:
                        String[] yamada = {"111", "山田", "1月1日", null};
                        return yamada;
                
                    case 222:
                        String[] tanaka = {"222", "田中", "4月15日", "東京都"};
                        return tanaka;
                
                    case 333:
                    String[] yoshida = {"333", "吉田", "12月31日", "沖縄県"};
                        return yoshida;
                }
                String[] empty ={"", "想定外やで"};
                return empty;
            } 
        %>
    </body>
</html>
