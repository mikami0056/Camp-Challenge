<%-- 
    Document   : eventjoin
    Created on : 2016/08/20, 14:42:59
    Author     : gest
--%>

<%@page import="java.util.List"%>
<%@page import="model.dto.EventsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>イベント詳細</title>
    </head>
    <body>
        <%EventsDTO event         = (EventsDTO)session.getAttribute("event");%>
        <%List<Integer> empIdList = (List<Integer>)session.getAttribute("empIdList");%>
        <%Boolean isResult        = (Boolean)session.getAttribute("isReuslt");%>
        <%if(isResult == null){isResult = false;}%>
        <h1>イベント詳細</h1>
        <table>
            <tr>
                <th>イベント名</th><th>開催日付</th><th>開催時刻</th><th>詳細</th><th>幹事名(今はID)</th><th>締切日</th>
            </tr>
            <tr>
                <td><%=event.getEvent_name()%></td>
                <td><%=event.getEvent_date()%></td>
                <td><%=event.getEvent_time()%></td>
                <td><%=event.getEvent_place()%></td>
                <td><%=event.getEvent_detail()%></td>
                <td><%=event.getEmp_id()%></td>
                <td><%=event.getDeadline()%></td>
            </tr>
        </table>
        <form action="EventController" method="post">
        <input type="submit" value="参加する">
        <input type="hidden" name="option" value="join">
        <input type="hidden" name="empId"  value="<%=event.getEmp_id()%>">
        <input type="hidden" name="eventId"  value="<%=event.getEvent_id()%>">
        </form>
        <table>
        <tr colspan="5" align="center">
            <th>参加社員一覧(参加人数:<%=empIdList.size()%>人)</th>
        </tr>
        <tr>
        <%for(int i = 0;i<empIdList.size();i++){%>
            <td align="center"><%=empIdList.get(i)%></td>
            <%if((i+1) % 5 == 0){%>
            </tr>
            <tr>
            <%}%>
        <%}%>
        </tr>
        </table>
        <script>
        if(<%=isResult%>){
            window.alert('参加登録が完了しました');
        }else{
            window.alert('登録は完了済みです');
        }
    </script>
    </body>
</html>
