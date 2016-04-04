public class  Main{
  public static void main(String[] args){
    if (whoami()){
      System.out.println("正常に処理されました");
    } else {
        System.out.println("正常に処理されませんでした");
      }
  }

  public static boolean whoami(){
    for (int i = 0; i < 10; i++){
      System.out.println("名前");
      System.out.println("生年月日");
      System.out.println("自己紹介");
    }
    boolean type; type = true;
    return type;
  }
}
