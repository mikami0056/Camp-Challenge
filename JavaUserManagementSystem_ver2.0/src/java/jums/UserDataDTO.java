package jums;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar; //追加点
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    private int searchMethod;
    
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    //追加点:UpdateConfirm用のgetter 余計なメソッドかもしれない ここから
    public String getStrBirthday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strBirthday = sdf.format(this.birthday);
        return strBirthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    //追加点(仕様書に規定無し):検索方法の判別用(search.jspより)ここから
    public int getSearchMethod(){
        return this.searchMethod;
    }
    public void setSearchMethod(int value){
        this.searchMethod = value;
    }
    //追加点(仕様書に規定無し) ここまで

}
