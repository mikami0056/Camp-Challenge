/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author SHO
 */
public class ModelHelper {
    
    private final static String appID = "dj0zaiZpPXplbVJNd3J4UXR4WCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjI-";
    private final static String baseURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    private final String Login = "Login";
    private final String index = "index.jsp";
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
    
}
