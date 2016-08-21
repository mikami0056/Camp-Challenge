/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.EventJoinDAO;
import model.dao.EventsDAO;
import model.dto.EventsDTO;

/**
 *
 * @author gest
 */
public class EventsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
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
        //文字コード設定
        request.setCharacterEncoding("UTF-8");
        //セッションの取得
        HttpSession session = request.getSession();
        //遷移先を取得
        String option = (String)request.getAttribute("option");
        switch(option){
            //イベント一覧
            case "list":
                //全イベント情報の取得
                List<EventsDTO> eventList = EventsDAO.getInstance().selectAllEvents();
                session.setAttribute("eventList",eventList);
                request.getRequestDispatcher("eventlist.jsp").forward(request,response);
                break;
                
            //イベント詳細
            case "detail":
                String eventName  = request.getParameter("eventName");
                String strEventId = request.getParameter("eventId");
                Integer eventId   = Integer.parseInt(strEventId);
                //特定のイベント情報取得
                EventsDTO event = EventsDAO.getInstance().selectEventByEventNameAndEventId(eventName,eventId);
                //イベントに参加する社員情報取得
                List<Integer> empIdList = EventJoinDAO.getInstance().selectEmpIdByEventId(eventId);
                session.setAttribute("event",event);
                session.setAttribute("empIdList",empIdList);
                request.getRequestDispatcher("eventdetail.jsp").forward(request,response);
                break;
                
            //社員のイベント参加
            case "join":
                String  strEmpId   = request.getParameter("empId");
                Integer empId      = Integer.parseInt(strEmpId);
                        strEventId = request.getParameter("eventId");//case detailで宣言済み
                        eventId    = Integer.parseInt(strEventId);   //case detailで宣言済み
                
                Boolean isResult   = EventJoinDAO.getInstance().insertEmpIdWithEventId(empId,eventId);
                if(isResult){
                    request.setAttribute("isResult", isResult);
                    request.getRequestDispatcher("eventdetail.jsp").forward(request,response);
                }else{
                    request.setAttribute("isResult", isResult);
                    request.getRequestDispatcher("eventdetail.jsp").forward(request,response);
                }
                break;
            //メニュー画面へ    
            case "menu":
                request.setAttribute("option","back");
                request.getRequestDispatcher("MenuController").forward(request,response);
                break;
                
            default:
                request.setAttribute("caution", "想定外の事態が発生しました");
                request.getRequestDispatcher("menu.jsp").forward(request,response);
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
