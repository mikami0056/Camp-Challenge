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
            String score[] ={"10", "100", "soeda", "hayashi", "-20", "118", "END"};
            
            for (int i = 0; i < score.length; i++){
                out.println(score[i]);
            }
        %>
    </body>
</html>
