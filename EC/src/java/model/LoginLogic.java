/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author SHO
 */
public class LoginLogic {
    
    public LoginLogic(){}
    
    public static LoginLogic getInstance(){
        return new LoginLogic();
    }
    
    public UserDataBeans loginExecute(String userName, String passWord) throws SQLException{
        UserDataBeans loginAccount = new UserDataBeans();
        loginAccount.setName(userName);
        loginAccount.setPassWord(passWord);
            
        UserDataDTO udt = new UserDataDTO();
        loginAccount.UDB2DTOMapping(udt);
        UserDataDTO accountDTO = UserDataDAO.getInstance().searchNameAndPass(udt);
            
        if(accountDTO != null){        
            loginAccount.DTO2DBMapping(accountDTO);
            return loginAccount;
        } else {
            return loginAccount = null;
        }
    }
    
    public boolean flagJudger(UserDataBeans loginAccount){
        boolean flag;
        if(loginAccount != null){
            return flag = true;
        }else{
            return flag = false;
        }
    } 
}
