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
public class UserDataDTO {
    private String name;
    private String passWord;
    private String mail;
    private String address;
    
    public UserDataDTO(){
        this.name = "";
        this.passWord = "";
        this.mail = "";
        this.address= "";
    }
    public UserDataDTO(String userName, String passWord, String mail, String address){
        this.name = userName;
        this.passWord = passWord;
        this.mail = mail;
        this.address = address;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String userName){
        this.name = userName;
    }
    
    public String getPassWord(){
        return this.passWord;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    
    public String getMail(){
        return this.mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
