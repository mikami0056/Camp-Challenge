/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import controller.Upload;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.PictureDataBeans;
import model.PictureDataDAO;
import model.PictureDataDTO;
import model.UserDataBeans;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author gest
 */
public class UploadLogic {
    //コンストラクタ
    public UploadLogic(){}
    
    //インスタンス取得用
    public static UploadLogic getInstance(){
        return new UploadLogic();
        
    }
    
    //写真アップロード用
    public void pictureUpload(HttpServletRequest request, UserDataBeans loginAccount, String contextPath){
        for(int i = 0; i < 6; i++){}
        PictureDataBeans picture = null;
        
        //写真保存用ディレクトリ
        System.out.println("パス" + request.getRequestURI());
        String path = "/Users/gest/NetBeansProjects/WorkSpacesProto/web/common/image/";
        File newDirectry = new File(path + loginAccount.getUserName());        
        
        //存在しなければ作成
        if(!newDirectry.exists()|| newDirectry == null){
            newDirectry.mkdir();
            System.out.println("ディレクトリ作成");
        }
        
        //ディレクトリの場所を取得
        String dPath = newDirectry.getPath();
        
        //専用のライブラリが必要
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        
        try{
            //写真登録画面から送られてきたデータを格納
            List<FileItem> list = sfu.parseRequest(request);
            Iterator iterator = list.iterator();
            
            String pictureName = "";
            String extension = "";
            String comment = "投稿者コメントはありません";
            int categoryID = 1;
            
            FileItem pictureData = null;
            
            while(iterator.hasNext()){
                FileItem item = (FileItem)iterator.next();
                
                //写真データの場合
                if(!item.isFormField()){
                    pictureData = item;
                    String itemName = item.getName();
                    extension = itemName.substring(itemName.lastIndexOf("."));
                    
                //写真データ以外(パラメータ)の場合   
                }else{
                    System.out.println(item.getString("UTF-8"));
                    switch(item.getFieldName()){
                       
                        case "pictureName":
                            //入力された写真名を取得
                            pictureName = item.getString("UTF-8");
                            //写真名が無記入の場合, [無題+投稿日]となる
                            if(pictureName.isEmpty()){
                            Date date = new Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                            String strDate = sdf.format(date);
                            pictureName = "無題" + strDate;
                            }
                        break;
                        
                        case "category":
                            categoryID = Integer.parseInt(item.getString("UTF-8"));
                        break;
                        
                        case "comment":
                            comment = item.getString("UTF-8");
                        break;    
                    }
                }
            }
            
            pictureData.write(new File(dPath + "/" + pictureName + extension));
            //サーバー内に写真をアップロード, DB内に情報を保存
            String pPath = contextPath + "/common/image/" + loginAccount.getUserName() + "/" + pictureName + extension;
            picture = new PictureDataBeans((pictureName + extension), pPath, comment, categoryID, loginAccount.getUserName());
            picture.setPictureID(picture.hashCode());
            
            //DBに保存
            PictureDataDTO dto = new PictureDataDTO();
            picture.PDB2DTOMapping(dto, loginAccount.getUserID());
            PictureDataDAO.getInstance().setPictureData(dto);
            
            
        } catch (FileUploadException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
