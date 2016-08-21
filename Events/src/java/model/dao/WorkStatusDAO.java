/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dto.WorkStatusDTO;

/**
 *
 * @author gest
 */
public class WorkStatusDAO {
    
    public static WorkStatusDAO getInstance(){
        return new WorkStatusDAO();
    }
    
    public Map<Integer,WorkStatusDTO> selectAllWorkStatusByEmpId(Integer emp_id){
        Connection        con       = null;
        PreparedStatement statement = null;
        //List<WorkStatusDTO> workStatusList = new ArrayList<>();
        Map<Integer,WorkStatusDTO> workStatusList = new HashMap<>();
        
        try{
            //DB接続からkaraSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "SELECT * FROm work_status"
                       + "WHERE emp_id      = ?"
                       + "AND   delete_flag = false";
            statement  = con.prepareStatement(sql);
            statement.setInt(1, emp_id);
            
            //SQLをDBMSに渡し、実行結果をリストに保存
            ResultSet result = statement.executeQuery();
            Integer keyCounter = 0;
            while(result.next()){
                keyCounter++;
                WorkStatusDTO workStatus = new WorkStatusDTO();
                workStatus.setWork_date  (result.getDate   ("work_date"));
                workStatus.setEmp_id     (result.getInt    ("emp_id"));
                workStatus.setWork_in    (result.getTime   ("work_in"));
                workStatus.setWork_out   (result.getTime   ("work_out"));
                workStatus.setRest_time  (result.getTime   ("rest_time"));
                workStatus.setWork_time  (result.getTime   ("work_time"));
                workStatus.setStatus     (result.getString ("status"));
                workStatus.setDelete_flag(result.getBoolean("delete_flag"));
                workStatusList.put(keyCounter,workStatus);
            }
            if(workStatusList.isEmpty()){
                workStatusList = null;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return workStatusList;
    }
    
    public WorkStatusDTO selectWorkStatusByEmpIdAndWorkDate(WorkStatusDTO dto){
        Connection        con        = null;
        PreparedStatement statement  = null;
        try{
            //DB接続からkaraSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "SELECT * FROm work_status"
                       + "WHERE emp_id      = ?"
                       + "AND   work_date   = ?"
                       + "AND   delete_flag = false";
            statement  = con.prepareStatement(sql);
            statement.setInt (1, dto.getEmp_id());
            statement.setDate(2, dto.getWork_date());
            
            //SQLをDBMSに渡し、実行結果をインスタンスに保存
            ResultSet result = statement.executeQuery();
            if(result.next()){
                dto.setWork_in    (result.getTime   ("work_in"));
                dto.setWork_out   (result.getTime   ("work_out"));
                dto.setRest_time  (result.getTime   ("rest_time"));
                dto.setWork_time  (result.getTime   ("work_time"));
                dto.setStatus     (result.getString ("status"));
                dto.setDelete_flag(result.getBoolean("delete_flag"));
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        
        return dto;
    }
    
    public WorkStatusDTO selectWorkStatusByEmpIdAndWorkDate(Integer emp_id, Date work_date){
        Connection        con        = null;
        PreparedStatement statement  = null;
        WorkStatusDTO     workStatus = null;
        try{
            //DB接続からkaraSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "SELECT * FROm work_status"
                       + "WHERE emp_id      = ?"
                       + "AND   work_date   = ?"
                       + "AND   delete_flag = false";
            statement  = con.prepareStatement(sql);
            statement.setInt (1, emp_id);
            statement.setDate(2, work_date);
            
            //SQLをDBMSに渡し、実行結果をインスタンスに保存
            ResultSet result = statement.executeQuery();
            if(result.next()){
                workStatus = new WorkStatusDTO();
                workStatus.setWork_date  (result.getDate   ("work_date"));
                workStatus.setEmp_id     (result.getInt    ("emp_id"));
                workStatus.setWork_in    (result.getTime   ("work_in"));
                workStatus.setWork_out   (result.getTime   ("work_out"));
                workStatus.setRest_time  (result.getTime   ("rest_time"));
                workStatus.setWork_time  (result.getTime   ("work_time"));
                workStatus.setStatus     (result.getString ("status"));
                workStatus.setDelete_flag(result.getBoolean("delete_flag"));
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return workStatus;
    }
    
    public Boolean insertWorkInByEmpId(WorkStatusDTO workStatus){
        Connection        con       = null;
        PreparedStatement statement = null;
        Boolean           isResult  = false; 
        
        try{
            //DB接続からkaraSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "INSERT INTO work_status"
                       + "(work_date,"  //1
                       + " emp_id,"     //2     
                       + " work_in) "   //3
                       + "VALUES(?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setDate(1,workStatus.getWork_date());
            statement.setInt (2,workStatus.getEmp_id());
            statement.setTime(3,workStatus.getWork_in());
            
            //SQLをDBMSに渡し、実行結果をBoolean型に変換
            int insertResult = statement.executeUpdate();
            if(insertResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
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
    
    public Boolean updateWorkStatusByEmpIdAndWorkDate(WorkStatusDTO workStatus){
        Connection        con       = null;
        PreparedStatement statement = null;
        Boolean           isResult  = false; 
        
        try{
            //DB接続からSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "UPDATE work_status"
                       + "SET work_in     = ?," //1
                       + "    work_out    = ?," //2
                       + "    rest_time   = ?," //3
                       + "    work_time   = ?," //4
                       + "    status      = ?," //5
                       + "    delete_flag = ?"  //6
                       + "WHERE emp_id    = ?"  //7
                       + "AND   work_date = ?"; //8
            statement = con.prepareStatement(sql);
            statement.setDate   (1,workStatus.getWork_date());
            statement.setTime   (2,workStatus.getWork_in());
            statement.setTime   (3,workStatus.getRest_time());
            statement.setTime   (4,workStatus.getWork_out());
            statement.setString (5,workStatus.getStatus());
            statement.setBoolean(6,workStatus.getDelete_flag());
            statement.setInt    (7,workStatus.getEmp_id());
            statement.setDate   (8,workStatus.getWork_date());
            
            //SQLをDBMSに渡し、実行結果をBoolean型に変換
            int insertResult = statement.executeUpdate();
            if(insertResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
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
    
    //論理削除を行うため、SQL文自体はUPDATEとなる
    public Boolean deleteWorkStatusByEmpIdAndWorkDate(WorkStatusDTO workStatus){
        Connection        con       = null;
        PreparedStatement statement = null;
        Boolean           isResult  = false; 
        
        try{
            //DB接続からSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "UPDATE work_status"
                       + "SET   delete_flag = ?"  //1
                       + "WHERE emp_id      = ?"  //2
                       + "AND   work_date   = ?"; //3
            statement = con.prepareStatement(sql);
            statement.setBoolean(1,workStatus.getDelete_flag());
            statement.setInt    (2,workStatus.getEmp_id());
            statement.setDate   (3,workStatus.getWork_date());
            
            //SQLをDBMSに渡し、実行結果をBoolean型に変換
            int insertResult = statement.executeUpdate();
            if(insertResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
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
    
    //特定の社員の勤怠情報を論理削除する
    public Boolean deleteAllWorkStatusByEmpId(WorkStatusDTO workStatus){
        Connection        con       = null;
        PreparedStatement statement = null;
        Boolean           isResult  = false; 
        
        try{
            //DB接続からSQL作成まで
            con = DBConnector.getInstance().dbConnect();
            String sql = "UPDATE work_status"
                       + "SET   delete_flag = ?"  //1
                       + "WHERE emp_id      = ?"; //2
            statement = con.prepareStatement(sql);
            statement.setBoolean(1,workStatus.getDelete_flag());
            statement.setInt    (2,workStatus.getEmp_id());
            
            //SQLをDBMSに渡し、実行結果をBoolean型に変換
            int insertResult = statement.executeUpdate();
            if(insertResult == 0){
                return isResult;
            }else{
                isResult = true;
            }
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            try{
                if(statement != null){
                    statement.close();
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
