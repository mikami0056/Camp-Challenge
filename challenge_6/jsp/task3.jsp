<%-- 
    Document   : task3
    Created on : 2016/04/11, 13:25:41
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" contentType="text/html"%>
<%@page import = "java.text.*" contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>task3</title>
    </head>
    <body>
        <%
            Date time = new Date();                                             //現在時刻を取得
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //表示させたい型を設定
            String t = f.format(time);                      
            //out.print(t);
            Cookie c = new Cookie("LastLogin", t);                              //Cookieの名前と値を決定(両者とも文字列型)
            response.addCookie(c);
            
            Cookie cs[] = request.getCookies();
            if(cs != null){
                for(int i = 0; i < cs.length; i++){
                    if(cs[i].getName().equals("LastLogin")){
                        out.print("最後のログインは" + cs[i].getValue() + "です");
                        break;
                    }
                }
            }
        %>
    </body>
</html>
