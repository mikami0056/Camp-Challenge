/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import controller.PictureDetail;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CountDataBeans;
import model.CountDataDAO;
import model.CountDataDTO;
import model.PictureDataBeans;

/**
 *
 * @author gest
 */
public class CountLogic {
    
    public CountLogic(){}
    
    public static CountLogic getInstance(){
        return new CountLogic();
    }
    
    public int countAndGetDataFromDB(CountDataBeans cdb, String param, PictureDataBeans pdb){
        
        CountDataBeans countData = cdb;
        int returnParameter = 0;

        switch(param){
            case "beautiful":
            countData.setBeautiful(countData.getBeautiful() + 1);
            getDataFromDB(countData);
            //pdb.setBeautiful(countData.getBeautiful());
            returnParameter = countData.getBeautiful();
            break;
            
            case "cool":
            countData.setCool(countData.getCool() + 1);
            getDataFromDB(countData);
            //pdb.setCool(countData.getCool());
            returnParameter = countData.getCool();
            break;
            
            case "stylish":
            countData.setStylish(countData.getStylish() + 1);
            getDataFromDB(countData);
            //pdb.setStylish(countData.getStylish());
            returnParameter = countData.getStylish();
            break;
        }
        return returnParameter;
    }
    
    public void getDataFromDB(CountDataBeans countDataB){
        
        CountDataBeans countData = countDataB;
        CountDataDTO dto = new CountDataDTO();
        countData.CDB2CDDMapping(dto);
        
        try {
            CountDataDAO dao = new CountDataDAO();
            
            if(dao.checkCountDataExist(dto)){
                dao.insertCountData(dto);
            }else{
                dao.updateCountData(dto);
            }
            
            dto = dao.getCountData(dto);
            countData.CDD2CDBMapping(dto);          
            
        } catch (SQLException ex) {
            Logger.getLogger(PictureDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
