/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import db.dbmanager;
import java.sql.ResultSet;

/**
 *
 * @author gest
 */
public class UserDataDAO {
    public UserDataDAO(){}
    
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    public UserDataDTO getUserData(UserDataDTO dto) throws SQLException, ClassNotFoundException{
        
        UserDataDTO accountDTO = null;
        Connection con = null;
        PreparedStatement pst = null;
        String selectSql = "SELECT userID, username, password, mail, questionID, answer FROM user_t WHERE username = ? and password = ?";
        System.out.println("getUserData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(selectSql);
            pst.setString(1, dto.getUserName());
            pst.setString(2, dto.getPassWord());
            ResultSet rs = pst.executeQuery();
                        
            while(rs.next()){
                int userID = rs.getInt("userID");
                System.out.println(userID);
                String userName = rs.getString("username");
                String passWord = rs.getString("password");
                String mail = rs.getString("mail");
                int questionID = rs.getInt("questionID");
                String answer = rs.getString("answer");
                accountDTO = new UserDataDTO(userID, userName, passWord, mail, questionID, answer);
            }
            
            if(accountDTO == null){
            System.out.println("テスト2");
            }
            System.out.println("getUserData completed");
            return accountDTO;
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            throw new SQLException(sqle);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /*
    @登録可否をチェックするためのメソッド
    @新規登録時に使用
    @ユーザ入力フォ−ムより受け取ったユーザIDとメールアドレスが同一のものがいないか確認する
    */
    public boolean checkUserData(UserDataDTO dto)throws SQLException, ClassNotFoundException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String checkSql = "SELECT * FROM user_t WHERE username = ? and mail = ?";
        System.out.println("[Notice in UserDataDAO.java]\"checkUserData\" has been started[at checkUserData]");
        boolean exist = false;
        
        try{
            con = dbmanager.getConnection();
            pst =  con.prepareStatement(checkSql);
            pst.setString(1, dto.getUserName());
            pst.setString(2, dto.getMail());
            ResultSet rs = pst.executeQuery();
            //同じユーザ名とパスワードが登録されていれば失敗falseを返す
            exist = !rs.next();
            
            if(!rs.next()){
                exist = !rs.next();
                System.out.println("[Notice]name and password has been existing. Please fill out the form again.");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        return exist;
    }
    
    public void insertUserData(UserDataDTO dto) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String insertSql = "INSERT INTO user_t(userID,username,password,mail,questionID,answer,registDate) VALUES(?,?,?,?,?,?,?)";
        System.out.println("[Notice in UserDataDAO.java]\"insertUserData\" has been started[at checkUserData]");
        
        try{
            
            con = dbmanager.getConnection();
            pst =  con.prepareStatement(insertSql);
            pst.setInt(1, dto.getUserID());
            pst.setString(2, dto.getUserName());
            pst.setString(3, dto.getPassWord());
            pst.setString(4, dto.getMail());
            pst.setInt(5, dto.getQuestionID());
            pst.setString(6, dto.getAnswer());
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            System.out.println("inserInformation start completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        
    }
    
    public void updateUserData(UserDataDTO dto) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String updateSql = "UPDATE user_t SET userName = ?, passWord = ?, mail = ? WHERE userID = ?";
        System.out.println("updateUserData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(updateSql);
            pst.setString(1, dto.getUserName());
            pst.setString(2, dto.getPassWord());
            pst.setString(3, dto.getMail());
            pst.setInt(4, dto.getUserID());
            pst.executeUpdate();
            System.out.println("updateUserData completed");
            
        }catch(ClassNotFoundException classError){
            
            System.out.println(classError.getMessage());
            classError.printStackTrace();
            throw new ClassNotFoundException(classError.getMessage());
            
        }catch(SQLException sqlError){
            
            System.out.println(sqlError.getMessage());
            sqlError.printStackTrace();
            throw new SQLException(sqlError.getMessage());
            
        }finally{
            
            if(con != null){
                con.close();
            }
            
        }
        
        
        
    }
    
    public void deleteUserData(UserDataDTO dto) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String deleteSql4Evaluation = "DELETE FROM evaluation_t WHERE userID = ?";
        String deleteSql4Comment = "DELETE FROM comment_t WHERE userID = ?";
        String deleteSql4Picture = "DELETE FROM picture_t WHERE userID = ?";
        String deleteSql4User = "DELETE FROM user_t WHERE userID = ? OR userName = ?";
        System.out.println("deleteUserData start");
        
        try{
            
            con = dbmanager.getConnection();
            pst = con.prepareStatement(deleteSql4Evaluation);
            pst.setInt(1, dto.getUserID());
            pst.executeUpdate();
            System.out.println("評価テーブルからユーザー情報を削除しました");
            
            pst = con.prepareStatement(deleteSql4Comment);
            pst.setInt(1, dto.getUserID());
            pst.executeUpdate();
            System.out.println("コメントテーブルからユーザー情報を削除しました");
            
            pst = con.prepareStatement(deleteSql4Picture);
            pst.setInt(1,dto.getUserID());
            pst.executeUpdate();
            System.out.println("写真テーブルからユーザー情報を削除しました");
            
            pst = con.prepareStatement(deleteSql4User);
            pst.setInt(1, dto.getUserID());
            pst.setString(2, dto.getUserName());
            pst.executeUpdate();
            System.out.println("ユーザーテーブルからユーザー情報を削除しました");

        }catch(ClassNotFoundException classError){
            
            System.out.println(classError.getMessage());
            classError.printStackTrace();
            throw new ClassNotFoundException(classError.getMessage());
            
        }catch(SQLException sqlError){
            
            System.out.println(sqlError.getMessage());
            sqlError.printStackTrace();
            throw new SQLException(sqlError.getMessage());
            
        }finally{
            
            if(con != null){
                con.close();
            }
            
        }
        
    }
}
