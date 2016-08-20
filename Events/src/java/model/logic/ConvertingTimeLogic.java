/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import java.util.Calendar;

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
    
    public java.util.Date toUtilDateFromSqlDate(java.sql.Date sqlDate){
        java.util.Date uDate = new java.util.Date(sqlDate.getTime());
        return uDate;
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
}