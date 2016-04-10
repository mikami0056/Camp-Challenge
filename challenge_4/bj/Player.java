/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bj;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SHO
 */
public class Player extends Human{
    
        //以下, Playerの情報
        private String name;
        private String mark;
        private int sum;
        private int t;
        private String d;
        private boolean type;
        private final String h = "hit";
        private ArrayList<Integer> tmp;
        
        //getter/setter 群
        public void setName(String name){
            this.name = name;
        }
        public void setName(){
            this.name = "名無し";
        }
        public String getName(){
            return this.name;
        }
        public String getMark(){
            return this.mark;
        }
        public int getSum(){
            return this.sum;
        }

    //Playreコンストラクタ   
    Player(){
        this.tmp = new ArrayList<>();
        this.mycards = new ArrayList<>();
        this.tmp = new ArrayList<>();
        this.mark = "player";
    }

    @Override
    public void setCards(ArrayList<Integer> cards) {
        this.mycards = cards;
        System.out.println(this.name + "さんの手持ちを開示します");
        for  (int i = 0; i < this.mycards.size(); i++){
            System.out.print("「" + this.mycards.get(i) + "」");
            
        }
        this.open();
    }
    
    @Override
    public void open() {
        if (this.sum < 21){
        this.sum = 0;
        for (int i = 0; i < this.mycards.size(); i++){
            if(this.mycards.get(i) == 1){
                System.out.println("エースを入手しました。このカードは11として扱うことも出来ます。");
                System.out.println("1又は11を入力して下さい。");
                t = new Scanner(System.in).nextInt();
                this.mycards.set(i, t);
            }
            this.sum = this.sum + this.mycards.get(i);
        } 
        } 
        System.out.println("カードの合計値は「" + sum + "」です。");
        
    }
    
    public boolean under21(){
        if (this.sum < 21){
        System.out.println("手持ちのカードの合計は21未満です。");
        System.out.println("カードを1枚引く場合は「hit」を入力して下さい。");
        System.out.println("引かない場合は「stand」を記入して下さい。");
        d = new Scanner(System.in).nextLine();
        }
        return this.call(d);
    }
    
    
    @Override
    public boolean checkSum() {
        boolean type = false;
        int i = this.sum;
        if (i <= 21){
            type = true;
        } else {
            type = false;
        }
        return type;
    }
    
    public boolean call(String t){
        boolean type;                                                           //boolean返信用
        if ("hit".equals(t)){
         System.out.println("hitします。ディーラーからカードをもらいます。");
         type = true;
        } else {
         System.out.println("standします。ディーラーのターンになります。");
         type = false;
        }
        return type;
    }


 
    
}
