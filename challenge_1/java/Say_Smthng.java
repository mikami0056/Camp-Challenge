public class Main{
  public static void main(String[] args){

    int v = new java.util.Random().nextInt(4) + 1;    //1〜4の変数を生成
    switch (v) {
      case 1:
        System.out.println("値は" + v + "です!");
      break

      case 2:
        System.out.println("プログラミングキャンプ!");
      break

      default:
        System.out.println("その他です!");
    }
  }
}
