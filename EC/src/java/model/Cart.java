/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.w3c.dom.Element;

/**
 *
 * @author SHO
 */
public class Cart {
    
    private Map<String, ItemDetails> itemList;
    //private ArrayList<ItemDetails> itemList;
    public Cart(){}
    public Cart getInstance(){
        return new Cart();
    }
    
    public void setItemInCart(ItemDetails item){
        itemList = new HashMap<String, ItemDetails>();
        String productID = item.getProductID();        
        itemList.put(productID, item);
    }
    
    public Map<String, ItemDetails> getItemInCart(){
        return this.itemList;
    }
    /*
    public HashMap<String, ItemDetails> deleteIteInCat(String productID){
        this.itemList.remove(productID);
        return this.itemList;
    }
    */
}
