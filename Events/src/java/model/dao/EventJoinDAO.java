/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dto.EventJoinDTO;
import model.dto.EventsDTO;

/**
 *
 * @author gest
 */
public class EventJoinDAO {
    public static EventJoinDAO getInstance(){
        return new EventJoinDAO();
    }
    
    public List<Integer> selectEmpIdByEventId(Integer event_id){
        Connection con = null;
        PreparedStatement ps = null;
        List<Integer> empIdList = new ArrayList<>();
        
        try{
            
            con = DBConnector.getInstance().dbConnect();
            String sql  = "SELECT DISTINCT emp_id FROM eventjoin WHERE event_id = ?";
            ps  = con.prepareStatement(sql); 
            ps.setInt(1,event_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer emp_name = rs.getInt("emp_id");
                empIdList.add(emp_name);
            }
            
            if(empIdList.isEmpty()){
                empIdList = null;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return empIdList;
    }
    
    public List<Integer> selectEventIdByEmployeeId(Integer emp_id){
        Connection con = null;
        PreparedStatement ps = null;
        List<Integer> eventIdList = new ArrayList<>();
        
        try{
            
            con = DBConnector.getInstance().dbConnect();
            String sql  = "SELECT DISTINCT event_id FROM eventjoin WHERE emp_id = ?";
            ps  = con.prepareStatement(sql); 
            ps.setInt(1,emp_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer emp_name = rs.getInt("event_id");
                eventIdList.add(emp_name);
            }
            
            if(eventIdList.isEmpty()){
                eventIdList = null;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return eventIdList;
    }
    
    public Boolean insertEmpIdWithEventId(Integer emp_id,Integer event_id){
        Connection con = null;
        PreparedStatement ps = null;
        Boolean isResult = false;
        
        try{
            
            con = DBConnector.getInstance().dbConnect();
            //特定のイベントに、社員がもうすでに参加しているかどうかを確認. 
            String preSql = "SELECT emp_id FROM eventjoin WHERE event_id = ?";
            ps = con.prepareStatement(preSql);
            ps.setInt(1,event_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(emp_id == rs.getInt("emp_id")){
                    return isResult;
                }
            }
            
            String sql  = "INSERT INTO eventjoin VALUES(?,?)";
            ps  = con.prepareStatement(sql); 
            ps.setInt(1,event_id);
            ps.setInt(2,emp_id);
            
            int updateResult = ps.executeUpdate();
            
            if(updateResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return isResult;
    }
    
    public Boolean deleteEventId(Integer event_id){
        Connection con = null;
        PreparedStatement ps = null;
        Boolean isResult = false;
        
        try{
            
            con = DBConnector.getInstance().dbConnect();
            String sql  = "DELETE FROM eventjoin WHERE event_id = ?";
            ps  = con.prepareStatement(sql); 
            ps.setInt(1,event_id);
            
            int updateResult = ps.executeUpdate();
            
            if(updateResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return isResult;
    }
    
    public Boolean deleteByEmpId(Integer emp_id){
        Connection con = null;
        PreparedStatement ps = null;
        Boolean isResult = false;
        
        try{
            
            con = DBConnector.getInstance().dbConnect();
            String sql  = "DELETE FROM eventjoin WHERE emp_id = ?";
            ps  = con.prepareStatement(sql); 
            ps.setInt(1,emp_id);
            
            int updateResult = ps.executeUpdate();
            
            if(updateResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return isResult;
    }
}
