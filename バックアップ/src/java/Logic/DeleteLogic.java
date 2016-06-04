/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.sql.SQLException;
import model.PictureDataBeans;
import model.PictureDataDAO;
import model.PictureDataDTO;
import model.UserDataBeans;
import model.UserDataDAO;
import model.UserDataDTO;

/**
 *
 * @author gest
 */
public class DeleteLogic {
    
    public DeleteLogic(){}
    
    public static DeleteLogic getInstance(){
        return new DeleteLogic();
    }
    
    public void deleteUserData(UserDataBeans loginAccount) throws ClassNotFoundException, SQLException{
        
        UserDataDTO dto = new UserDataDTO();
        loginAccount.UDB2DTOMapping(dto);
        UserDataDAO.getInstance().deleteUserData(dto);
        
    }
    
    public void deletePictureData (PictureDataBeans picture4Delete, UserDataBeans loginAccount) throws ClassNotFoundException, SQLException{
        
        PictureDataDTO dto = new PictureDataDTO();
        picture4Delete.PDB2DTOMapping(dto, loginAccount.getUserID());
        PictureDataDAO.getInstance().deletePictureData(dto);
        String path = "/Users/gest/NetBeansProjects/WorkSpacesProto/web/common/image/";
        File file4Delete = new File(path + loginAccount.getUserName() + "/" + picture4Delete.getName());
        
        if(file4Delete.exists()){
            file4Delete.delete();
        }
        
    }
}
