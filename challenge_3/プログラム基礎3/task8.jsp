<%-- 
    Document   : task8
    Created on : 2016/03/31, 15:00:10
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task8</title>
    </head>
    <body>
        <p>課題8</p>
        <p>Integer limit=2を定義し、課題7の処理のうち2人目(limitで定義した値の人数)まででループ処理を抜けるようにする</p>
        <%
        int[] idArray = {111, 222, 333};                                        //各IDを設定
        Integer limit = 2;                                                      //限界値を設定 
            
            for (int a = 0; a < limit; a++){                    
                String[] Array = getInfo(idArray[a]);                           //配列を生成
            
                for(int j = 1; j < Array.length; j++){          
                    if(Array[j] == null){
                        continue;
                    
                    } 
                out.print(Array[j] + "<br>");
                
                }
            }
        %>
        
        <%!
            String[] getInfo (int i){                                           //文字列配列が戻り値, IDのいずれかを引数として受け取る
                switch (i){                                                     //ID番号で確認
                    case 111:
                     String[] yamada = {"111", "山田", "1月1日" , "北海道"};
                    return yamada;
                
                    case 222:
                     String[] tanaka = {"222", "田中", "4月15日", "東京都"};
                    return tanaka;
                
                    case 333:
                     String[] yoshida = {"333", "吉田", "12月31日", "沖縄県"};
                    return yoshida;
                    
                    default:
                     String[] empty ={"", "想定外です。", "想定外です!", "想定外やで!!"};
                    return empty; 
                }
                
            } 
        %>
    </body>
</html>
