/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bj;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author SHO
 */
public class Dealer extends Human{
    Integer numbers = 1;    //カード用の変数
    int r;              //乱数用
    private ArrayList<Integer> cards;   //デッキ用の配列
    private ArrayList<Integer> dlr;     //ディーラー用配列
    private ArrayList<Integer> ply;     //プレイヤー用配列
    
    boolean type;
    private int sum;
    private String mark;
    
    public String getMark(){
        return this.mark;
    }
    public int getSum(){
        return this.sum;
    }
    
    Dealer(){              
        this.cards = new ArrayList<>();
        this.dlr = new ArrayList<>();
        this.mycards = new ArrayList<>();
        this.ply = new ArrayList<>();
        this.mark = "dealer";
         
        while(this.numbers < 11){                                               //山札に1〜10までのカードをセット
            this.cards.add(this.numbers);
            this.numbers++;
        }
    }
    
    public ArrayList<Integer> deal(String mark){
        ArrayList<Integer> reply = new ArrayList<>();                             //配列をmainメソッド返信用
        if ("dealer".equals(mark)){
            System.out.println("ディーラーが自身に手札を渡しました。");
            for(int i = 0; i < 2; i++){
            this.r = new Random().nextInt(10);                                  //配列の添字(0〜9)を生成
            this.dlr.add(this.cards.get(this.r));                               //山札よりカードをディーラーの配列に追加
            reply = this.dlr;                                                   //mainメソッドに返信
            } 
        } else if ("player".equals(mark)){
            System.out.println("ディーラーがプレーヤーに手札を渡しました。");
            for(int i = 0; i < 2; i++){
            this.r = new Random().nextInt(10);                                  //配列の添字(0〜9)を生成
            this.ply.add(this.cards.get(this.r));                               //山札よりカードをプレーヤーの配列に追加
            reply = this.ply;                                                   //mainメソッドに返信
            }                                   
        }
        return reply;                                                           //備忘録：reply配列はローカル配列のため, 初期化する必要はありません。
    }
    
    public ArrayList<Integer> hit(String mark){
        ArrayList<Integer> reply = new ArrayList<Integer>();
        switch(mark){
            case "dealer":
            if (this.sum <= 16){
                for (int i = 2; this.sum <= 17; i++){
                System.out.println("カードを1枚引きます。");
                this.r = new Random().nextInt(10);  //配列の添字(0〜9)を生成
                //System.out.println(this.cards.get(r));
                    if (this.r == 0){
                        this.dlr.add(11);
                        this.sum = this.sum + 11;
                        //System.out.println("確認A" + this.sum);
                    } else {
                        this.dlr.add(this.cards.get(this.r)); 
                        this.sum = this.sum + this.dlr.get(i);
                        //System.out.println("確認B" + this.sum);
                    }
                }
                reply = this.dlr;
            } else {
                System.out.println("ディーラーはstandしました");
                reply = this.mycards;
            }
            break;
            
            case "player":
                this.r = new Random().nextInt(10);  //配列の添字(0〜9)を生成
                this.ply.add(this.cards.get(this.r));
                System.out.println("もらったカードは" + this.cards.get(this.r) + "です。");
                reply = this.ply; 
            break;
        }
        return reply;
    }
 
    @Override
    public void setCards(ArrayList<Integer> cards) {
        this.mycards = cards;
        this.sum = 0;
        System.out.println("ディーラーの手持ちの1枚を開示します。");
        System.out.println("「" + this.mycards.get(0) + "」");
            for (int i = 0; i < this.mycards.size(); i++){
            this.sum = this.sum + this.mycards.get(i);
            } 
        this.open();
    }
    
    @Override
    public void open() {
        for (int i = 0; i < this.mycards.size(); i++){
            if(this.mycards.get(i) == 1 || this.sum == 2){
            this.mycards.set(i, 11);
            this.sum = this.sum + 10;
            }
        } 
        //System.out.println("ディーラーの合計" + this.sum);
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


}
