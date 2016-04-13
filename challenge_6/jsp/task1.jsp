<%-- 
    Document   : task1
    Created on : 2016/04/11, 10:35:19
    Author     : SHO
--%>

<%@page import="java.net.URLEncoder"%>
<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.net.*" contentType="text/html"%>
<%
   String sfamily="a";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./sample.css" type="text/css">
        <title>task1</title>
    </head>
    <body>
    <h1>自己紹介登録フォーム</h1>
    <hr>
    <form action="./task1.jsp" method="post">
        <font face = "sans-serif"><b>名前</b></font><br>
        <input type="text" name="family" size="15" maxlength="10" placeholder="姓" >
        <input type="text" name="first" size="15" maxlength="10" placeholder="名"><br>
        
        <font face = "sans-serif"><b>性別</b></font><br>
        <font face = "sans-serif" color="blue">男性 </font><input type="radio" name="gender" value="男性" checked>
        <font face = "sans-serif" color="red">女性 </font><input type="radio" name="gender" value="女性"><br>
                
        <font face = "sans-serif"><b>血液型</b></font><br>
        <select name = "blood">
            <option value="A">A型</option>
            <option value="B">B型</option>
            <option value="O">O型</option>
            <option value="AB">AB型</option>
        </select><br>
        <font face = "sans-serif"><b>趣味</b></font><br>
        <textarea name="hobbies" placeholder="趣味を入力してください。" cols="30" rows="5" maxlength="100" wrap="hard"></textarea><br>
        <form action="./task1" method="post">
        <br>
        <input type="submit" value="送信">
        <input type="reset" value="リセット">
        <br>
        <%
            sfamily = request.getParameter("family");
            //out.print(URLEncoder.encode(sfamily, "UTF-8"));
            Cookie cfamily = new Cookie("cfamily", URLEncoder.encode(sfamily, "UTF-8"));
            //Cookie cfamily = new Cookie("cfamily","aaaaaa");
            
            response.addCookie(cfamily);
            
            Cookie cs[] = request.getCookies();
            if(cfamily != null){
                for(int i = 0; i < cs.length; i++){
                    if(cs[i].getName().equals("cfamily")){
                        sfamily = cs[i].getValue();
                    }
                }
            }
        %>
    </form>    
    </body>
</html>
