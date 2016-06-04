/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author gest
 */
public class UserDataBeans implements Serializable{
    
    private int userID;
    private String userName;
    private String passWord;
    private String mail;
    private int questionID;
    private String answer; 
    private int pictureSum;
    
    public UserDataBeans(){}

    public UserDataBeans(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public UserDataBeans(String userName, String passWord, String mail, int questionID, String answer){
        this.userName = userName;
        this.passWord = passWord;
        this.mail = mail;
        this.questionID = questionID;
        this.answer = answer;
    }
    
    //ユーザーID
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    
    //ユーザー名
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    
    //パスワード
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }
    
    //メールアドレス
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return this.mail;
    }
    
    //秘密の質問
    public void setQuestionID(int questionID){
        this.questionID = questionID;
    }
    public int getQuestionID(){
        return this.questionID;
    }
    
    //質問の回答
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }
    
    //写真合計
    public void setPictureSum(int pictureSum){
        this.pictureSum = pictureSum;
    }
    public int getPictureSum(){
        return this.pictureSum;
    }
    
    /*
    @ユーザー情報をDTOに受け渡すメソッド.
    @新規登録時に使用されることを想定しています.
    */
    public void UDB2DTOMapping(UserDataDTO dto){
        dto.setUserID(this.userID);
        dto.setUserName(this.userName);
        dto.setPassWord(this.passWord);
        dto.setMail(this.mail);
        dto.setQuestionID(this.questionID);
        dto.setAnswer(this.answer);
    }
    
    /*
    @DB内の情報をUDBに受け渡すメソッド.
    @
    */
    public void DTO2UDBMapping(UserDataDTO dto){
        this.userID = dto.getUserID();
        this.userName = dto.getUserName();
        this.passWord = dto.getPassWord();
        this.mail = dto.getMail();
    }
    
    /*
    @ユーザー名, パスワード, メールアドレスを新しく格納するメソッド.
    @主にユーザー情報更新時に使用
    */
    public void setProperties(String userName, String passWord, String mail){
        this.userName = userName;
        this.passWord = passWord;
        this.mail = mail;
    }
    
    @Override
    public String toString(){
        return "ユーザー名：" + this.userName + "/メール：" + this.mail;
    }
    
    @Override
    public boolean equals(Object o){
        boolean judge = false;
        if(o == this){ judge = true; }
        if(o == null){ return judge; }
        if(!(o instanceof UserDataBeans)){return judge;}
        UserDataBeans udb = (UserDataBeans)o;
        if(this.userID == udb.getUserID()){judge = true;}
        return judge;
    }
    
    @Override
    public int hashCode(){
        int result = 37;
        result = result * 31 + userName.hashCode() + passWord.hashCode();
        return result;
    }
}
