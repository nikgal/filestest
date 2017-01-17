package by.galov.filemanager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.galov.xml.SAXParser;

public class WeatherCommand extends Command{
    
    private String s;
    private Document doc;
    private String country = "Belarus";
    private String city = "Gomel";
    
    
    public WeatherCommand(Map<String, String> args) {
        
        super(args);
        // TODO Auto-generated constructor stub
        if(args.get("arg1")!=null&&args.get("arg2")!=null){
            this.city = args.get("arg2");
            this.country = args.get("arg2");
        }
        this.s =("http://api.wunderground.com/api/bae765e81dd7eef3/geolookup"
                + "/conditions/forecast/q/"+country+"/"+city+".xml");
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new URL(s).openStream());
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("error");
        }
    }

    @Override
    public void execute() {
       /*  console out 
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer xform;
        try {
            xform = factory.newTransformer();
            xform.transform(new DOMSource(this.doc), new StreamResult(System.out));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }*/
        
        
        
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getElementsByTagName("current_observation");
        NodeList days = root.getElementsByTagName("forecastday");
        for(int i = 0; i<nodes.getLength(); i++){
            Element el = (Element)nodes.item(i);
            String city = el.getElementsByTagName("city").item(0).getTextContent();
            String temp =  el.getElementsByTagName("temp_c").item(0).getTextContent();
            System.out.println(city);
            System.out.println("today: " + temp);
            for(int j = 0; j < days.getLength(); j++){
                Element el1 = (Element)days.item(j);
                if(el1.getElementsByTagName("title").item(0)!=null){
                    System.out.println(el1.getElementsByTagName("title")
                            .item(0).getTextContent()+": "+
                    el1.getElementsByTagName("fcttext_metric") 
                            .item(0).getTextContent());
                
                }
            }
        }
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer();
       
        DOMSource source = new DOMSource(doc);
        StreamResult streamResult =  new StreamResult(new File("out.xml"));
        transformer.transform(source, streamResult);
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        SAXParser parser = new SAXParser("city");
        try {
            parser.parser.parse(new File("out.xml"), parser);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        parser.displayRes();
        

    }

    @Override
    public void help() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCorrect() {
        // TODO Auto-generated method stub
        return true;
    }

}
