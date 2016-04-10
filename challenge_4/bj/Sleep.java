/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bj;

/**
 *
 * @author SHO
 */
public class Sleep {
    Sleep() throws InterruptedException{
        
    }
    public void loading() throws InterruptedException{
        System.out.print("Now Loading");
        for(int i = 0; i < 3; i++){
        System.out.print(".");
        Thread.sleep(800);
        }
        System.out.println("");
        System.out.println("");
    }
}
