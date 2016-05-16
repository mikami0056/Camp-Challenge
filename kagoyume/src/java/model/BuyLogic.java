/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;

/**
 *
 * @author SHO
 */
public class BuyLogic {
    
    //コンストラクタ
    public BuyLogic(){}
    
    //インスタンス取得メソッド
    public static BuyLogic getInstance(){
        return new BuyLogic();
    }
    
    public void searchAndAdd(Set<ItemDataBeans> items, Set<ItemDataBeans> itemsBoughtByUser, UserDataBeans loginAccount, String productID){
        for(ItemDataBeans item : items){
            if(item.getProductID().equals(productID)){
                itemsBoughtByUser.add(item);
                loginAccount.setSum(item.getNumber() * item.getPrice());
                items.remove(item);
                break;
            }
        }
    }
}
