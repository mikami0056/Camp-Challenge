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
    
    task12a(){
    }

    private String sql;
    private String name, age, birthdate;
    
    public void setName(String name){
        if("".equals(name)){
            this.name = null;
            
        } else {
            this.name = name;
            
        }
    }
    
    public void setAge(String age){
        if("".equals(age)){
            this.age = null;
            
        } else {
            this.age = age;
            
        }
    }
    
    public void setBirthdate(String birthdate){
        if("".equals(birthdate)){
            this.birthdate = null;
            
        } else {
            this.birthdate = birthdate;
            
        }
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
    
    public void setSql(String name, String age, String birthdate){
        if(name == null || "".equals(name)){
            this.sql = "SELECT * FROM profiles WHERE age = " + age + " OR birthday LIKE \'%" + birthdate +"%\'";
        } else if(age == null || "".equals(age)){
            this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\' OR birthday LIKE \'%" + birthdate +"%\'";
        } else if(birthdate == null || "".equals(birthdate)){
            
        }
        
        this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\' OR age = " + age + " OR birthday LIKE \'%" + birthdate +"%\'";
    }
    
    public String getSql(){
        if(this.name != null && this.age != null && this.birthdate != null){
           this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\' OR age = " + age + " OR birthday LIKE \'%" + birthdate +"%\'";
           
        } else if(this.name != null){
            //名前入力有り
            if(this.age != null){
                this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\' OR age = " + age;
            } else if (this.birthdate != null){
                this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\' OR birthday LIKE \'%" + birthdate +"%\'";             
            } else {
                this.sql = "SELECT * FROM profiles WHERE name LIKE \'%" + name + "%\'";
            }
            //名前入力有り
            
        } else if (this.age != null){
            //名前入力無し, 年齢入力有り
            if(this.birthdate != null){
                this.sql = "SELECT * FROM profiles WHERE age = " + age + " OR birthday LIKE \'%" + birthdate +"%\'";                
            } else {
                this. sql = "SELECT * FROM profiles WHERE age = " + age;
            }
            //名前入力無し, 年齢入力有り
            
        } else {
            //名前, 年齢入力無し
            this.sql = "SELECT * FROM profiles WHERE  birthday LIKE \'%" + birthdate +"%\'";
        }
        
        return this.sql;
    } 
}
