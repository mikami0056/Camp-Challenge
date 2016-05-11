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
        String sql = "SELECT name, password, mail, address FROM user_t WHERE name = ? AND password = ?";
        System.out.println("searchNameAndPass start");
        
        try{
            
            con = DBManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getName());
            pst.setString(2, dto.getPassWord());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                String userName = rs.getString("name");
                String passWord = rs.getString("password");
                String mail = rs.getString("mail");
                String address = rs.getString("address");
                accountDTO = new UserDataDTO(userName, passWord, mail, address);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
        return accountDTO;
    }
    
    
}
