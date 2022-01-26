/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author GERMAN
 */
public class JDOM_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        SAXBuilder builder=new SAXBuilder();
        File xml=new File("conce.xml");
        Document documento=(Document) builder.build(xml);
        
        Element raiz=documento.getRootElement();
        
        Element coches=raiz.getChild("coches");
        
        List<Element> lista= coches.getChildren("coche");
        
        System.out.println("Matricula\tMarca\tPrecio");
        for(Element e:lista){
            
            String matricula=e.getChildText("Matricula");
            String marca=e.getChildText("Marca");
            String precio=e.getChildText("Precio");
        
        
            System.out.println(matricula+"\t"+marca+"\t"+precio);
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        } catch (JDOMException ex) {
            Logger.getLogger(JDOM_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JDOM_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
