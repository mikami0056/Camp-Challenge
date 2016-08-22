/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author gest
 */
public class WorkStatusDTO {
    
    public WorkStatusDTO(){
    }
    
    public WorkStatusDTO(EmployeesDTO employee){
        this.setEmp_id(employee.getEmp_id());
    }
    public WorkStatusDTO(EmployeesDTO employee, Date work_date, Time work_in){
        this(employee);
        this.setWork_date(work_date);
        this.setWork_in(work_in);
    }
    
    private Date    work_date;      //年月日
    private Integer emp_id;         //社員ID
    private Time    work_in;        //出勤時刻
    private Time    work_out;       //退勤時刻
    private Time    rest_time;      //休憩時間
    private Time    work_time;      //勤務時間
    private String  status;         //状態(出勤、欠勤、早退、遅刻、忌引、有給)
    private Boolean delete_flag;    //論理削除フラグ
    
    public void setWork_date(Date work_date){
        this.work_date = work_date;
    }
    public Date getWork_date(){
        return this.work_date;
    }
    
    public void setEmp_id(Integer emp_id){
        this.emp_id = emp_id;
    }
    public Integer getEmp_id(){
        return this.emp_id;
    }
    
    public void setWork_in(Time work_in){
        this.work_in = work_in;
    }
    public Time getWork_in(){
        return this.work_in;
    }
    
    public void setWork_out(Time work_out){
        this.work_out = work_out;
    }
    public Time getWork_out(){
        return this.work_out;
    }
    
    public void setRest_time(Time rest_time){
        this.rest_time = rest_time;
    }
    public Time getRest_time(){
        return this.rest_time;
    }
    
    public void setWork_time(Time work_time){
        this.work_time = work_time;
    }
    public Time getWork_time(){
        return this.work_time;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    
    public void setDelete_flag(Boolean delete_flag){
        this.delete_flag = delete_flag;
    }
    public Boolean getDelete_flag(){
        return this.delete_flag;
    }
}
