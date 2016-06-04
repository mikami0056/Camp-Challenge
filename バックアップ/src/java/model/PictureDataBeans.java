/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gest
 */
public class PictureDataBeans implements Serializable{
    
    private int pictureID;
    private String path;
    private String name;
    private String comment;
    private String userName;
    private int category;
    private int beautiful;
    private int cool;
    private int stylish;
    private int sum;
    private Date dateTime;
    
    public PictureDataBeans(){}
    
    public PictureDataBeans(String name, String path, String comment, int category, String userName){
        this.name = name;
        this.path = path;
        this.comment = comment;
        this.category = category;
        this.beautiful = 0;
        this.cool = 0;
        this.stylish = 0;
        this.userName = userName;
    }
    
    public void setPictureID(int pictureID){
        this.pictureID = pictureID;
    }
    public int getPictureID(){
        return this.pictureID;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return this.comment;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    
    public void setCategory(int category){
        this.category = category;
    }
    public int getCategory(){
        return this.category;
    }
    
    public void setBeautiful(int beautiful){
        this.beautiful += beautiful;
    }
    public int getBeautiful(){
        return this.beautiful;
    }
    
    public void setCool(int cool){
        this.cool += cool;
    }
    public int getCool(){
        return this.cool;
    }
    
    public void setStylish(int stylish){
        this.stylish += stylish;
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
    
    public void setDateTime(Date dateTime){
        this.dateTime = dateTime;
    }
    public Date getDateTime(){
        return this.dateTime;
    }
    
    public void calculationSum(){
        this.sum = this.beautiful + this.cool + this.stylish;
    }
    
    public void PDB2DTOMapping(PictureDataDTO dto, int userID){
        dto.setPictureID(this.pictureID);
        dto.setPicturePath(this.path);
        dto.setPictureName(this.name);
        dto.setPicturePath(this.path);
        dto.setBeautiful(this.beautiful);
        dto.setCool(this.cool);
        dto.setStylish(this.stylish);
        dto.setSum(this.sum);
        dto.setOwnerComment(this.comment);
        dto.setCategoryID(this.category);
        dto.setUserID(userID);
        dto.setUserName(this.userName);
    }
    
    public void DTO2PDBMapping(PictureDataDTO dto){
        this.pictureID =dto.getPictureID();
        this.name = dto.getPictureName();
        this.path = dto.getPicturePath();
        this.comment = dto.getOwnerComment();
        this.category = dto.getCategoryID();
        this.dateTime = dto.getSubmitDate();
        this.userName = dto.getUserName();
    }
    
    //データベースからの評価取得用
    public void setValues(Map<String, Integer> values){
        for(String categoryKey : values.keySet()){
            switch(categoryKey){
                case "beautiful":
                this.beautiful = values.get(categoryKey);
                break;
                
                case "cool":
                this.cool = values.get(categoryKey);
                break;
                
                case "stylish":
                this.stylish = values.get(categoryKey);
                break;
            }
        }
    }
    
    public Map<String, Integer> getValues(){
        Map<String, Integer> values = new HashMap<>();
        values.put("beautiful", this.beautiful);
        values.put("cool", this.cool);
        values.put("stylish", this.stylish);
        return values;
    }
    
    public void reInputName4Path(String name){
        System.out.println("reInputeName1" + this.path);
        this.path = this.path.replaceAll(this.name, name);
        System.out.println("reInputeName2" + this.path);
    }
    
    @Override
    public String toString(){
        return "ユーザー名：" + this.name + "/メール：" + this.path;
    }
    
    @Override
    public boolean equals(Object o){
        boolean judge = false;
        if(o == this){ judge = true; }
        if(o == null){ return judge; }
        if(!(o instanceof PictureDataBeans)){return judge;}
        PictureDataBeans pdb = (PictureDataBeans)o;
        if(this.pictureID == pdb.getPictureID()){judge = true;}
        return judge;
    }
    
    @Override
    public int hashCode(){
        int result = 37;
        result = result * 31 + this.name.hashCode();
        if(result < 0){
            result *= (-1);
        }
        return result;
    }
    
}
