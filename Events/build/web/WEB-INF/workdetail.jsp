<%-- 
    Document   : workdetail
    Created on : 2016/08/22, 22:25:02
    Author     : gest
--%>

<%@page import="model.dto.WorkStatusDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>勤怠情報編集</title>
    </head>
    <body>
        <%WorkStatusDTO dto = (WorkStatusDTO)session.getAttribute("dto");%>
        <h1>勤怠情報編集</h1>
        <table>
            <tr>
                <>
            </tr>
            <tr>
                <th>社員</th>
            </tr>
        </table>
    </body>
</html>
