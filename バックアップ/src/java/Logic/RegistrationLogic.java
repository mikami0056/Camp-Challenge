/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.SQLException;
import model.UserDataBeans;
import model.UserDataDAO;
import model.UserDataDTO;

/**
 *
 * @author gest
 */
public class RegistrationLogic {
    
    public RegistrationLogic(){}
    
    public static RegistrationLogic getInstance(){
        return new RegistrationLogic();
    }
    
    public boolean RegistrationExecute(UserDataBeans regist) throws SQLException, ClassNotFoundException{
        
        boolean status = false;
        UserDataBeans registUser = regist;
        UserDataDTO dto = new UserDataDTO();
        registUser.UDB2DTOMapping(dto);
        UserDataDAO dao = new UserDataDAO();
        
        if(dao.checkUserData(dto)){
            dao.insertUserData(dto);
            status = true;
            return status;
            
        }else{
            return status;
            
        }
    }
    
}
