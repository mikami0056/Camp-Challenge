package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.geometry.Side;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    //変更点:返り値の型, [UserDataDTO]から[ArrayList], 取得情報が複数の際に対応するため
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        //追加点:DBから得た複数のユーザー情報保存用
        ArrayList<UserDataDTO> searchList = new ArrayList<UserDataDTO>();
        String errorTest ="なし";
        try{
            con = DBManager.getConnection();       
 
            String sql = "SELECT * FROM user_t";
            String method = ""; //追加点:検索方法判別用変数
            boolean flag = false;
            
            //追加点:検索方法(AND, OR, 全件検索)の判別
            switch(ud.getSearchMethod()){
                case 1:
                    method = " AND ";
                    break;
                case 2:
                    method = " OR ";
                    break;
            }

            //名前に関するSQL
            if (!ud.getName().equals("") || ud.getName().length()!=0) {
                sql += " WHERE name like \'%" +ud.getName()+ "%\'";
                flag = true;
            }
                
            //誕生日に関するSQL
            if (ud.getBirthday()!=null) {
                System.out.println("B"+new SimpleDateFormat("yyyy").format(ud.getBirthday()));
                if(!flag){
                    sql += " WHERE birthday like \'%" +new SimpleDateFormat("yyyy").format(ud.getBirthday())+ "%\'";
                    flag = true;
                }else{
                    //変更点:変数methodを追加
                    sql += method + "birthday like \'%" +new SimpleDateFormat("yyyy").format(ud.getBirthday())+ "%\'";
                }
            }
                
            //職種に関するSQL
            if (ud.getType()!=0) {
                System.out.println("C"+ud.getType());
                if(!flag){
                    sql += " WHERE type like " +ud.getType();
                }else{
                    //変更点:変数methodを追加
                    sql += method + "type like " +ud.getType();
                }
            }
            
            //追加点:画面表示の際にID順に表示させるため
            sql += " ORDER BY userID DESC";
            System.out.println(sql);
            
            st =  con.prepareStatement(sql);
            /*
            st.setString(1, "%"+ud.getName()+"%");
            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            st.setInt(3, ud.getType());
            */
            
            ResultSet rs = st.executeQuery();
            //追加点:while文を追加, 複数ユーザー情報を取得するため
            while(rs.next()){
                //int index = 0; //ArrayList要素数用
                
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setName(rs.getString("name"));
                resultUd.setBirthday(rs.getDate("birthday"));
                resultUd.setTell(rs.getString("tell"));
                resultUd.setType(rs.getInt("type"));
                resultUd.setComment(rs.getString("comment"));
                resultUd.setNewDate(rs.getTimestamp("newDate"));
                
                searchList.add(resultUd);
            }
            
            System.out.println("search completed");
            //変更点:戻り値をsearchListに変更
            return searchList;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    //追加点:updateメソッド, deleteメソッドをそれぞれ追加 ここから
    /**
     * ユーザーIDによる1件のデータの更新処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 更新結果
     */
    public UserDataDTO update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "UPDATE user_t SET name=?, birthday=?, tell=?, type=?, comment=?, newDate=? WHERE userID=?";
            
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());

            st.executeUpdate();
            
            //変更後の情報を表示するためにsearchByIDメソッドを使用
            UserDataDTO resultUd = new UserDataDTO();
            resultUd = this.searchByID(ud);
            
            System.out.println("update completed");

            return resultUd;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
                
            }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの物理削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 無し
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "DELETE FROM user_t WHERE userID=?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            st.executeUpdate();
            
            System.out.println("delete completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
            
        }finally{
            if(con != null){
                con.close();
                
            }
        }
    }
    //追加点:updateメソッド, deleteメソッドをそれぞれ追加 ここまで
}
