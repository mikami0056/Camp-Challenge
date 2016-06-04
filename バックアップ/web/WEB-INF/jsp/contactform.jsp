<%-- 
    Document   : contactform
    Created on : 2016/06/01, 16:47:48
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkSpaces</title>
    </head>
    <body>
        <form action="Contact" method="POST">
        お問い合わせの種類：
        <select name="contactType">
            <option value="">-----</option>
            <%for(int i=1; i<6; i++){%>
            <option value="<%=i%>">内容<%=i%></option>
            <%}%>
        </select>
        <p>題名：<br>
        <input type="text" name="subject">
        </p>
        <p>メールアドレス：<br>
        <input type="text" name="mail">
        </p>
        <p>問い合わせ内容：<br>
        <textarea name="message" cols="50" rows="5" placeholder="お問い合わせ内容をご記入下さい"></textarea>
        </p>
        <p>上記の内容で問い合わせる：<br>
        <input type="checkbox" name="check" value="1">
        <%if((request.getAttribute("caution")) != null){
            out.print("チェックして下さい!");
        }
        %>
        </p>
        <p><input type="submit" value="問い合わせ"></p>
        </form>
    </body>
</html>
