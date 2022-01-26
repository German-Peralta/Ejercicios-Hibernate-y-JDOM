/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author GERMAN
 */
public class DOM_1 {

 
    public static void añade_coche(Document documento,String nombre_elemento,String texto_elemento,Element padre){
    
        Element elemento=documento.createElement(nombre_elemento);
        padre.appendChild(elemento);
        Text texto=documento.createTextNode(texto_elemento);
        elemento.appendChild(texto);
    
    }
    
    public static void Registra_coche(Document documento,Element coches,String s_matricula,String s_marca,String s_precio){
    
        Element coche=documento.createElement("coche");
        coches.appendChild(coche);
        
        añade_coche(documento,"matricula",s_matricula,coche);
        añade_coche(documento,"marca",s_marca,coche);
        añade_coche(documento,"precio",s_precio,coche);
        
        
    
    
    
    }
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
      
        try {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation=builder.getDOMImplementation();
        Document documento=implementation.createDocument(null, "concesionario", null);
        documento.setXmlVersion("1.0");
        
        Scanner teclado=new Scanner(System.in);
        Element coches=documento.createElement("coches");
        documento.getDocumentElement().appendChild(coches);
        
        boolean continuar=true;
        do{
        
            System.out.println("Introduce la matricula de un nuevo coche (ENTER para terminar): ");
            String matricula=teclado.nextLine();
            if(!matricula.equals("")){
        
            System.out.println("Introduce el marca: ");
            String marca=teclado.nextLine();
            System.out.println("Introduce precio: ");
            String precio=teclado.nextLine();
            
            Registra_coche(documento,coches,matricula,marca,precio);
            
           }else{
            
            continuar=false;
            }
            
           
            
        }while(continuar);
        
       System.out.println("FIN PROGRAMA");
        
      
      
        
        
       
        
        Source source= new DOMSource(documento);
        File fichero=new File("concesionario.xml");
        if(!fichero.exists()) fichero.createNewFile();
        Result result=new StreamResult(fichero);
        Transformer transformer=TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
        
        
        } catch (ParserConfigurationException ex) {
         
        } catch (TransformerException ex) {
            
        }
        
        
        
    }
    
}
