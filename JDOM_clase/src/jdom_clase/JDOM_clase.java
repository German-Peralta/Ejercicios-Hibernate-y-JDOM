/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_clase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author GERMAN
 */

public class JDOM_clase {
    
    public static void crea_coche( Document documento,Element coches,String atributo_id, String texto_matricula,
        String texto_marca, String texto_precio, String atributo_marca,String atributo_precio){
    
        
        Element coche= new Element("coche");
        coche.setAttribute("id",atributo_id);
        coches.addContent(coche);
        
        Element matricula= new Element("matricula");
        matricula.setText(texto_matricula);
        coche.addContent(matricula);
        
        Element marca= new Element("marca");
        marca.setText(texto_marca);
        marca.setAttribute("at_1", atributo_marca);
        coche.addContent(marca);
        
        Element precio= new Element("precio");
        precio.setText(texto_precio);
        precio.setAttribute("at_2", atributo_precio);
        coche.addContent(precio);
    
    
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        String atributo_id=null;
        
        String texto_matricula=null;
        String texto_marca=null;
        String texto_precio=null;
        
        String atributo_marca=null;
        String atributo_precio=null;
        
        Scanner teclado= new Scanner(System.in);
        
        Element concesionario= new Element("concesionario");
        Document documento=new Document(concesionario);
        
        Element coches= new Element("coches");
        concesionario.addContent(coches);
        
        //ESCRIBIR XML
   
        boolean continuar=true;
        do{
            System.out.println("Introduce el atributo Id de un nuevo coche(ENTER para acabar):");
            
            atributo_id=teclado.nextLine();
            
            if(atributo_id.equals("")){
                
                continuar=false;
                
            }else{
           
                System.out.println("Introduce la matricula:");
                texto_matricula=teclado.nextLine();
                System.out.println("Introduce la marca:");
                texto_marca=teclado.nextLine();
                System.out.println("Introduce el atributo de la marca:");
                atributo_marca=teclado.nextLine();
                System.out.println("Introduce la precio:");
                texto_precio=teclado.nextLine();
                System.out.println("Introduce el atributo del precio:");
                atributo_precio=teclado.nextLine();
            
            crea_coche( documento, coches, atributo_id,  texto_matricula,
             texto_marca,  texto_precio,  atributo_marca, atributo_precio);
            }
            
            
            
         
            
        }while(continuar);
        
        XMLOutputter xml=new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        try {
            xml.output(documento, new FileWriter("concesionario_dom.xml"));
            xml.output(documento, new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\JDOM_clase_LEER\\concesionario_dom.xml"));
        } catch (IOException ex) {
            Logger.getLogger(JDOM_clase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
