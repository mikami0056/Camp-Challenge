public class  Main{
  public static void main(String[] args){
    for (int i = 1; i < 4; i++){
      System.out.println("確認用：" + i);
      System.out.println("私の名前は " + name(i) + " です。");
      System.out.println("生年月日は " + birth(i) + " です。");
      System.out.println("私の住所は " + address(i) + " です。");
    }
  }
  public static String name(int id){
    String name = "";
    switch (id){
      case 1:
        name = "山田";
        break;
      case 2:
        name = "田中";
        break;
      case 3:
        name = "吉田";
        break;
    }
    return name;
  }

  public static String birth(int id){
    String birth = "";
    switch (id){
      case 1:
        birth = "平成元年1月1日";
        break;
      case 2:
        birth = "平成2年4月15日";
        break;
      case 3:
        birth = "平成3年12月31日";
        break;
    }
    return birth;
  }

    public static String address(int id){
      String address = "";
      switch (id){
        case 1:
          address = "北海道";
          break;
        case 2:
          address = "東京";
          break;
        case 3:
          address = "沖縄";
          break;
      }
      return address;
    }
}
