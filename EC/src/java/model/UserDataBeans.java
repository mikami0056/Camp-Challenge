/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author SHO
 */
public class UserDataBeans implements Serializable{
    private String name;
    private String passWord;
    private String mail;
    private String address;
    
    public UserDataBeans(){
        this.name = "";
        this.passWord = "";
        this.mail = "";
        this.address= "";
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
    
    public void UDB2DTOMapping(UserDataDTO dto){
        dto.setName(this.name);
        dto.setPassWord(this.passWord);
        dto.setMail(this.mail);
        dto.setAddress(this.address);
    }
    
    public void DTO2DBMapping(UserDataDTO dto){
        this.name = dto.getName();
        this.passWord = dto.getPassWord();
        this.mail = dto.getMail();
        this.address = dto.getAddress();
    }
    
}
