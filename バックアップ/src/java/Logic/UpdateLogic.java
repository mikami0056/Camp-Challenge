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
public class UpdateLogic {
    
    public UpdateLogic(){}
    
    public static UpdateLogic getInstance(){
        return new UpdateLogic();
    }
    
    public void updateUserData(UserDataBeans loginAccount) throws ClassNotFoundException, SQLException{
        UserDataDTO dto = new UserDataDTO();
        loginAccount.UDB2DTOMapping(dto);
        UserDataDAO.getInstance().updateUserData(dto);
        PictureDataDAO.getInstance().updatePictureData(dto);
    }
    
    /*
    @データベース内の写真情報を更新するメソッド
    @更新される情報は
    */
    public void updatePictureData(PictureDataBeans picture4Update, UserDataBeans loginAccount, String oldName) throws SQLException, ClassNotFoundException{
        
        PictureDataDTO dto = new PictureDataDTO();
        String path = "/Users/gest/NetBeansProjects/WorkSpacesProto/web/common/image/";
        picture4Update.PDB2DTOMapping(dto, loginAccount.getUserID());
        File oldFile = new File(path + loginAccount.getUserName() + "/" + oldName);
        
        if(oldFile.exists()){
            System.out.println(dto.getPicturePath());
            File newFile = new File(path + loginAccount.getUserName() + "/" + dto.getPictureName());
            oldFile.renameTo(newFile);
            PictureDataDAO.getInstance().updatePictureData(dto);
        } 
    }
}
