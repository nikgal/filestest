package by.galov.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {
    private String thisElement="";
    private String element;
    private File file;
    private ArrayList<String> result = new ArrayList<>();
    public javax.xml.parsers.SAXParser parser;
    public SAXParser(String element){
        this.element = element;
        
        SAXParserFactory factory = SAXParserFactory.newInstance(); 
        try {
            this.parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
    }
    @Override 
    public void startDocument() throws SAXException { 
      System.out.println("Start parse XML..."); 
    } 
    
    @Override 
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException { 
      thisElement = qName;  
    } 
    
    @Override 
    public void characters(char[] ch, int start, int length) throws SAXException { 
      if (thisElement.equals(element)) { 
         result.add(new String(ch, start, length)); 
      } 
     
    } 
    
    @Override 
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException { 
      thisElement = ""; 
    } 
    
    @Override 
    public void endDocument() { 
      System.out.println("Stop parse XML..."); 
    } 
    
    public void displayRes(){
        for(String res:result){
            System.out.println(res);
        }
    }
}
