/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author gest
 */
public class EventJoinDTO {
    private Integer event_id;
    private Integer emp_id;
    
    public void setEvent_id(Integer event_id){
        this.event_id = event_id;
    }
    public Integer getEvent_id(){
        return this.event_id;
    }
    
    public void setEmp_id(Integer emp_id){
        this.emp_id = emp_id;
    }
    public Integer getEmp_id(){
        return this.emp_id;
    }
}
