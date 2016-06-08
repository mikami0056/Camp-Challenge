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
public class CountDataDTO {
    
    int userID;
    int pictureID;
    int beautiful;
    int cool;
    int stylish;
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    
    public void setPictureID(int pictureID){
        this.pictureID = pictureID;
    }
    public int getPictureID(){
        return this.pictureID;
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
}
