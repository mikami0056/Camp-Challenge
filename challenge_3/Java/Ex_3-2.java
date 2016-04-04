public class Main{
  public static void main(String[] args){                 //変数を生成するメソッド
    int v = new java.util.Random().nextInt(10) + 1;       //１〜10までの変数を生成
    System.out.println(v);                                //生成された変数を表示
    oddeven(v);                                           //偶数奇数判定メソッドに変数を渡す
  }

  public static void oddeven(int v){                      //偶数奇数判定メソッド
    int rem = v % 2;                                      //計算結果を余り(rem)に代入
      String even = "偶数";
      String odd = "奇数";

    switch (rem){
      case 0:
      System.out.println("これは" + even + "です。");
      break;

      case 1:
      System.out.println("これは" + odd + "です。");
      break;
    }

      if (rem == 0){
        System.out.println(even);
      } else if (rem != 0){
        System.out.println(odd);
      }
    }
}
