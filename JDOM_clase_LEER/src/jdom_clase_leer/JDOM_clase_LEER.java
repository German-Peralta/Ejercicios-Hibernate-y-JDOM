/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_clase_leer;

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
public class JDOM_clase_LEER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        SAXBuilder builder=new SAXBuilder();
        File xml= new File("concesionario_dom.xml");
        try {
            
            
        
            Document documento=(Document)builder.build(xml);
            
            Element raiz=documento.getRootElement();
             
             System.out.println(raiz.getName());
            
            Element coches=raiz.getChild("coches");
           
            List<Element> lista=coches.getChildren();
           
            for(int i=0;i<lista.size();i++){
                
                System.out.println("Matricula\tMarca\tPrecio");
                Element coche=lista.get(i);
                
                Element matricula=coche.getChild("matricula");
                Element marca=coche.getChild("marca");
                Element precio=coche.getChild("precio");
                System.out.println(matricula.getText()+"\t"+marca.getText()+"\t"+precio.getText());
                
                
                    
            }
            
            
            
            
            
            
            
        } catch (JDOMException ex) {
            Logger.getLogger(JDOM_clase_LEER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JDOM_clase_LEER.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
  
    
}}
