/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author SHO
 */
public class RegisteredUser implements Serializable {
    
    private String name;
    private String year;
    private String month;
    private String day;
    private String type;
    private String tell;
    private String comment;
    private String caution = "";
    private boolean check = true;
    
    public RegisteredUser(){   
    }
  
    //名前のgetter/setter
    public void setName(String name){
        this.name = name;
        if("".equals(name) || name.trim().length() == 0){
            this.check = false;
            this.caution = "・名前<br>";
        } 
    }
    public String getName(){
        return this.name;
    }
    
    //年のgetter/setter
    public void setYear(String year){
        this.year = year;
        if("".equals(year)){
            this.check = false;
            this.caution += "・年<br>";
        } 
    }
    public String getYear(){
        return this.year;
    }
    
    //月のgetter/setter
    public void setMonth(String month){
        this.month = month;
        if("".equals(month)){
            this.check = false;
            this.caution += "・月<br>";
        }
    }
    public String getMonth(){
        return this.month;
    }
    
    //日のgetter/setter
    public void setDay(String day){
        this.day = day;
        if("".equals(day)){
            this.check = false;
            this.caution +="・日<br>";
        } 
    }
    public String getDay(){
        return this.day;
    }
    
    public long getBirthday(){
        int y = Integer.parseInt(this.year);
        int m = Integer.parseInt(this.month) - 1; //カレンダークラスに格納するため
        int d = Integer.parseInt(this.day);
        Calendar cbirth = Calendar.getInstance();
        cbirth.set(y,m,d);
        Date birthday = cbirth.getTime();
        return birthday.getTime();
    }
    
    //職種のgetter/setter
    public void setType(String type){
        this.type = type;
        if(type == null){
            this.check = false;
            this.caution +="・職種<br>";
        }
    }
    public String getType(){
        return this.type;
    }
    
    //電話番号のgetter/setter
    public void setTell(String tell){
        this.tell = tell;
        if("".equals(tell) || tell.trim().length() == 0){
            this.check = false;
            this.caution +="・電話番号<br>";
        } 
    }
    public String getTell(){
        return this.tell;
    }
    
    //コメントのgetter/setter
    public void setComment(String comment){
        this.comment = comment;
        if("".equals(comment) || comment.trim().length() == 0){
            this.check = false;
            this.caution += "・自己紹介<br>";
        }
    }
    public String getComment(){
        return this.comment;
    }
    public void setCaution(String caution){
       this.caution = caution;
    }
    public String getCaution(){
        return this.caution;
    }
    
    public void setCheck(boolean check){
        this.check = check;
    }
    public boolean isCheck(){
        return this.check;
    }
}
