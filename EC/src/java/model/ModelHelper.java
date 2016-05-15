/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author SHO
 */
public class ModelHelper {
    
    private final static String appID = "dj0zaiZpPXplbVJNd3J4UXR4WCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjI-";
    private final static String baseURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    private final String Login = "Login";
    private final String index = "index.jsp";
    private final String MyData = "MyData";
    private String place;
    public ModelHelper(){}
    
    public static ModelHelper getInstance(){
        return new ModelHelper();
    }
    
    public String loginJumper(){
        return "<a href=\"" + Login + "\">ログイン(新規登録)</a> ";
    }
    public String loginJumper(String title){
        return "<a href=\"" + Login + "\">"+ title +"</a> ";
    }
    
    public String indexJumper(){
        return "<a href=\"" + index + "\">トップ</a> ";
    }
    
    public String userPageJumper(String userName){
        return "こんにちは, <a href = \"" + MyData + "\">" + userName + "</a>さん<br>";
    }
    
    public boolean existAccount(UserDataBeans loginAccount){
        boolean exist = false;
        if(loginAccount != null){
        exist = true;
        }
        return exist;
    }
    
    public String getUserID(UserDataBeans loginAccount){
        String userID="";
        if(loginAccount != null){
        userID = loginAccount.getName(); 
        } else {
        userID = "defaultID";
        }
        return userID;
    }
    
    public String cartJumper(){
        return "<a href=\"Cart\">買い物かご</a><br>";
    }
    
    public String stockStatus(String stock){
        String status = "";
        switch(stock){
                case "instock":
                status = "在庫あり";
                break;
                
                case "outofstock":
                status = "在庫切れ";
                break;
        }
        return status;
    }
    
    public String caution(String userName, String passWord, String mail, String address){
        String caution = "";
        if("".equals(userName)){
            caution += "[名前]";
        }
        if("".equals(passWord)){
            caution += "[パスワード]";
        }
        if("".equals(mail)){
            caution += "[メール]";
        }
        if("".equals(address)){
            caution += "[住所]";
        }
        return caution;
    }
}
