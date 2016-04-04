public class Main{
  public static void main(String[] args){                                       //変数, 定数, タイプをそれぞれ決定するメソッド
    int v = new java.util.Random().nextInt(10) + 1;                             //1〜10までの変数を生成
    int c = 5;                                                                  //
    boolean type; type = false;                                                 //タイプを決定
    multi(v, c, type);                                                          //掛け算メソッドに各値を渡す
  }

  public static void multi(int v, int c, boolean type){                         //掛け算メソッド
    int sum = v * c;
    System.out.println("掛け算の結果は "  + sum + " です。");

    if (type){
      sum =sum * sum;
      System.out.println("タイプは " + type + "なので, 結果を2乗します。");
      System.out.println("2乗した結果は " + sum + " です。");
    } else {
      System.out.println("タイプは " + type + "なので, 各値をそのまま表示します");
      System.out.print("変数は " + v + " です。");
      System.out.print("定数は " + c + " です。");
    }
  }
}
