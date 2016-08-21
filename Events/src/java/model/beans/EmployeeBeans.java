/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gest
 */
public class EmployeeBeans implements Serializable{
   
    private Date beginTime;
    private Date endTime;
    private Integer emp_id;
    private String toJSPBeginTime;
    private String toJSPEndTime;
    
    public void setBeginTime(Date date){
        this.beginTime = date;
        this.setToJSPBeginTime(this.beginTime);
    }
    public Date getBeginTime(){
        return this.beginTime;
    }
    
    public void setEndTime(Date date){
        this.endTime = date;
        this.setToJSPEndTime(this.endTime);
    }
    public Date getEndTime(){
        return this.endTime;
    }
    
    public void setToJSPBeginTime(Date date){
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        this.toJSPBeginTime = f.format(date);
    }
    public String getToJSPBeginTime(){
        return this.toJSPBeginTime;
    }
    
    public void setToJSPEndTime(Date date){
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        this.toJSPEndTime = f.format(date);
    }
    public String getToJSPEndTime(){
        return this.toJSPEndTime;
    }
    
    public void setEmp_id(Integer emp_id){
        this.emp_id = emp_id;
    }
    public Integer getEmp_id(){
        return this.emp_id;
    }
}
