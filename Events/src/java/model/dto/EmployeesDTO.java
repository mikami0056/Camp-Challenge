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
public class EmployeesDTO {
    private Integer emp_id;
    private String  emp_name;
    
    public void setEmp_id(Integer emp_id){
        this.emp_id = emp_id;
    }
    public Integer getEmp_id(){
        return this.emp_id;
    }
    
    public void setEmp_name(String emp_name){
        this.emp_name = emp_name;
    }
    public String getEmp_name(){
        return this.emp_name;
    }
}
