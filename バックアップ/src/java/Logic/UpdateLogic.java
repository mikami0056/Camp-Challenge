/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.nio.file.Path;
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
    
    /*
    @ユーザー情報を更新するためのメソッド
    @
    */
    public void updateUserData(UserDataBeans loginAccount, String oldName) throws ClassNotFoundException, SQLException{
        UserDataDTO dto = new UserDataDTO();
        loginAccount.UDB2DTOMapping(dto);
        //ユーザー情報を更新
        UserDataDAO.getInstance().updateUserData(dto);
        //写真情報を更新
        PictureDataDAO.getInstance().updatePictureData(dto);
        //写真保存用ディレクトリの名前を更新
        String basePath = "/Users/gest/NetBeansProjects/WorkSpacesProto/web/common/image/";
        String oldPath = basePath + oldName;
        String newPath = basePath + loginAccount.getUserName();
        File oldDirectory = new File(oldPath);
        if(oldDirectory.exists() && oldDirectory.isDirectory()){
            File newDirectory = new File(newPath);
            oldDirectory.renameTo(newDirectory);
        }
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
