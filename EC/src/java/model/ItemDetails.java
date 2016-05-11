/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
/**
 *
 * @author SHO
 */
public class ItemDetails implements Serializable {
    private String index;
    private String productID;
    private String name;
    private Integer price;
    private String imgUrl;
    private String stock;
    private Integer number;
    
    public ItemDetails(){
        this.number = 0;
    }
    
    public static ItemDetails getInstance(){
        return new ItemDetails();
    }
    
    public void setIndex(String index){
        this.index = index;
    }
    public String getIndex(){
        return this.index;
    }
    
    public void setProductID(String productID){
        this.productID = productID;
    }
    public String getProductID(){
        return this.productID;
    }
    
    public void setNumber(Integer n){
        this.number += n;
    }
    public Integer getNumber(){
        return this.number;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Integer getPrice(){
        return this.price;
    }
    
    public String getImgUrl(){
        return this.imgUrl;
    }
    
    public String getStock(){
        return this.stock;
    }
    /*
    public void setDetails(Map<String, Element> item){
        
        for(String key : item.keySet()){
            switch(key){
                
                case "ProductID":
                Element productID = item.get(key);
                this.productID = productID.getTextContent();
                break;
                
                case "Name":
                Element name = item.get(key);
                this.name = name.getTextContent();
                break;
                
                case "Price":
                Element price = item.get(key);
                this.price = price.getTextContent();
                break;
                
                case "Medium":
                Element imgUrl = item.get(key);
                this.imgUrl = imgUrl.getTextContent();
                break;
                
                case "Stock":
                Element stock = item.get(key);
                this.stock = stock.getTextContent();
                break;
            }
        }
        
    }
    */
    public void setPropaty(String elName, Element el){
        switch(elName){
                
            case "ProductID":
            this.productID = el.getTextContent();
            break;
                
            case "Name":
            this.name = el.getTextContent();
            break;
                
            case "Price":
            this.price = Integer.parseInt(el.getTextContent());
            break;
                
            case "Medium":
            this.imgUrl = el.getTextContent();
            break;
                
            case "Stock":
            this.stock = el.getTextContent();
            break;
        }
    }
}
