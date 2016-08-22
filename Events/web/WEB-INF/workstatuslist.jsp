<%-- 
    Document   : workstatuslist
    Created on : 2016/08/22, 5:17:01
    Author     : gest
--%>

<%@page import="java.util.Map"%>
<%@page import="model.dto.EmployeesDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.dto.WorkStatusDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>勤怠情報一覧</title>
    </head>
    <body>
        <h1>勤怠情報一覧</h1>
        <%EmployeesDTO employee = (EmployeesDTO)session.getAttribute("employee");%>
        <%Map<Integer,WorkStatusDTO> workStatusList = (Map<Integer,WorkStatusDTO>)session.getAttribute("workStatusList");%>
        <%=employee.getEmp_name()%>さんの勤怠情報
        <table>
            <tr>
                <th>年月日</th><th>出勤時刻</th><th>退勤時刻</th><th>休憩時間</th><th>勤務時間</th><th>状況</th><th>編集</th>
            </tr>
            <%for(Integer statusKey : workStatusList.keySet()){%>
            <%WorkStatusDTO workStatus = workStatusList.get(statusKey);%>
            <tr>
                <td><%=workStatus.getWork_date()%></td>
                <td><%=workStatus.getWork_in()%></td>
                <td><%=workStatus.getWork_out()%></td>
                <td><%=workStatus.getRest_time_str()%></td>
                <td><%=workStatus.getWork_time_str()%></td>
                <td><%=workStatus.getStatus()%></td>
                <form action="WorkController?option=edit" method="post">
                    <input type="submit" value="編集">
                    <input type="hidden" name="statusKey" value="<%=statusKey%>">
                </form>
            </tr>
        <%}%>
        </table>
    </body>
</html>
