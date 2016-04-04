public class Main{
  public static void main(String[] args){
    int id = new java.util.Random().nextInt(3) + 1;
    for(int i = 1; i < 4; i++){
      System.out.println(identify(id, i));
    }
  }

  public static String identify(int id, int i){
    String n = "";
    for (int j = 1; i < 4; i++){
      switch (j){
        case 1:
          String[] info1 = {"1", "山田", "1月1日", "北海道"};
          n = info1[i];
        break;

        case 2:
          String[] info2 = {"2", "田中", "4月15日", null};
          n = info2[i];
        break;

        case 3:
          String[] info3 = {"3", "吉田", "12月31日", "沖縄県"};
          n = info3[i];
        break;
      }
    }
    return n;
  }
}
