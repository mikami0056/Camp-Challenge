<%--
    Document   : task7
    Created on : 2016/03/28, 15:02:43
    Author     : SHO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Array1</title>
    </head>
    <body>
        <%
        //方法1
            String score[] ={"10", "100", "soeda", "hayashi", "-20", "118", "END"};

            for (int i = 0; i < score.length; i++){
                out.println(score[i]);
            }
            out.print("<br>");
        %>

        <%@ page import="java.util.ArrayList"%>
        <%
        //方法2
          ArrayList<String> al =
              new ArrayList<>();

              al.add("10");
              al.add("100");
              al.add("soeda");
              al.add("hayashi");
              al.add("-20");
              al.add("118");
              al.add("END");

        for(String val:al){
            out.print(val + " ");
        }
        %>
    </body>
</html>
