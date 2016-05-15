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
        System.out.println("[Notice]loginExecute start");
        UserDataBeans loginAccount = new UserDataBeans();
        System.out.println("1");
        loginAccount.setName(userName);
        System.out.println("2");
        loginAccount.setPassWord(passWord);
        System.out.println("3");
        
        UserDataDTO udt = new UserDataDTO();
        System.out.println("4");
        loginAccount.UDB2DTOMapping(udt);
        System.out.println("5");
        UserDataDTO accountDTO = UserDataDAO.getInstance().searchNameAndPass(udt);
            
        if(accountDTO != null){        
            loginAccount.DTO2UDBMapping(accountDTO);
            System.out.println("[Notice]loginExecute finished ");
            System.out.println("[Status]accountDTO is NOT NULL");
            return loginAccount;
        } else {
            System.out.println("[Notice]loginExecute finished ");
            System.out.println("[Status]accountDTO is  NULL");
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
