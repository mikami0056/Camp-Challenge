/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gest
 */
public class UserDataDTO {
    
    private int userID;
    private String userName;
    private String passWord;
    private String mail;
    private int questionID;
    private String answer;
    
    public UserDataDTO(){}
    public UserDataDTO(int userID, String userName, String passWord, String mail, int questionID, String answer){
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.mail = mail;
        this.questionID = questionID;
        this.answer = answer;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return this.mail;
    }
    
    public void setQuestionID(int questionID){
        this.questionID = questionID;
    }
    public int getQuestionID(){
        return this.questionID;
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }
}
