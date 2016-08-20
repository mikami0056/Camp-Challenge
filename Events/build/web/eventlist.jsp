<%-- 
    Document   : eventlist
    Created on : 2016/08/20, 13:38:39
    Author     : gest
--%>

<%@page import="model.dto.EventsDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>イベント一覧</title>
    </head>
    <body>
        <h1>イベント一覧</h1>
        <%List<EventsDTO> eventList = (List<EventsDTO>)session.getAttribute("eventList");%>
        <table>
            <tr>
                <th>イベント名</th><th>開催日付</th><th>開催時刻</th><th>詳細</th><th>幹事名(今はID)</th><th>締切日</th>
            </tr>
        <%for(EventsDTO event : eventList){%>
            <tr>
                <td><a href="EventController?option=detail?eventName=<%=event.getEvent_name()%>?eventId=<%=event.getEvent_id()%>"><%=event.getEvent_name()%></a></td>
                <td>開催日付</td><td><%=event.getEvent_date()%></td>
                <td>開催時刻</td><td><%=event.getEvent_time()%></td>
                <td>開催場所</td><td><%=event.getEvent_place()%></td>
                <td>詳細</td><td><%=event.getEvent_detail()%></td>
                <td>幹事名(今はID)</td><td><%=event.getEmp_id()%></td>
                <td>締切日</td><td><%=event.getDeadline()%></td>
            </tr>
        <%}%>
        </table>
        <a href="EventController?option=menu">メニュー</a>
    </body>
</html>
