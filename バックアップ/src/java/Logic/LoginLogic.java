/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import controller.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserDataBeans;
import model.UserDataDAO;
import model.UserDataDTO;

/**
 *
 * @author gest
 */
public class LoginLogic {
    
    public LoginLogic(){}
    
    public static LoginLogic getInstance(){
        return new LoginLogic();
    }
    
    public UserDataBeans LoginExecute(String userName, String passWord){
        
        UserDataBeans instance4Login = new UserDataBeans(userName, passWord);
        UserDataBeans loginAccount = null;
        UserDataDTO dto = new UserDataDTO();
        instance4Login.UDB2DTOMapping(dto);
        
        try {
            
            UserDataDTO accountDTO = UserDataDAO.getInstance().getUserData(dto);
            if(accountDTO != null){
                loginAccount = new UserDataBeans();
                loginAccount.DTO2UDBMapping(accountDTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loginAccount;
    }
    
}
