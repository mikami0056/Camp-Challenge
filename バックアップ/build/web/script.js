/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function init(){
    Array.prototype.contains = function(value){
        var flg = false;
        for(var i in this){
            if(this[i] === value){
                flg = true;
            }
        }
        return flg;
    };
}
 
function doDragStart(event){
    event.dataTransfer.setData('text/plain', 'ドラッグされたテキスト!');
}
 
function doDragOver(event){
    var type = event.dataTransfer.types.contains("Files");
    if (type){
        event.preventDefault();
    }
}
 
function doDrop(event){
    var img = document.getElementById("img1");
    var file = event.dataTransfer.files[0];
    var reader = new FileReader();
    reader.onloadedn = function(){
        img.src = reader.result;
    };
    reader.readAsDataURL(file);
}

