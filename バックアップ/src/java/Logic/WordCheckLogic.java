/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author gest
 */
public class WordCheckLogic {

    public WordCheckLogic(){}
    public static WordCheckLogic getInstance(){
        return new WordCheckLogic();
    }
    
    public boolean parameterCheck(Object ox, Object oy){
        boolean check = false;
        if(ox != null && ox instanceof String){
            String x = (String)ox;
            if("".equals(x)){
                return check;
            }
            
        }else{
            return check;
        }
        
        if(oy != null && oy instanceof String){
            String y = (String)oy;
            if("".equals(y)){
                return check;
            }
            
        }else{
            return check;
        }
        
        check = true;
        return check;
    }
}
