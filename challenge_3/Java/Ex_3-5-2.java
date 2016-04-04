public class Main{
  public static void main(String[] args){
    String[] array = makeArray();
    for(int i = 1; i < 4; i++){
      System.out.println(array[i]);
    }
  }

  public static String[] makeArray(){
    String[] info = {"111", "山田", "1月1日", "北海道"};
    return info;
  }
}
