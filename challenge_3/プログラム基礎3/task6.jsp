<%-- 
    Document   : task6
    Created on : 2016/03/31, 13:55:11
    Author     : SHO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task6</title>
    </head>
    <body>
        <p>課題6</p>
        <p>引き数に1つのid(数値)をとり、3人分のプロフィール(項目は課題5参照)をあらかじめメソッド内で定義しておく。<br>
           引き数のid値により戻り値として返却するプロフィールを誰のものにするか選択する。<br>
           それ以降などは課題5と同じ扱いに</p>
        <%
        int[] idArray = {111, 222, 333, 444};                                   //各IDを設定
        int I = (int)(Math.random()*3);                                         //idArray用キー変数の生成(0〜2)
        
        String[] Array = getInfo(idArray[I]);                                   //配列を生成
        
        for(int j = 1; j < Array.length; j++){          
            out.print(Array[j] + "<br>");
            
        }
        %>
        
        <%!
            String[] getInfo (int i){                                           //文字列配列が戻り値, IDのいずれかを引数として受け取る
                switch (i){                                                     //ID番号で確認
                    case 111:
                     String[] yamada = {"111", "山田", "1月1日", "北海道"};
                    return yamada;
                
                    case 222:
                     String[] tanaka = {"222", "田中", "4月15日", "東京都"};
                    return tanaka;
                
                    case 333:
                     String[] yoshida = {"333", "吉田", "12月31日", "沖縄県"};
                    return yoshida;
                    
                    default:
                     String[] empty = {"", "想定外です", "想定外です!", "(｀Д´) <想定外やで!!"};
                    return empty;
                    
                }
                
            } 
        %>
    </body>
</html>
