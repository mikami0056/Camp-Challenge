/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    window.onload = function(){
        var date = new Date();
            var time = date.getFullYear() + '年' + (date.getMonth()+1) + '月' + date.getDate() + '日';
            document.getElementById('date').textContent = time;
            
    };
    var workIn  = function(){
        var nowDate = new Date();
        window.alert(nowDate);
            $.ajax({
                type:"POST",
                url:"WorkController",
                data:{"param":nowDate.getTime(),"type":"in"},
                dataType:"json",
                success : function(json) {
                    document.getElementById('work_in').textContent = json;
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
                }
            });
    };
    var workOut = function(){
        var nowDate = new Date();
            $.ajax({
                type:"POST",
                url:"WorkController",
                data:{"param":nowDate.getTime(),"type":"out"},
                dataType:"json",
                success : function(json) {
                    document.getElementById('work_out').textContent = json;
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
                }
            });
    };
    
    var setworkHour = function(idname){
        var d = new Date();
        if(d.getHours() < 10){
            document.getElementById(idname).textContent = '0' + d.getHours();
        }else{
            document.getElementById(idname).textContent = d.getHours();
        }
    };
    var setworkMinutes = function(idname){
        var d = new Date();
        if(d.getMinutes() < 10){
            document.getElementById(idname).textContent = '0' + d.getMinutes();
        }else{
            document.getElementById(idname).textContent = d.getMinutes();
        }
    };

