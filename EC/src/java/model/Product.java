/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author SHO
 */
public class Product implements Serializable{
   private String name;
   private String url;
    
   public Product(){}
   public static Product getInstance(){
       return new Product();
   }
   
   
   
}
