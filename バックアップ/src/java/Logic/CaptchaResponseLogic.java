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
public class CaptchaResponseLogic {
    
    public boolean success;
    
    public CaptchaResponseLogic(){}
    
    public static CaptchaResponseLogic getInstance(){
        return new CaptchaResponseLogic();
    }
    
    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean isSuccess(){
        return success;
    }
    
}
