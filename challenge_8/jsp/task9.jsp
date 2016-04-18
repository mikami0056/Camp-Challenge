<%-- 
    Document   : task9
    Created on : 2016/04/16, 12:26:10
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task9</title>
    </head>
    <body>
        <h1>挿入フォーム</h1>
        <hr>
        <form action="./task9" method="post">
        <ul>
        <li>
            <div>
            <font face = "sans-serif"><b>ID:</b></font>
            <input type="text" name="ID" size="15"maxlength="15"/>
            </div>
        </li>
        <li>
           <div>
               <font face = "sans-serif"><b>名前:</b></font>
               <input type="text" name="name" size="15"maxlength="15"/> 
           </div>
        </li>
        <li>
            <div>
               <font face = "sans-serif"><b>電話番号:</b></font>
               <input type="tel" name="tel" size="15"maxlength="15" placeholder="例)000-1111-2222"/> 
            </div>
        </li>
        <li>
            <div>
               <font face = "sans-serif"><b>年齢:</b></font>
               <input type="number" name="age" size="15"maxlength="15"/>
            </div>
        </li>
        <li>
            <div>
               <font face = "sans-serif"><b>生年月日:</b></font>
               <input type="text" name="birthdate" size="15"maxlength="15" placeholder="例)1990-01-01"/>
            </div>
        </li>
        <input type="submit" value="登録">
        <input type="reset" value="リセット">
        <br>
    </body>
</html>
