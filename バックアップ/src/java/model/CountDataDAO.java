/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.dbmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gest
 */
public class CountDataDAO {
    
    public CountDataDAO(){}
    
    public static CountDataDAO getInstance(){
        return new CountDataDAO();
    }
    
    public void insertCountData(CountDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String insertSql = "INSERT INTO evaluation_t VALUES(?,?,?,?,?,?)";
        System.out.println("newInsertCountData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(insertSql);
            pst.setInt(1, dto.getUserID());
            pst.setInt(2, dto.getPictureID());
            pst.setInt(3, dto.getBeautiful());
            pst.setInt(4, dto.getCool());
            pst.setInt(5, dto.getStylish());
            pst.setInt(6, dto.getBeautiful() + dto.getCool() + dto.getStylish());
            pst.executeUpdate();
            
            System.out.println("newInsertCountData completed");
            
        }catch(ClassNotFoundException cnfeError){
            
            System.out.println("エラーが発生しました / " + cnfeError.getMessage());
            cnfeError.printStackTrace();
            
        }catch(SQLException sqlError){
            
            System.out.println("エラーが発生しました / " + sqlError.getMessage());
            sqlError.printStackTrace();
            
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void updateCountData(CountDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String insertSql = "UPDATE evaluation_t SET beautiful = ?, cool = ?, stylish = ?, sum = ? WHERE pictureID = ?";
        System.out.println("insertCountData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(insertSql);
            pst.setInt(1, dto.getBeautiful());
            pst.setInt(2, dto.getCool());
            pst.setInt(3, dto.getStylish());
            pst.setInt(4, dto.getBeautiful() + dto.getCool() + dto.getStylish());
            //pst.setInt(4,dto.getUserID());
            pst.setInt(5, dto.getPictureID());
            
            pst.executeUpdate();
            
            System.out.println("insertCountData completed");
            
        }catch(ClassNotFoundException cnfeError){
            
            System.out.println("エラーが発生しました / " + cnfeError.getMessage());
            cnfeError.printStackTrace();
            
        }catch(SQLException sqlError){
            
            System.out.println("エラーが発生しました / " + sqlError.getMessage());
            sqlError.printStackTrace();
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        
    }
    
    public boolean checkCountDataExist(CountDataDTO dto) throws SQLException{
        
        boolean judge = false;
        
        Connection con = null;
        PreparedStatement pst = null;
        String selectSqlByPicture = "SELECT * FROM picture_t WHERE pictureID = ?";
        String selectSqlByEvaluation = "SELECT * FROM evaluation_t WHERE pictureID = ?";
        System.out.println("checkCountDataExist start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(selectSqlByPicture);
            //pst.setInt(1, dto.getUserID());
            pst.setInt(1, dto.getPictureID());
            ResultSet rs1 = pst.executeQuery();
            
            /*
            @検索結果が空の場合, rs.next()はfalseを返す. それを反転させてjudgeに代入
            */
            if(rs1.next()){
                pst = con.prepareStatement(selectSqlByEvaluation);
                pst.setInt(1, dto.getPictureID());
                ResultSet rs2 = pst.executeQuery();
                judge = !rs2.next();
            }
            
            System.out.println("checkCountDataExist completed");
        }catch(ClassNotFoundException cnfeError){
            
            System.out.println("エラーが発生しました / " + cnfeError.getMessage());
            cnfeError.printStackTrace();
            
        }catch(SQLException sqlError){
            
            System.out.println("エラーが発生しました / " + sqlError.getMessage());
            sqlError.printStackTrace();
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        
        return judge;
    }
    
    public CountDataDTO getCountData(CountDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String selectSql = "SELECT beautiful, cool, stylish FROM evaluation_t WHERE pictureID = ?";
        System.out.println("getCountData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(selectSql);
            pst.setInt(1, dto.getPictureID());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                dto.setBeautiful(rs.getInt("beautiful"));
                dto.setCool(rs.getInt("cool"));
                dto.setStylish(rs.getInt("stylish"));
                
            }
            
        }catch(ClassNotFoundException cnfeError){
            
            System.out.println("エラーが発生しました / " + cnfeError.getMessage());
            cnfeError.printStackTrace();
            
        }catch(SQLException sqlError){
            
            System.out.println("エラーが発生しました / " + sqlError.getMessage());
            sqlError.printStackTrace();
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        return dto;
    }
}
