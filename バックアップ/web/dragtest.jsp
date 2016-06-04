<%-- 
    Document   : dragtest
    Created on : 2016/05/29, 11:18:38
    Author     : gest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dragtest</title>
        <style>
        div.draggable{
            width: 100px; height: 50px;
        }
        div.droppable{
            width: 200px; height: 100px;
        }
        </style>
        <script src="script.js">
        </script>
    </head>
    <body>
        <h1>Drag & Drop Test</h1>
        <p id = "msg"></p>
        <div draggable="true" class="draggable" style="background-color:red">
            ドラッグ出来ます
        </div>
        <hr>
        <!--
        <div ondragover="doDragOver(event);" ondrop="doDrop(event);" class="droppable" style="background-color:blue">
        ここにドロップ！
        </div>
        -->
        <img id="img1" ondragover="doDragOver(event);" ondrop="doDrop(event);" class="droppable">
    </body>
</html>
