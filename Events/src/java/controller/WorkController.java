/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;

import model.beans.EmployeeBeans;
import model.dao.WorkStatusDAO;
import model.dto.EmployeesDTO;
import model.dto.WorkStatusDTO;
import model.logic.WorkStatusLogic;

/**
 *
 * @author gest
 */
public class WorkController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        EmployeesDTO employee = (EmployeesDTO)session.getAttribute("employee");
        
        String option = request.getParameter("option");
        if(option == null){option="ajax";}
        switch(option){
            case "list":
                Integer empId = employee.getEmp_id();
                Map<Integer,WorkStatusDTO> workStatusList = WorkStatusDAO.getInstance().selectAllWorkStatusByEmpId(empId);
                session.setAttribute("workStatusList",workStatusList);
                request.getRequestDispatcher("WEB-INF/workstatuslist.jsp").forward(request, response);
                break;
            
            case "edit":
                //編集対象の勤怠情報を持つDTOを特定するためにMapのキーを取得
                String  strStatusKey            = request.getParameter("statusKey");
                Integer statusKey               = Integer.parseInt(strStatusKey);
                
                //キーを元に編集対象の勤怠情報をDBから取得
                WorkStatusDTO tempDTO           = ((Map<Integer,WorkStatusDTO>)session.getAttribute("workStatusList")).get(statusKey);
                WorkStatusDTO workStatusForEdit = WorkStatusDAO.getInstance().selectWorkStatusByEmpIdAndWorkDate(tempDTO);
                session.setAttribute("workStatusForEdit", workStatusForEdit);
                request.getRequestDispatcher("WEB-INF/workstatusedit.jsp").forward(request, response);
                break;
                
            case "update":
                break;
                
            case "delete":
                break;
                
            case "ajax":
                try{
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json; charset=utf-8");

                    String param = request.getParameter("param");
                    String type  = request.getParameter("type");

                    //ログインしている社員の情報を取得
                    WorkStatusLogic Logic = new WorkStatusLogic();

                    switch(type){
                    case "in":
                        //社員情報と出勤時刻を登録
                        WorkStatusDTO workStatusIn = Logic.setWorkInToDB(param,employee);
                        session.setAttribute("workStatus",workStatusIn);
                        out.print(JSON.encode(workStatusIn.getWork_in()));
                        break;

                    case "out":
                        WorkStatusDTO workStatusOut = Logic.setWorkOutToDB(param,employee);
                        Boolean isExist= Logic.checkWorkStatusPropatiesIsExist(workStatusOut);
                        if(isExist){
                            session.setAttribute("workStatus",workStatusOut);
                            out.print(JSON.encode(workStatusOut.getWork_out()));
                        }else{
                            out.print(JSON.encode("エラー発生"));
                        }
                        break;
                    }     
                }catch(ParseException pe){
                    pe.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
