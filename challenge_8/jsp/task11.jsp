<%-- 
    Document   : task11
    Created on : 2016/04/16, 18:27:07
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task11</title>
    </head>
    <body>
        <h1>上書きフォーム</h1>
        <hr>
        <h2>上書き対象のID</h2>
        <hr>
        <form action="./task11" method="post">
            <div>
            <font face = "sans-serif"><b>ID:</b></font>
            <input type="text" name="ID" size="15"maxlength="15"/>
            </div>
        <h2>上書き内容</h2>
        <hr>
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
        <input type="submit" value="上書き登録">
        <input type="reset" value="リセット">
        <br>
    </body>
</html>
