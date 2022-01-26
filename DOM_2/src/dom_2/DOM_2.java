
package dom_2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOM_2 {

    
    public static void main(String[] args) throws SAXException {
        try {
            // TODO code application logic here
            
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document documento=builder.parse(new File("concesionario.xml"));
            
            NodeList lista_coche=documento.getElementsByTagName("coche");
           
            for(int i=0;i<lista_coche.getLength();i++){
            
                Node coche=lista_coche.item(i);
                
                if(coche.getNodeType()==Node.ELEMENT_NODE){
                         
                
                System.out.println(coche.getNodeName());
                                     //elemento
                NodeList lista_hijos=coche.getChildNodes();
                
                 for(int j=0;j<lista_hijos.getLength();j++){
                 
                     Node hijo=lista_hijos.item(j);
                     
                     if(hijo.getNodeType()==Node.ELEMENT_NODE){
                         
                        Element elemento=(Element)hijo;
                        System.out.println("\t"+elemento.getNodeName());
                        System.out.println("\t\t"+elemento.getTextContent());
                     
                     }
                 }
                     
                 }
                
                
            }
            
            
            
            
            
            
            
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOM_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOM_2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
    }
    
}
