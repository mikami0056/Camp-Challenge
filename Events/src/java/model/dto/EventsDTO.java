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
public class EventsDTO {
    
    private Integer event_id;
    private String  event_name;
    private Date    event_date;
    private Time    event_time;
    private String  event_place;
    private String  event_detail;
    private Integer emp_id;
    private Date    deadline;
    
    public void setEvent_id(Integer event_id){
        this.event_id = event_id;
    }
    public Integer getEvent_id(){
        return this.event_id;
    }
    
    public void setEvent_name(String event_name){
        this.event_name = event_name;
    }
    public String getEvent_name(){
        return this.event_name;
    }
    
    public void setEvent_date(Date event_date){
        this.event_date = event_date;
    }
    public Date getEvent_date(){
        return this.event_date;
    }
    
    public void setEvent_time(Time event_time){
        this.event_time = event_time;
    }
    public Time getEvent_time(){
        return this.event_time;
    }
    
    public void setEvent_place(String event_place){
        this.event_place = event_place;
    }
    public String getEvent_place(){
        return this.event_place;
    }
    
    public void setEvent_detail(String event_detail){
        this.event_detail = event_detail;
    }
    public String getEvent_detail(){
        return this.event_detail;
    }
    
    public void setEmp_id(Integer emp_id){
        this.emp_id = emp_id;
    }
    public Integer getEmp_id(){
        return this.emp_id;
    }
    
    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }
    public Date getDeadline(){
        return this.deadline;
    }
}
