public class Main{
  public static void main(String[] args){

    final int c = 10;   //定数cを設定
    int v = new java.util.Random().nextInt(5) + 1;   //乱数で1〜5までの変数vを生成

    operations(c, v);   //四則演算のメソッドを呼び出し, 定数と変数を渡す
  }

  public static void operations(int c, int v){    //四則演算のメソッド
    System.out.println("変数は「" + v + "」になりました。"); //生成された変数を表示

    //以下, 四則演算の実行プログラム
    System.out.println("足し算の結果は, " + c + " + " + v + " = " + (c + v) + " です。");
    System.out.println("引き算の結果は, " + c + " - " + v + " = " + (c - v) + " です。");
    System.out.println("掛け算の結果は, " + c + " * " + v + " = " + (c * v) + " です。");
    System.out.println("割り算の結果は, " + c + " / " + v + " = " + (c / v) + " で, 余りは" + (c % v) + " です。");
  }
}
