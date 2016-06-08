/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function countBeautiful(pictureID){
    $.ajax({
        type : "POST",
        url : "/WorkSpacesProto/PictureDetail",
        data : {"param":"beautiful", "pictureID":pictureID},
        dataType : "json",
        success : function(json) {
            document.getElementById('beautiful').textContent = json;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
        }
    });
}
            
function countCool(pictureID){
    $.ajax({
        type : "POST",
        url : "/WorkSpacesProto/PictureDetail",
        data : {"param":"cool", "pictureID":pictureID},
        dataType : "json",
        success : function(json) {
            document.getElementById('cool').textContent = json;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
        }
    });
}
            
function countStylish(pictureID){
    $.ajax({
        type : "POST",
        url : "/WorkSpacesProto/PictureDetail",
        data : {"param":"stylish", "pictureID":pictureID},
        dataType : "json",
        success : function(json) {
            document.getElementById('stylish').textContent = json;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("エラーが発生しました：" + textStatus + ":\n" + errorThrown);
        }
    });
}
