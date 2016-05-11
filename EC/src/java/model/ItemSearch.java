/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Common;
import model.ItemDetails;
/**
 *
 * @author SHO
 */
public class ItemSearch {
    private URL url;
    private String query;
    private String sort;
    private Integer categoryID;
    private String keywords4URL;
    
    private final static String appID = "dj0zaiZpPXplbVJNd3J4UXR4WCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjI-";
    private final static String baseURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    private Common con = null;
    
    public ItemSearch(){
        String query = "";
        String sort = "";
        Integer categoryID = 0;
        con = new Common();
    }
    
    public static ItemSearch getInstance(){
        return new ItemSearch();
    }
    
    public Map<String, ItemDetails> execute (String query, String category, String sort) throws MalformedURLException, IOException{
        
        //入力された各項目の確認
        checkKeyWords(query, category, sort);
        //フォームから取得した情報をURL
        URL urll = new URL(convertURL(this.query, this.sort, this.categoryID));
        //URLで接続
        HttpURLConnection urllCon = connection2Yahoo(urll);
        //取得した商品を格納するMap
        Map<String, ItemDetails> itemDetailList = new LinkedHashMap<>();
        
        try {
            //YahooからXMLドキュメントを取得
            Document doc = getDocumentFromYahoo(urllCon);
            
            if(doc.hasChildNodes()){
                //XMLドキュメント内のHit要素を取得
                List<Element> Hits = getElementsNamedHit(doc);
                //Hit要素内の各子要素を取得
                for(Element el : Hits){
                    
                    String index = el.getAttribute("index");
                    ItemDetails itemDetails = new ItemDetails();
                    itemDetails.setPropaty("ProductID",getElementByName(el, "ProductId"));
                    itemDetails.setPropaty("Name",getElementByName(el, "Name"));
                    Element image = getElementByName(el, "Image");
                    itemDetails.setPropaty("Medium",getElementByName(image, "Medium"));
                    itemDetails.setPropaty("Price",getElementByName(el, "Price"));
                    itemDetails.setPropaty("Stock",getElementByName(el, "Availability"));
                    
                    //取得した商品を格納するMapにindexと商品を紐付けて保存
                    itemDetailList.put(index, itemDetails);
                }
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ItemSearch.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            urllCon.disconnect();
            return itemDetailList;
        }
        
    }
   
    public void checkKeyWords(String query, String category, String sort){
        System.out.println("入力フォームの確認を始めます");
        Map<String, String> sortList = con.getSortOrder();
        Map<String, String> categoryList = con.getCategories();
        
        //キーワードの確認
        if(!query.isEmpty() || !("".equals(query))){
            this.query = query;
        } else {
            this.query = "";
        }
        System.out.println("キーワードOK");
        
        //並び順の確認
        if(!sort.isEmpty() && sortList.containsKey(sort)){
            this.sort = sort;
        }else{
            this.sort = "-score";
        }
        System.out.println("並び順OK");
        
        //カテゴリーの確認
        if(category.matches("[0-9]+") && categoryList.containsKey(category)){
            this.categoryID = Integer.parseInt(category);
        } else {
            this.categoryID = 1;
        }
        System.out.println("カテゴリーOK");
        System.out.println("入力フォームの確認が終了しました");
    }
    
    private String convertURL(String query, String sort, Integer categoryID) throws MalformedURLException{
        System.out.println("URLの文字列からの変換を始めます");
        String strURL = baseURL + "?appid=" + this.appID + "&query=" + query + "&category_id=" + categoryID + "&sort=" + sort;
        //this.url = new URL(strURL);
        System.out.println("URLの文字列からの変換が終了しました");
        return strURL;
        
    }
    
    public HttpURLConnection connection2Yahoo(URL url) throws IOException{
        HttpURLConnection urllCon = (HttpURLConnection)url.openConnection();
        urllCon.setRequestMethod("GET");
        urllCon.setInstanceFollowRedirects(false);
        urllCon.connect();
        System.out.println("XMLドキュメントを取得しました");
        return urllCon;
    }
    
    public Document getDocumentFromYahoo(HttpURLConnection urllCon) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(urllCon.getInputStream());
        return doc;
    }
    
    /*
    private String convert(String inputStr){
        return inputStr.replace("&", "&amp;")
                       .replace("\"", "&quot;")
                       .replace("<", "&lt;")
                       .replace(">", "&gt;")
                       .replace("'", "&#39;");           
    }
    */
        
    private ArrayList<Element> getElementsNamedHit (Document doc) throws Exception{
        Element ResultSet = doc.getDocumentElement();
        Element Result = getElementByName(ResultSet, "Result");
        ArrayList<Element> Hits = getElementsListByName(Result, "Hit");
        return Hits;
    }

    private static Element getElementByName(Element el, String name) throws Exception{
        NodeList children =el.getChildNodes();
        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i) instanceof Element){
                Element e = (Element)children.item(i);
                if(e.getTagName().equals(name)){
                    return e;
                }
            }
        }
        
        return null;
    }
    
    private static ArrayList<Element> getElementsListByName(Element el, String name) throws Exception{
        NodeList children =el.getChildNodes();
        ArrayList<Element> arrayHits = new ArrayList<>();
        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i) instanceof Element){
                Element e = (Element)children.item(i);
                if(e.getTagName().equals(name)){
                    arrayHits.add(e);
                }
            }
        }
        
        return arrayHits;
    }
    
    


    
    
}
