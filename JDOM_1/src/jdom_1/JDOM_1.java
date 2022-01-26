/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom_1;

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

public class JDOM_1 {

    static int numero_id=1;
    
    public static void Introduce_caracteristicas(Element coche,String nombre_etiqueta,String texto_etiqueta){
    
         Element elemento=new Element(nombre_etiqueta);
         coche.addContent(elemento);
         elemento.setText(texto_etiqueta);
    
    
    }
    public static void crea_nuevo_coche(Element coches,String texto_matricula){
    
        try {
            BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
            
            Element coche=new Element("coche");
            coches.addContent(coche);
            coche.setAttribute("id", String.valueOf(numero_id));
            numero_id++;
            
            
            Introduce_caracteristicas( coche,"Matricula", texto_matricula);
            
            System.out.println("Introduce la marca del coche:");
            String marca=entrada_teclado.readLine();
            Introduce_caracteristicas( coche,"Marca", marca);
            
            System.out.println("Introduce el precio del coche:");
            String precio=entrada_teclado.readLine();
            Introduce_caracteristicas( coche,"Precio", precio);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JDOM_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
        
        Element concesionario=new Element("concesionario");
        Document documento=new Document(concesionario);
        
        Element coches=new Element("coches");
        concesionario.addContent(coches);
        
        boolean continuar=true;
        
        do{
        
            System.out.println("Introduce la matricula de un nuevo coche o pulsa \"INTRO\" para acabar:");
            
            String respuesta;
            try {
                respuesta = entrada_teclado.readLine();
           
            
            if(!respuesta.equals("")){
            
            //hacemos
            
            crea_nuevo_coche(coches,respuesta);
            
            
            }else{
            
              System.out.println("Creamos el fichero XML con los datos introducidos");
              continuar=false;
            }
        
             } catch (IOException ex) {
                Logger.getLogger(JDOM_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }while(continuar);
        
        XMLOutputter xml=new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat());
        try {
            xml.output(documento, new FileWriter("conce.xml"));
        } catch (IOException ex) {
            Logger.getLogger(JDOM_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println("Fin programa");
        
        
        
    }
    
}
