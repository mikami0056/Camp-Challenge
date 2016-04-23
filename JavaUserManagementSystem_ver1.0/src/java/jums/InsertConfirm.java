package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");
            
            Boolean check = true;   //追加点(課題3):フォーム入力有無確認用 
            String caution = "";    //追加点(課題3):フォーム未入力時警告用
            
            //セッションに格納
            session.setAttribute("name", name);
            //追加点(課題3):未入力または半角空欄が入力されている場合, 以下同じ
            if("".equals(name) || name.trim().length() == 0){
                check = false;
                caution = "・名前<br>";
            }
            
            session.setAttribute("year", year);
            //追加点(課題3)
            if("".equals(year)){
                check = false;
                caution += "・年<br>";
            }
            
            session.setAttribute("month",month);
            //追加点(課題3)
            if("".equals(month)){
                check = false;
                caution += "・月<br>";
            }
            
            session.setAttribute("day", day);
            //追加点(課題3)
            if("".equals(day)){
                check = false;
                caution += "・日<br>";
            }
            
            session.setAttribute("type", type);
            //追加点(課題3)
            if("".equals(type)){
                check = false;
                caution += "・職種<br>";
            }
            
            session.setAttribute("tell", tell);
            //追加点(課題3)
            if("".equals(tell) || tell.trim().length() == 0){
                check = false;
                caution += "・電話<br>";
            }
            
            session.setAttribute("comment", comment);
            //追加点(課題3)
            if("".equals(comment)){
                check = false;
                caution += "・自己紹介<br>";
            }
            
            //追加点(課題3):フォーム入力有無確認用
            session.setAttribute("check", check);
            //追加点(課題3):フォーム未入力時警告用
            session.setAttribute("caution", caution);
            
            System.out.println("Session updated!!");
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
