/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gest
 */
public class ConvertingTimeLogic {
    
    public static ConvertingTimeLogic getInstance(){
        return new ConvertingTimeLogic();
    }
    
    public java.sql.Date toSqlDate(java.util.Date uDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
        return sqlDate;
    }
    
    public java.sql.Time toSqlTime(java.util.Date uDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.set(Calendar.YEAR,1970);
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        calendar.set(Calendar.DATE,1);
        java.sql.Time time = new java.sql.Time(calendar.getTimeInMillis());
        return time;
    }
    
    public java.util.Date toUtilDateFromSqlDate(java.sql.Date sqlDate){
        java.util.Date uDate = new java.util.Date(sqlDate.getTime());
        return uDate;
    }
        
    public java.util.Date toUtilDateFromSqlTime(java.sql.Time sqlTime){
        java.util.Date uDate = new java.util.Date(sqlTime.getTime());
        return uDate;
    }
   
    public java.util.Date toUtilDateFromSqlDateAndSqlTime(java.sql.Date sqlDate,java.sql.Time sqlTime) throws ParseException{
        final String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
        try{
            java.util.Date date = f.parse(sqlDate.toString() + " " + sqlTime.toString());
            return date;
        }catch(ParseException pe){
            throw new ParseException("この位置でエラーが発生しました",pe.getErrorOffset());
        }
    }
    
    public String toStringFromSqlDate(java.sql.Date sqlDate){
        java.util.Date date = toUtilDateFromSqlDate(sqlDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(date);
        return s;
    }
    
    public String toStringFromSqlTime(java.sql.Time sqlTime){
        java.util.Date date = toUtilDateFromSqlTime(sqlTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String s = sdf.format(date);
        return s;
    }
    
    //フォームから送られてきたパラメータ(input type=date)をそのまま引数として渡せば良い
    public java.sql.Date toSqlDateFromString(String strDate) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);
        java.sql.Date sqlDate = this.toSqlDate(date);
        return sqlDate;
    }
    
    //フォームから送られてきたパラメータ(input type=time)をそのまま引数として渡せば良い
    public java.sql.Time toSqlTimeFromString(String strTime) throws ParseException{
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date time = timeFormat.parse(strTime);
        java.sql.Time sqlTime = this.toSqlTime(time);
        return sqlTime;
    }
    
    public java.util.Date toUtilDateFromString(String strDate, String strTime) throws ParseException{
        String union = strDate + " " + strTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = dateFormat.parse(union);
        return date;
    }
    
    public String toStringDateFromUtilDate(java.util.Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        return strDate;
    }
    
    public String toStringTimeFromUtilDate(java.util.Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String strTime = sdf.format(date);
        return strTime;
    }
}
