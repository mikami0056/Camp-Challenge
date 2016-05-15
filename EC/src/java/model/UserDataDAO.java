/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DBController.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author SHO
 */
public class UserDataDAO {
    
    public UserDataDAO(){}
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    public void insertInformation(UserDataBeans udb) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)";
        System.out.println("inserInformation start");
        
        try{
            con = DBManager.getConnection();
            pst =  con.prepareStatement(sql);
            pst.setString(1, udb.getName());
            pst.setString(2, udb.getPassWord());
            pst.setString(3, udb.getMail());
            pst.setString(4, udb.getAddress());
            pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
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
    
    public UserDataDTO searchNameAndPass(UserDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        UserDataDTO accountDTO = null;
        String sql = "SELECT userID, name, password, mail, address, total FROM user_t WHERE name = ? AND password = ?";
        System.out.println("[Notice]searchNameAndPass start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getName());
            pst.setString(2, dto.getPassWord());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                int userID = rs.getInt("userID");
                String userName = rs.getString("name");
                String passWord = rs.getString("password");
                String mail = rs.getString("mail");
                String address = rs.getString("address");
                int total = rs.getInt("total");
                accountDTO = new UserDataDTO(userID, userName, passWord, mail, address, total);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        System.out.println("[Notice]searchNameAndPass finished");
        return accountDTO;
    }
    
    public void updateTotalMoney2User(UserDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "UPDATE user_t SET total = ? WHERE userID = ?;";
        System.out.println("[Notice]updateTotalMoney2User start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, dto.getSum());
            pst.setInt(2, dto.getUserID());
            pst.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        System.out.println("[Notice]updateTotalMoney2User finished");
    }
    
    public void insertTotalMoneyByParchase(UserDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO buy_t(userID, total, buyDate) VALUES(?,?,?)";
        System.out.println("[Notice]insertTotalMoneyByParchase start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, dto.getUserID());
            pst.setInt(2, dto.getSum());
            pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        System.out.println("[Notice]insertTotalMoneyByParchase finished");
    }
    
    public void updateUserInformations(UserDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "UPDATE user_t SET name = ?, password = ?, mail = ?, address = ? WHERE userID = ?;";
        System.out.println("[Notice]updateUserInformations start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getName());
            pst.setString(2, dto.getPassWord());
            pst.setString(3, dto.getMail());
            pst.setString(4, dto.getAddress());
            pst.setInt(5, dto.getUserID());
            pst.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        System.out.println("[Notice]updateUserInformations finished");
    }
    
    public void deleteUserData(UserDataDTO dto) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        UserDataDTO accountDTO = null;
        String sql = "DELETE FROM user_t WHERE userID = ?";
        System.out.println("[Notice]updateUserData start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, dto.getUserID());
            pst.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
            }
        }
        System.out.println("[Notice]updateUserInformations finished");
    }
}
