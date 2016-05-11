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

/**
 *
 * @author SHO
 */
public class ItemSearch {
    private URL url;
    private String query;
    private String sort;
    private String categoryID;
    private String keywords4URL;
    
    private final static String appID = "dj0zaiZpPXplbVJNd3J4UXR4WCZzPWNvbnN1bWVyc2VjcmV0Jng9ZjI-";
    private final static String baseURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    
    public ItemSearch(){}
    
    public static ItemSearch getInstance(){
        return new ItemSearch();
    }
    
    public void setQuery(String query){
        //入力フォーム内容のチェック
        if(!query.isEmpty() || !("".equals(query))){
            this.query = query;
        } else {
            this.query = "";
        }
    }
    public String getQuery(){
        return this.query;
    }
    
    public void setSort(String sort, Map sortOrder){
        //ソート内容のチェック
        if(!sort.isEmpty() && sortOrder.containsKey(sort)){
            this.sort = sort;
        }else{
            this.sort = "-score";
        }
    }
    public String getSort(){
        return this.sort;
    }
    
    public void setCategory(String categoryID, Map categories){
        //カテゴリIDの内容をチェック
        if(categoryID.matches("[0-9]+") && categories.containsKey(categoryID)){
            this.categoryID = categoryID;
        } else {
            this.categoryID = "1";
        } 
    }
    public String getCategory(){
        return this.categoryID;
    }
    
    //テスト
    public LinkedHashMap<String, HashMap<String, Element>> returnElements() throws MalformedURLException, IOException, SAXException, Exception{
        
        LinkedHashMap<String, HashMap<String, Element>> abc = new LinkedHashMap<>();
        convertURL(this.query, this.sort, this.categoryID);
        
        System.out.println("テスト:"+this.url.toString());
        HttpURLConnection urlCon = (HttpURLConnection)this.url.openConnection();
        urlCon.setRequestMethod("GET");
        urlCon.setInstanceFollowRedirects(false);
        urlCon.connect();
        System.out.println("XMLドキュメントを取得しました");
        
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(urlCon.getInputStream());
            
            if(doc.hasChildNodes()){
                List<Element> Hits = new ArrayList<>();
                Hits = getElementsNamedHit(doc);
                
                for(Element el : Hits){
                    String index = el.getAttribute("index");
                    HashMap<String, Element> hitsChildren = new HashMap<>();
                    hitsChildren.put("Name", findChildByTag(el, "Name"));
                    
                    Element image = findChildByTag(el, "Image");
                    hitsChildren.put("Medium", findChildByTag(image, "Medium"));
                    
                    hitsChildren.put("Price",findChildByTag(el, "Price"));
                    hitsChildren.put("ProductID",findChildByTag(el, "ProductId"));
                    hitsChildren.put("Stock",findChildByTag(el, "Availability"));
                    
                    abc.put(index, hitsChildren);
                }
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ItemSearch.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            urlCon.disconnect();
            return abc;
        }
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
    
    private void convertURL(String query, String sort, String categoryID) throws MalformedURLException{
        String strURL = baseURL + "?appid=" + this.appID + "&query=" + query + "&category_id=" + categoryID + "&sort=" + sort;
        this.url = new URL(strURL);
        
    }
    
    private ArrayList<Element> getElementsNamedHit (Document doc) throws Exception{
        Element ResultSet = doc.getDocumentElement();
        Element Result = findChildByTag(ResultSet, "Result");
        ArrayList<Element> Hits = getElementsByTag(Result, "Hit");
        return Hits;
    }

    private static Element findChildByTag(Element el, String name) throws Exception{
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
    
    private static ArrayList<Element> getElementsByTag(Element el, String name) throws Exception{
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
