public class  Main{
  public static void main(String[] args){
    int id = new java.util.Random().nextInt(3) + 1;
    ident(id);
    System.out.println(name(id));
    System.out.println(birth(id));
    System.out.println(address(id));
  }
  public static int ident(int id){
    int id2 = 200;
    return id2;
  }
  public static String name(int id){
    String name = "テスト";
    return name;
  }

  public static String birth(int id){
    String birth = "12月24日";
    return birth;
  }

    public static String address(int id){
      String address = "火星";
      return address;
    }
}
