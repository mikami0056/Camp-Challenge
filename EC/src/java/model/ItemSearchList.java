/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.ItemSearch;
import model.Common;
import org.xml.sax.SAXException;

/**
 *
 * @author SHO
 */
public class ItemSearchList {
    public ItemSearchList(){}
    
    private URL url;
    private String query;
    private String sort;
    private String categoryID;
    private String keywords4URL;
    private Document doc;
    private final static String appID = "dj0zaiZpPXplbVJNd3J4UXR4WCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjI-";
    private final static String baseURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    
   
    public void setQuery(String query){
        //入力フォーム内容のチェック
        if(!query.isEmpty() || !("".equals(query))){
            this.query = query;
        } else {
            this.query = "";
        }
    }
    
    //テスト
    public String connectURL() throws MalformedURLException, IOException, ParserConfigurationException, SAXException{
        String rootName="";
        if(!"".equals(this.query)){
            String strURL = baseURL + "?appid=" + this.appID + "&query=" + this.query + "&category_id=" + this.categoryID + "&sort=" + this.sort;
            this.url = new URL(strURL);
            
            HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
            urlCon.setRequestMethod("GET");
            urlCon.setInstanceFollowRedirects(false);
            urlCon.connect();
            
            
            
            try{
                Document doc = getDocument(urlCon.getInputStream());
                Element root = doc.getDefaultRootElement();
                rootName = root.getName();
                
                
                
            }catch(SAXException e){
                e.printStackTrace();
            }catch(ParserConfigurationException e){
                e.printStackTrace();
            } 
            
            
            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            StringBuffer responseBuffer = new StringBuffer();
            while(true){
                String line = reader.readLine();
                if(line == null){
                break;
                }
                responseBuffer.append(line);
            }
            
            reader.close();
            urlcon.disconnect();
            
            String response = responseBuffer.toString();
            */
        }
        return rootName;
    }
    
    private static Document getDocument(InputStream is) throws ParserConfigurationException, IOException, SAXException{
        //パーサを生成
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        //パースして返す
        return (Document)docBuilder.parse(is);
    }
    
    
    
}
