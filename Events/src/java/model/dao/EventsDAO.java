/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dto.EmployeesDTO;
import model.dto.EventsDTO;

/**
 *
 * @author gest
 */
public class EventsDAO {
    
    public static EventsDAO getInstance(){
        return new EventsDAO();
    }
    
    public List<EventsDTO> selectAllEvents(){
        Connection con = null;
        PreparedStatement ps = null;
        List<EventsDTO> eventList = new ArrayList<>();
        try{
            con = DBConnector.getInstance().dbConnect();
            String sql = "SELECT * FROM events WHERE deadline > ?";
            ps = con.prepareStatement(sql);
            //
            Date now = new Date();
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                EventsDTO event = new EventsDTO();
                event.setEvent_id    (rs.getInt("event_id"));
                event.setEvent_name  (rs.getString("event_name"));
                event.setEvent_date  (rs.getDate("event_date"));
                event.setEvent_time  (rs.getTime("event_time"));
                event.setEvent_place (rs.getString("event_place"));
                event.setEvent_detail(rs.getString("event_detail"));
                event.setEmp_id      (rs.getInt("emp_id"));
                event.setDeadline    (rs.getDate("deadline"));
                eventList.add(event);
            }
            if(eventList.isEmpty()){
                eventList = null;
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
        return eventList;
    }
    
    public EventsDTO selectEventByEventNameAndEventId(String event_name,Integer event_id){
        Connection con = null;
        PreparedStatement ps = null;
        EventsDTO event = null;
        try{
            con = DBConnector.getInstance().dbConnect();
            String sql = "SELECT * FROM events "
                       + "WHERE event_name = ? "
                       + "AND   event_id   = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,event_name);
            ps.setInt   (2,event_id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                event = new EventsDTO();
                event.setEvent_id    (rs.getInt("event_id"));
                event.setEvent_name  (rs.getString("event_name"));
                event.setEvent_date  (rs.getDate("event_date"));
                event.setEvent_time  (rs.getTime("event_time"));
                event.setEvent_place (rs.getString("event_place"));
                event.setEvent_detail(rs.getString("event_detail"));
                event.setEmp_id      (rs.getInt("emp_id"));
                event.setDeadline    (rs.getDate("deadline"));
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
        return event;
    }
    
    public Boolean insertEvent(EventsDTO event,EmployeesDTO employee){
        Connection con = null;
        PreparedStatement ps = null;
        Boolean isResult = false;
        
        try{
            con = DBConnector.getInstance().dbConnect();
            String sql = "INSERT INTO events"
                       + "(event_name,"     //1
                       + " event_date,"     //2    
                       + " event_time,"     //3
                       + " event_place,"    //4
                       + " event_datail,"   //5
                       + " emp_id,"         //6
                       + " deadline) "      //7
                       + "VALUES(?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            ps.setString (1,event.getEvent_name());
            ps.setDate   (2,event.getEvent_date());
            ps.setTime   (3,event.getEvent_time());
            ps.setString (4,event.getEvent_place());
            ps.setString (5,event.getEvent_detail());
            ps.setInt    (6,employee.getEmp_id());
            ps.setDate   (7,event.getDeadline());
            
            int insertResult = ps.executeUpdate();
            if(insertResult == 0){
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
    
    public Boolean deleteEvent(EventsDTO event,EmployeesDTO employee){
        Connection con = null;
        PreparedStatement ps = null;
        Boolean isResult = false;
        
        try{
            con = DBConnector.getInstance().dbConnect();
            String sql = "DELETE FROM events "
                       + "WHERE event_id = ? "  //1
                       + "AND   emp_id   = ?";  //2
            
            ps = con.prepareStatement(sql);
            ps.setInt(1,event.getEvent_id());
            ps.setInt(2,employee.getEmp_id());
            
            int deleteResult = ps.executeUpdate();
            if(deleteResult == 0){
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
