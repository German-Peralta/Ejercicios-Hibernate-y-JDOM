
package dom_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class DOM_3 {

    static int id=1;
    
    public static void Crear_etiqueta(Document documento,Element empleado,String nombre_caracteristica,String texto_caracteristica){
        
    Element caracteristica=documento.createElement(nombre_caracteristica);
    empleado.appendChild(caracteristica);
    Text texto=documento.createTextNode(texto_caracteristica);
    caracteristica.appendChild(texto);
    
    
    }
    
    public static void Crear_nuevo_empleado(Document documento, String apellido){
    
     BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
        
     Element empleado=documento.createElement("Empleado");
     documento.getDocumentElement().appendChild(empleado);
     
    try{
        
     
     Crear_etiqueta(documento,empleado,"Id",String.valueOf(id));   
     id++;   
     
     Crear_etiqueta(documento,empleado,"Apellido",apellido);
     
     System.out.println("Introduce el Departamento:");
     String departamento=entrada_teclado.readLine();
     Crear_etiqueta(documento,empleado,"Nombre",departamento);
     
     System.out.println("Introduce el Salario:");
     String salario=entrada_teclado.readLine();
     Crear_etiqueta(documento,empleado,"Nombre",salario);
     
     
     
     
     
    }   catch (IOException ex) {
            Logger.getLogger(DOM_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
  
       try { 
           
       DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
        
       DOMImplementation implementation=builder.getDOMImplementation();
       Document documento=implementation.createDocument(null,"Empleados",null);
       documento.setXmlVersion("1.0");
       
       //creamos empleado y sus etiquetas
       
       boolean continuar=true;
       
       BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
       
       try {
           
       do{
       
       System.out.println("Introduce los apellidos o ENTER para terminar");
       
       
  
       String comando = entrada_teclado.readLine();

       if(!comando.equals("")){
       
           Crear_nuevo_empleado(documento, comando);
           
       }else{ 
         System.out.println("Gracias por usar el programa");
         continuar=false;
       }
       
     
       }while(continuar);
       
       
        } catch (IOException ex) {
               Logger.getLogger(DOM_3.class.getName()).log(Level.SEVERE, null, ex);
           }
       
           Source source=new DOMSource(documento);
           Result result= new StreamResult(new File("empleados.xml"));
           Transformer transformer=TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           
           
       
        
            
      
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOM_3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DOM_3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DOM_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
