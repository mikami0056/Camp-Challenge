<%-- 
    Document   : Atask
    Created on : 2016/03/28, 15:53:02
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>クエリーストリング</title>
    </head>
    <body>
        <%
            String Commodity = request.getParameter("X");   //商品種別
            String Sum = request.getParameter("Y");         //総額
            String Num = request.getParameter("Z");         //個数
            
            int com = Integer.parseInt(Commodity);          //商品種別を整数に変換
            int sum = Integer.parseInt(Sum);                //総額を整数に変換
            int num = Integer.parseInt(Num);                //個数を整数に変換
            
            //商品種別について
            switch (com){
            case 1:
                out.print("1:雑貨<br>");
            break;

            case 2:
                out.print("2:生鮮食品<br>");
            break;

            case 3:
                out.print("3:その他<br>");
            break;
            }
            
            //総額, 個数, 1個当たりの値段について
            int value = ( sum / num );
            out.print("総額: " + sum + " 円<br>");
            out.print("1個当たりの値段：" + value + "円<br>");
            
            //ポイントについて
            if ( sum >= 5000 ){
                
                double point1 = ( sum * 0.05 );
                out.print("お買い上げが5000円以上なので, 5%のポイントがつきます。<br>");
                out.print("今回のお買い上げで " + point1 + " ポイント貯まりました<br>");
                
            } else if ( sum >= 3000 ){
                
                double point2 = ( sum * 0.04 );
                out.print("お買い上げが3000円以上なので, 4%のポイントがつきます。<br>");
                out.print("今回のお買い上げで " + point2 + " ポイント貯まりました<br>");
                
            } else {
                
                out.print("今回、ポイントはつきませんでした。");
                
            }
        %>
    </body>
</html>
