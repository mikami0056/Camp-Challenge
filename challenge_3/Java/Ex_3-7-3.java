public class Main{
  public static void main(String[] args){
    int[] idArray = {1, 2, 3};       //id配列

    for (int a = 0; a < idArray.length; a++){
      String[] array = identify(idArray[a]);

      for(int i = 1; i < array.length; i++){
        if (array[i] == null){
          continue;
        }
        System.out.println(array[i]);
      }
    }
  }
  public static String[] identify(int id){
    String[] n = {"1"};
      switch (id){
        case 1:
          String[] info1 = {"1", "山田", "1月1日", "北海道"};
          n = info1;
        break;

        case 2:
          String[] info2 = {"2", "田中", "4月15日", "東京都"};
          n = info2;
        break;

        case 3:
          String[] info3 = {"3", "吉田", "12月31日", "沖縄県"};
          n = info3;
        break;
      }
    return n;
  }
}
