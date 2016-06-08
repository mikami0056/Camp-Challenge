/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function submitcheck(submitbutton){
    document.regist.button.disabled = !submitbutton.checked;
}

function check(){
    var flag = 0;
    var caution = '以下の必須事項が未入力です\n';
    
    if(document.regist.username.value === ""){
        flag = 1; 
        caution += ' ユーザー名 ';
    }
    
    if(document.regist.password.value === ""){
        flag = 1;
        caution += ' パスワード ';
    }
    
    if(document.regist.mail.value === ""){
        flag = 1;
        caution += ' メールアドレス ';
    }
                
    if(flag){
        window.alert(caution);
        return false;
    }
                
    return true;
    
}

