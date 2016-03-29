public class Main{
  public static void main(String[] args){

    //基本情報の入力
    String name = "三上祥一郎";　        //氏名
    String birthDay = "平成3年5月6日";   //誕生日
    int age = 24;                      //年齢
    String nativePlace = "千葉県印西市"; //出身地または住所
    String oldSchool = "木更津工業高等専門学校"; //出身校
    String major = "機械・電子システム工学専攻"; //出身学部

    //出力
    System.out.println("私は" + name + "と申します。");
    System.out.println("生年月日は" + birthDay + "で, 現在" + age + "歳です。");
    System.out.println("出身地は" + nativePlace + "です。" );
    System.out.println("出身校は, " + oldSchool + "で,専攻は" + major +"です。");
  }
}
