public class task3{
  public String a;                                                              //パブリックな変数1
  public int b;                                                                 //パブリックな変数2

  public void set(){                                                            //2つの変数に値を設定する関数
    this.a = "変数1";
    this.b = 666;
  }

  public void out(){                                                            //2つの変数を表示する関数
    System.out.println(this.a);
    System.out.println(this.b);
  }

}
