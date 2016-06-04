/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author gest
 */
public class PictureDataDTO {
    
    private int pictureID;
    private String picturePath;
    private String pictureName;
    private String ownerComment;
    private int beautiful;
    private int cool;
    private int stylish;
    private int sum;
    private String userName;
    private int categoryID;
    private int userID;
    private Date submitDate;
    
    
    public PictureDataDTO(){}
    
    public void setPictureID(int pictureID){
        this.pictureID = pictureID;
    }
    public int getPictureID(){
        return this.pictureID;
    }
    
    public void setPicturePath(String path){
        this.picturePath = path;
    }
    public String getPicturePath(){
        return this.picturePath;
    }
    
    public void setPictureName(String name){
        this.pictureName = name;
    }
    public String getPictureName(){
        return this.pictureName;
    }
    
    public void setOwnerComment(String comment){
        this.ownerComment = comment;
    }
    public String getOwnerComment(){
        return this.ownerComment;
    }
    
    public void setBeautiful(int beautiful){
        this.beautiful = beautiful;
    }
    public int getBeautiful(){
        return this.beautiful;
    }
    
    public void setCool(int cool){
        this.cool = cool;
    }
    public int getCool(){
        return this.cool;
    }
    
    public void setStylish(int stylish){
        this.stylish = stylish;
    }
    public int getStylish(){
        return this.stylish;
    }
    
    public void setSum(int sum){
        this.sum = sum;
    }
    public int getSum(){
        return this.sum;
    }
    
    public void setCategoryID(int category){
        this.categoryID = category;
    }
    public int getCategoryID(){
        return this.categoryID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    
    public void setSubmitDate(Date dateTime){
        this.submitDate = dateTime;
    }
    public Date getSubmitDate(){
        return this.submitDate;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
}
