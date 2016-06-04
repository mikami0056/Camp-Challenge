/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.getElementById("file").addEventListener("change", function(){
    try{
    var fileList = this.files;
    
    document.getElementById("output").innerHTML="";
    
    for(var i=0, I=fileList.length; I>i; i++){
        var blobUrl = window.URL.createObjectURL(fileList[i]);
        
        document.getElementById("output").innerHTML += '<a href="' + blobUrl+ '" target="_blank"><img src="'+blobUrl+'">';
    }   
        errorElement.className = "error none";
    }catch(msg){
        errorElement.className = "error" ;
        errorElement.textContent = msg ;
        console.error( msg ) ;
    }
    
});

var errorElement = document.getElementById("error");

document.getElementById("reset").addEventListener("click",function(){
    initialize();
});

function initialize(){
    document.getElementById( "file" ).value = "" ;
    document.getElementById( "output" ).innerHTML = "" ;
}
