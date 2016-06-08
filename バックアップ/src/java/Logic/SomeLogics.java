/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Enumeration;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gest
 */
public class SomeLogics {
    public static SomeLogics getInstance(){
        return new SomeLogics();
    }
    public boolean checkExistInSession(HttpSession session, String name){
        Enumeration names = session.getAttributeNames();
        boolean judge = false; 
        while(names.hasMoreElements()){
            if(name.equals((String)names.nextElement())){
                judge = true;
            }
        }
        return judge;
    }
    
}
