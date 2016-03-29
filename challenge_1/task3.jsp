<%-- 
    Document   : task4.jsp
    Created on : 2016/03/28, 11:48:19
    Author     : SHO
--%>
<%
    String name = "三上祥一郎";          //氏名
    String birthDay = "平成3年5月6日";   //誕生日
    int age = 24;                      //年齢
    String nativePlace = "千葉県印西市"; //出身地または住所
    String oldSchool = "木更津工業高等専門学校"; //出身校
    String major = "機械・電子システム工学専攻"; //出身学部
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介</title>
    </head>
    <body>
        <%
            out.println("私は " + name + " と申します。<br>");
            out.println("生年月日は " + birthDay + " で, 現在 " + age + " 歳です。<br>");
            out.println("出身地は " + nativePlace + " です。<br>" );
            out.println("出身校は, " + oldSchool + " で,専攻は " + major +" です。<br>");
        %>
    </body>
</html>
