package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type ;
    private String comment;
    //追加点(仕様書に規定無し):検索方法判断用変数 search.jspより入力された値を保持する役割
    private int searchMethod;
    
    public UserDataBeans(){
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = 0;
        this.comment= "";
        //追加点(仕様書に規定無し):検索方法判断用変数を初期化
        this.searchMethod = 0;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){
            this.year = 0;
        }else{
            this.year = Integer.parseInt(year);
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(String month) {
        if(month.equals("")){
            this.month = 0;
        }else{
            this.month = Integer.parseInt(month);
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(String day) {
        if(day.equals("")){
            this.day = 0;
        }else{
            this.day = Integer.parseInt(day);
        }
    }

    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }

    public int getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null){
            this.type = 0;
        }else{
            this.type = Integer.parseInt(type);
        }

    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        if(comment.trim().length()==0){
            this.comment = "";
        }else{
            this.comment = comment;
        }
    }
    
    //追加点(仕様書に規定無し):検索方法の判別用(search.jspより)
    public int getSearchMethod(){
        return this.searchMethod;
    }
    public void setSearchMethod(String value){
        if("".equals(value) || value == null){
            this.searchMethod = 1; //未入力時はANDで検索, 不必要なチェックかもしれない
        } else {
            int v = Integer.parseInt(value);
            this.searchMethod = v;
        }
    }
    //追加点(仕様書上に規定無し)ここまで
    
    //変更点:メソッド名を変更, chkpropertiesからchkPropertiesに変更
    public ArrayList<String> chkProperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.year == 0){
            chkList.add("year");
        }
        if(this.month == 0){
            chkList.add("month");
        }
        if(this.day == 0){
            chkList.add("day");
        }
        if(this.tell.equals("")){
            chkList.add("tell");
        }
        if(this.type == 0){
            chkList.add("type");
        }
        if(this.comment.equals("")){
            chkList.add("comment");
        }
        
        return chkList;
    }

    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        if(this.year != 0 || this.month != 0 || this.day != 0){
            Calendar birthday = Calendar.getInstance();
            if(this.month == 0 || this.day == 0){
                birthday.set(this.year,0,1);
            }else{
                birthday.set(this.year,(this.month)-1,this.day);
            }
            udd.setBirthday(birthday.getTime());
        }else{
            udd.setBirthday(null);
        }
        udd.setTell(this.tell);
        udd.setType(this.type);
        udd.setComment(this.comment);
        udd.setSearchMethod(this.searchMethod); //追加点
    }
    
}
