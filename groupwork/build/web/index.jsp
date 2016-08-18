<%-- 
    Document   : index
    Created on : 2016/08/16, 20:00:14
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <span id="date"></span>
        <p><button id="begin">出勤</button><span id="begindate">${testman.toJSPBeginTime}</span></p>
        <p><button id="end">退勤</button><span id="enddate">${testman.toJSPEndTime}</span></p>
        <a href="EventList">イベント登録</a>
    </body>
    <script>
        window.onload = function(){
            var dd = new Date();
            var time = dd.getFullYear() + '年' + (dd.getMonth()+1) + '月' + dd.getDate() + '日';
            document.getElementById('date').textContent = time;
        }
        document.getElementById('begin').onclick = function(){
            var nowDate = new Date();
            $.ajax({
                type:"POST",
                url:"Test",
                data:{"param":nowDate.getTime(),"type":"begin"},
                dataType:"json",
                success : function(json) {
                    document.getElementById('begindate').textContent = json;
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
                }
            });
        }
        document.getElementById('end').onclick = function(){
            var nowDate = new Date();
            $.ajax({
                type:"POST",
                url:"Test",
                data:{"param":nowDate.getTime(),"type":"end"},
                dataType:"json",
                success : function(json) {
                    document.getElementById('enddate').textContent = json;
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
                }
            });
        }
    </script>
</html>
