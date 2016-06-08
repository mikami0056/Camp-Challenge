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
public class CountDataBeans implements Serializable {
    //各フィールド
    int beautiful;
    int cool;
    int stylish;
    int userID;
    int pictureID;
    
    public CountDataBeans(){}
    
    public CountDataBeans(int userID, int pictureID){
        this.userID = userID;
        this.pictureID = pictureID;
        this.beautiful = 0;
        this.cool = 0;
        this.stylish = 0;
    }
    
    public CountDataBeans(int userID, int pictureID, int beautiful, int cool, int stylish){
        this.beautiful = beautiful;
        this.cool = cool;
        this.stylish = stylish;
        this.userID = userID;
        this.pictureID = pictureID;
    }
    
    public static CountDataBeans  getInstance(int userID, int pictureID, int beautiful, int cool, int stylish){
        return new CountDataBeans(userID, pictureID, beautiful, cool, stylish);
    }
    
    public void CDB2CDDMapping(CountDataDTO dto){
        dto.setUserID(this.userID);
        dto.setPictureID(this.pictureID);
        dto.setBeautiful(this.beautiful);
        dto.setCool(this.cool);
        dto.setStylish(this.stylish);
    }
    
    public void CDD2CDBMapping(CountDataDTO dto){
        this.userID = dto.getUserID();
        this.pictureID = dto.getPictureID();
        this.beautiful = dto.getBeautiful();
        this.cool = dto.getCool();
        this.stylish = dto.getStylish();
    }
    
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
