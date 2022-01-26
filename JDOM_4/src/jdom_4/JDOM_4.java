/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_4;

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
public class JDOM_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
        SAXBuilder builder=new SAXBuilder();
        File xml=new File("concesi.xml");
        Document documento=builder.build(xml);
        
        Element coches=documento.getRootElement().getChild("coches");
        
        System.out.println("id\tMatricula\tMarca\tpais\tprecio\tmoneda");
        
        List<Element> lista_coches=coches.getChildren();
        
        for(int i=0;i<lista_coches.size();i++){
        
        Element coche=lista_coches.get(i);
        
        String id=coche.getAttributeValue("id");
        
        String Matricula=coche.getChildText("Matricula");
        String Marca=coche.getChildText("Marca");
        String precio=coche.getChildText("Precio");
        
        Element marca=coche.getChild("Marca");
        String pais=marca.getAttributeValue("Precio");
        
        Element Precio=coche.getChild("Precio");
        String moneda=Precio.getAttributeValue("Moneda");
        
        
        System.out.println(id+"\t"+Matricula+"\t"+Marca+"\t"+pais+"\t"+precio+"\t"+moneda);
        
        
        }
        
        
        
        
        
        
        
        
        } catch (JDOMException ex) {
            Logger.getLogger(JDOM_4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JDOM_4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
