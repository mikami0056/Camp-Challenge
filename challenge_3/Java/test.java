public class Main{
  public static void main(String[] args){
    System.out.println("メソッドを呼び出します。");
    for (i = 0; i < 3; i++){
      whoami();
    }
  }
  public static void whoami(){
    System.out.println("氏名");
    System.out.println("年齢");
    System.out.println("生年月日");
  }
}
