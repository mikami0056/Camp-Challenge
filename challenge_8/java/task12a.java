/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

/**
 *
 * @author SHO
 */
public class task12a {

    private String sql;
    private String originalSql;
    private String nameSql;
    private String ageSql;
    private String birthdateSql;
    private String name, age, birthdate;
    
    task12a(){
        this.originalSql = "SELECT * FROM profiles ";
    }
    
    public void setName(String name){
        if("".equals(name)){
            this.name = null;         
        } else {
            this.name = name;
            this.nameSql = "name LIKE \'%" + this.name + "%\'";
        }
    }
    public String getName(){
        return this.name;
    }
    
    public void setAge(String age){
        if("".equals(age)){
            this.age = null;
        } else {
            this.age = age;
            this.ageSql = "age LIKE " + this.age ;
        }
    }
    public String getAge(){
        return this.age;
    }
    
    public void setBirthdate(String birthdate){
        if("".equals(birthdate)){
            this.birthdate = null;
        } else {
            this.birthdate = birthdate;
            this.birthdateSql = "birthday LIKE \'%" + this.birthdate + "%\'";   
        }
    }
    public String getBirthdate(){
        return this.birthdate;
    }

    public boolean confirmation (){
        boolean type;
        if(this.name == null && this.age == null && this.birthdate == null){
            type = false;
        } else {
            type =true;
        }
        return type;
    }
  
    public String getSql(){
        boolean nameType = false;
        boolean ageType = false; 
        
        if(this.name != null){
            //名前入力有り
            this.sql = this.originalSql + "WHERE " + this.nameSql;
            nameType = true;
        } 
        
        if(this.age != null){
            if(nameType == true){   //名前がセットされてる場合
                this.sql = this.sql + " OR " + this.ageSql;
                ageType = true;
            } else {                //名前がセットされていな場合
                this.sql = this.originalSql + "WHERE " + this.ageSql;
            }
        } 
        
        if(this.birthdate != null){
            if(nameType == true || ageType == true){    //名前又は年齢がセットされている場合
                this.sql = this.sql + " OR " + this.birthdateSql;
            } else if(nameType == false && ageType == false){   //どちらもセットされていない場合
                this.sql = this.originalSql + "WHERE " + this.birthdateSql;
            }   
        } 
        return this.sql;
    } 
}
