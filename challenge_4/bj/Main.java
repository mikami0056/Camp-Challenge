/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bj;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author SHO
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
    System.out.println("プレーヤーの名前を入力して下さい");
    String name = new Scanner(System.in).nextLine();
    
    
    Player p = new Player();                                                    //プレーヤーインスタンスを生成
    Dealer d = new Dealer();                                                    //ディーラーインスタンスを生成
    Gameover g = new Gameover();                                                
    Sleep s = new Sleep();
    boolean plyjudge;                                                           //プレーヤー用手持ち判断変数
    boolean dlrjudge;                                                           //ディーラー用手持ち判断用変数
    
    if (name.length() == 0){                                                    //名前が入力されなかった場合, 「名無しさん」となる
        p.setName();
    } else {
        p.setName(name);
    }
    
    System.out.println("こんにちは!「" + p.getName() + "」さん。");
    System.out.println("<<ゲームの準備>>");
    s.loading();
    
    //以下, 手札の配布と保存
    ArrayList<Integer> deal;                                                    //ディーラー用配列
    ArrayList<Integer> play;                                                    //プレーヤー用配列
    
    deal = d.deal(d.getMark());                                                 //ディーラーメソッドで生成されたディーラーの手札を保存
    s.loading();
    play = d.deal(p.getMark());                                                 //ディーラーメソッドで生成されたプレーヤーの手札を保存
    //s.loading();
    System.out.println("");
    
    d.setCards(deal);                                                           //ディーラーの手札をsetCardsメソッドを使ってd.mycardsに保存
    //s.loading();
    p.setCards(play);                                                           //プレーヤーの手札をsetCardsメソッドを使ってp.mycardsに保存
    
    //以下, ゲーム開始
    System.out.println("<<ゲーム開始>>");
    System.out.println("<<プレーヤーのターン>>");
    System.out.println("");
    
    if (p.getSum() < 21){                                                       //プレーヤーの手持ちが21未満
        while(p.getSum() <= 21 && p.under21()){                                 //プレーヤーがhitし, かつ手持ちが21以下
        play = d.hit(p.getMark());
        p.setCards(play);
        s.loading();
        }
    } 
    //plyjudge = g.sumJudge(p.getSum(), p.getMark());                           
    plyjudge = p.checkSum();                                                    //プレーヤーの合計値確認
    if(plyjudge && p.getSum() == 21){                                           //プレーヤーの合計値がブラックジャックの場合
        System.out.println("ブラックジャック成功です!!!");
        System.out.println(p.getName() + "さんの勝利です!!!");
        
    } else if (plyjudge == false){                                              //プレーヤーの合計値が22以上
        System.out.println(p.getName() + "さんはバーストしました.....");
        System.out.println("ディーラーの勝利です.....");
        
    } else {                                                                    //プレーヤーの合計値が21未満
        
        s.loading();                                        
        System.out.println("<<ディーラーのターン>>");
        s.loading();
        deal = d.hit(d.getMark());                                              //ディーラーは16以下ならhitし, 17以上ならstand
        d.setCards(deal);
        System.out.println("<<ディーラーのターン終了>>");
        dlrjudge = d.checkSum();                                                //ディーラーの合計値確認
        s.loading();
        
        if(dlrjudge && d.getSum() == 21){
            System.out.println("ディーラーにブラックジャック成功されました.....");
            System.out.println("ディーラーの勝利です.....");
            
        } else if (dlrjudge == false){
            System.out.println("ディーラーはバーストしました!!!!!");
            System.out.println(p.getName() + "さんの勝利です!!!!!");
            
        } else {                                                                //プレーヤー, ディーラー共に21未満
            
            s.loading();
            System.out.println("勝負に入ります");
            s.loading();
            if (plyjudge && dlrjudge){                                          //両者とも21未満である
                if (p.getSum() > d.getSum()){
                    System.out.println(p.getName() + "さんの勝利です!!!");
                    
                } else if (p.getSum() < d.getSum()){
                    System.out.println("ディーラーの勝利です.....");
                    
                } else if (p.getSum() == d.getSum()){
                    System.out.println("引き分けです。");
                    
                }
            }
        }   
    }
            s.loading();
            System.out.println("<<最終結果>>");
            System.out.println("プレーヤー：" + p.getSum());
            System.out.println("ディーラー：" + d.getSum()); 
            System.out.println("ディーラーの手札を開示します");
            for (int i = 0; i < d.mycards.size(); i++){
            System.out.print("「" + d.mycards.get(i) + "」");
            }
    }
}