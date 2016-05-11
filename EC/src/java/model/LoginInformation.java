/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SHO
 */
public class LoginInformation {
    private String userName;
    private String passWord;
    
    public LoginInformation(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public String getUserName(){
        return this.userName;
    }
    public String getPassWord(){
        return this.passWord;
    }
}
