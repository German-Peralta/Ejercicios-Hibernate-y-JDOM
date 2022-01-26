/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class JDOM_3 {

    static int id=1;
    public static void Introduce_coche(Element coches,String respuesta){
    
        BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
            
        ///añadimos coches
        
        Element coche=new Element("coche");
        coches.addContent(coche);
        coche.setAttribute("id", String.valueOf(id));
        id++;
        
        //elementos del coche
        try{
            
     
 
        Element matricula=new Element("Matricula");
        coche.addContent(matricula);
        matricula.setText(respuesta);
        
        System.out.println("Itroduce el texto de la marca");
        String texto_marca=entrada_teclado.readLine();
        System.out.println("Itroduce el texto de la atributo Precio");
        String texto_atributo_marca=entrada_teclado.readLine();
        
        Element marca=new Element("Marca");
        coche.addContent(marca);
        marca.setText(texto_marca);
        marca.setAttribute("Precio",texto_atributo_marca);
        
        System.out.println("Itroduce el texto del Precio");
        String texto_precio=entrada_teclado.readLine();
        System.out.println("Itroduce el texto de la atributo moneda");
        String texto_atributo_precio=entrada_teclado.readLine();
        
        Element precio=new Element("Precio");
        coche.addContent(precio);
        precio.setText(texto_precio);
        precio.setAttribute("Moneda",texto_atributo_precio);
        
        
         } catch (IOException ex) {
            Logger.getLogger(JDOM_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
        
        Element concesionario=new Element("concesionario");
        
        Document documento= new Document(concesionario);
        
        Element coches=new Element("coches");
        
        concesionario.addContent(coches);

        boolean continuar=true;
        
        do{
            
            
            try {
                System.out.println("Introduce matricula o ENTER para terminar");
                String respuesta=entrada_teclado.readLine();
                
                if(!respuesta.equals("")){
                    
                    Introduce_coche(coches,respuesta);
                    
                    
                }else{
                    System.out.println("FIN programa");
                    continuar=false;
                }
            } catch (IOException ex) {
                Logger.getLogger(JDOM_3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
        }while(continuar);
        
        XMLOutputter xml=new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        try {
            xml.output(documento, new FileWriter("concesi.xml"));
        } catch (IOException ex) {
            Logger.getLogger(JDOM_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
