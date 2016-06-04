/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author gest
 */
public class HandleRecaptchaLogic {
    
    private final String baseURL = "https://www.google.com/recaptcha/api/siteverify?secret=";
    private final String secretKey = "6Ldh7yATAAAAALd1so7aukMFOHkahuwbIWd9t-9D";
    private String remoteIp;
    private String response;
    
    public HandleRecaptchaLogic(){}
    public HandleRecaptchaLogic(String remoteIp, String response){
        this.remoteIp = remoteIp;
        this.response = response;
    }
    
    public static HandleRecaptchaLogic getInstance(Object x, Object y){
        //入力判断
        String remoteIp = "";
        String response = "";
        
        if(x != null && y != null){
            
            if(x instanceof String && x.equals("0:0:0:0:0:0:0:1")){
                remoteIp = (String)x;
            }else if(x instanceof String){
                response = (String)x;
            }
            
            if(y instanceof String && y.equals("0:0:0:0:0:0:0:1")){
                remoteIp = (String)y;
            }else if(y instanceof String){
                response = (String)y;
            } 
        }
        return new HandleRecaptchaLogic(remoteIp, response);
    }

    public boolean connection2Google(){
        //リクエストと秘密鍵をGoogleReCaptchaに送る
        HttpURLConnection conn = null;
        boolean varified = false;
        try{
            URL url = new URL(this.baseURL + this.secretKey + "&response=" + response + "&remoteip=" + this.remoteIp);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while((line = reader.readLine()) != null){
                outputString += line;  
            }
            
            System.out.println(outputString);
            CaptchaResponseLogic capRes = new Gson().fromJson(outputString, CaptchaResponseLogic.class);
            
            if(capRes.isSuccess()){
                varified = true;
            }
        
        }catch(MalformedURLException mue){
            mue = new MalformedURLException("URLに関するエラーです");
            System.out.println(mue);
            
        }catch(ProtocolException pe){
            pe = new ProtocolException("URLに関するエラーです");
            System.out.println(pe);
            
        }catch(IOException ioe){
            ioe = new IOException("接続に関するエラーです");
            System.out.println(ioe);
            
        }finally{
            conn.disconnect();
            return varified;
        }
    }
    
    
    
    
}
