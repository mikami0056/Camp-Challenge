/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bj;

/**
 *
 * @author SHO
 */
public class Gameover {
    Gameover(){
    }
    
    public boolean sumJudge(int i, String j){
        boolean type = true;                                                    //初期化用
        if (i <= 21){
            switch(j){
            case "player":
            type = true;
            break;
                
            case "dealer":
            type = true;
            break;   
            }
            
        } else if (i > 21){
            switch(j){
            case "player":
            type = false;
            break;
                
            case "dealer":
            type = false;
            break;   
            }
        }
        return type;
    }
}
