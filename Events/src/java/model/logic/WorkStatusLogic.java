/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.beans.EmployeeBeans;
import model.dao.WorkStatusDAO;
import model.dto.EmployeesDTO;
import model.dto.WorkStatusDTO;

/**
 *
 * @author gest
 */
public class WorkStatusLogic {
    
    public WorkStatusDTO setWorkInToDB(String param,EmployeesDTO employee) throws ParseException,Exception{
        
        //画面で入力されたエポック秒をjava.util.Date型に変換
        Long epochTime = Long.parseLong(param);
        Date work_in = new Date(epochTime);
        
        //時刻変換インスタンスを使用してjava.util.Date型からjava.sql.Date型とTime型に変換
        ConvertingTimeLogic timeConverter = new ConvertingTimeLogic();
        java.sql.Date sqlDate = timeConverter.toSqlDate(work_in);
        java.sql.Time sqlTime = timeConverter.toSqlTime(work_in);
        
        //社員情報と勤怠情報を格納
        WorkStatusDTO statusDTO = new WorkStatusDTO(employee,sqlDate,sqlTime);
        
        //各情報(社員ID、勤怠の日付、出勤時刻)をDBに格納
        WorkStatusDAO statusDAO = new WorkStatusDAO();
        Boolean isResult = statusDAO.insertWorkInByEmpId(statusDTO);
        if(!isResult){
            throw new Exception();
        }
        return  statusDTO;
    }
    
    public WorkStatusDTO setWorkOutToDB(String param,EmployeesDTO employee) throws ParseException{
        //画面で入力されたエポック秒をjava.util.Date型に変換
        Long epochTime = Long.parseLong(param);
        Date work_out = new Date(epochTime);
        
        //時刻変換インスタンスを使用してjava.util.Date型からjava.sql.Date型とTime型に変換
        ConvertingTimeLogic timeConverter = new ConvertingTimeLogic();
        java.sql.Date sqlDate = timeConverter.toSqlDate(work_out);
        java.sql.Time sqlTime = timeConverter.toSqlTime(work_out);
        
        //DBに接続し、年月日と社員IDを元に情報を取得
        WorkStatusDAO statusDAO = new WorkStatusDAO();
        Integer emp_id = employee.getEmp_id();
        WorkStatusDTO statusDTO = statusDAO.selectWorkStatusByEmpIdAndWorkDate(emp_id, sqlDate);
        
        //退勤時刻、勤務時間、休憩時間、状況を入力
        statusDTO.setWork_out(sqlTime);
        calculateWorkTime(statusDTO);
        statusDTO.setStatus("出");
        
        //各情報が入力されたインスタンスを返す
        return statusDTO;
    }
    
    public void calculateWorkTime(WorkStatusDTO workStatus) throws ParseException{
        
        //出勤時刻、退勤時刻をjava.sql.Date,Timeからjava.util.Dateへ変換
        ConvertingTimeLogic timeConverter = new ConvertingTimeLogic();
        java.sql.Date work_date = workStatus.getWork_date();
        java.sql.Time work_in   = workStatus.getWork_in();
        java.sql.Time work_out  = workStatus.getWork_out();
        Date utilDateWork_in  = timeConverter.toUtilDateFromSqlDateAndSqlTime(work_date, work_in);
        Date utilDateWork_out = timeConverter.toUtilDateFromSqlDateAndSqlTime(work_date, work_out);
        
        //出勤、退勤の差から勤務時間を算出、休憩時間分の1時間分(3600000ミリ秒)を引く
        long timeDiff = (utilDateWork_out.getTime() - utilDateWork_in.getTime()) - 3600000L;
        long minutes  = (timeDiff/1000/60)%60;
        long hours    = (timeDiff/1000/60/60)%24;
        
        String strMinutes = null;
        if(10 > minutes){
            strMinutes = "0" + String.valueOf(minutes);
        }else{
            strMinutes = String.valueOf(minutes);
        }
        
        String strHours= null;
        if(10 > hours){
            strHours = "0" + String.valueOf(hours);
        }else{
            strHours = String.valueOf(hours);
        }
        
        workStatus.setWork_time_str(strHours + ":" + strMinutes);
        workStatus.setRest_time_str(3600000L);
    }
    
    public void calculateWorkTime(WorkStatusDTO workStatus, Long rest_time) throws ParseException{
        
        ConvertingTimeLogic timeConverter = new ConvertingTimeLogic();
        java.sql.Date work_date = workStatus.getWork_date();
        java.sql.Time work_in   = workStatus.getWork_in();
        java.sql.Time work_out  = workStatus.getWork_out();
        
        Date utilDateWork_in  = timeConverter.toUtilDateFromSqlDateAndSqlTime(work_date, work_in);
        Date utilDateWork_out = timeConverter.toUtilDateFromSqlDateAndSqlTime(work_date, work_out);

        long timeDiff = (utilDateWork_out.getTime() - utilDateWork_in.getTime()) - rest_time;
        long minutes  = (timeDiff/1000/60)%60;
        long hours    = (timeDiff/1000/60/60)%24;
        
        String strMinutes = null;
        if(10 > minutes){
            strMinutes = "0" + String.valueOf(minutes);
        }else{
            strMinutes = String.valueOf(minutes);
        }
        
        String strHours= null;
        if(10 > hours){
            strHours = "0" + String.valueOf(hours);
        }else{
            strHours = String.valueOf(hours);
        }        
    }
    
    public Long calculateRestTime(int hours,int minutes){
        if(minutes > 59){
            return 0L;
        }
        Calendar base = Calendar.getInstance();
        base.set(2016,1,1,0,0,0);
        Calendar rest = Calendar.getInstance();
        rest.set(2016,1,1,hours,minutes,0);
        Date baseDate = base.getTime();
        Date restDate = rest.getTime();
        Long timeDiff = (restDate.getTime() - baseDate.getTime());
        
        return timeDiff;
    }
    
    public Boolean checkWorkStatusPropatiesIsExist(WorkStatusDTO dto){
        if(dto.getWork_date()     == null){return false;}
        if(dto.getEmp_id()        == null){return false;}
        if(dto.getWork_in()       == null){return false;}
        if(dto.getWork_out()      == null){return false;}
        if(dto.getRest_time_str() == null){return false;}
        if(dto.getWork_time_str() == null){return false;}
        if(dto.getStatus()        == null){return false;}
        if(dto.getDelete_flag()   == null){return false;}
        return true;
    }
}
