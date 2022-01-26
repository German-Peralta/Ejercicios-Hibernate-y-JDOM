
package hibernate_4;

import Util.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;


public class HIBERNATE_4 {

    static SessionFactory sesion_generador;
    static Session sesion;
    public static void actualiza_departamento(){
     
     BufferedReader entrada_teclado= new BufferedReader(new InputStreamReader(System.in));
     
     try{
         
     Transaction tx=sesion.beginTransaction();
         
     System.out.println("Introduce el codigo de deparmento a actualizar"); 
     String codigo_departamento=entrada_teclado.readLine();
     
     System.out.println("Introduce el nuevo nombre del departamento"); 
     String nombre_departamento=entrada_teclado.readLine();
     
     System.out.println("Introduce la nueva localidad del departamento"); 
     String localidad=entrada_teclado.readLine();
     
     Departamento departamento=(Departamento)sesion.load(Departamento.class, codigo_departamento);
     
     departamento.setNombreDepartamento(nombre_departamento);
     departamento.setLocalidad(localidad);
     
     sesion.update(departamento);
       
     tx.commit();
     
   
     
     } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_4.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ObjectNotFoundException ex) {
            System.out.println("No existe tal departamento"); 
     }
     }
    public static void borra_departamento(){
     
     BufferedReader entrada_teclado= new BufferedReader(new InputStreamReader(System.in));
     
     try{
         
     Transaction tx=sesion.beginTransaction();
         
     System.out.println("Introduce el codigo de deparmento"); 
     String codigo_departamento=entrada_teclado.readLine();
     
     Departamento departamento=(Departamento)sesion.load(Departamento.class, codigo_departamento);
     
     sesion.delete(departamento);
       
     tx.commit();
     
     
     
     } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_4.class.getName()).log(Level.SEVERE, null, ex);
       }catch (ConstraintViolationException ex) {
            System.out.println("no se puede borrar el departamento ya que esta relacionado con otra tabla"); 
        }
     }
    public static void Intrdoduce_departamento(){
    
     BufferedReader entrada_teclado= new BufferedReader(new InputStreamReader(System.in));
     
     Transaction tx=sesion.beginTransaction();
     
     try{
        
     System.out.println("Introduce el codigo de deparmento"); 
     String codigo_departamento=entrada_teclado.readLine();
       
     System.out.println("Introduce el nombre del deparmento"); 
     String nombre_departamento=entrada_teclado.readLine();
     
     System.out.println("Introduce la localidad del deparmento"); 
     String localidad=entrada_teclado.readLine();
     
     Departamento departamento=new Departamento();
     
     departamento.setCodDepartamento(codigo_departamento);
     departamento.setNombreDepartamento(nombre_departamento);
     departamento.setLocalidad(localidad);
             
     sesion.save(departamento);     
     
     tx.commit();
  
       
     } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_4.class.getName()).log(Level.SEVERE, null, ex);
     }catch (ConstraintViolationException ex) {
            System.out.println("El departamento ya existe");
            
            
     }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        sesion_generador=HibernateUtil.getSessionFactory();
        sesion=sesion_generador.openSession();
        
        
        BufferedReader entrada_teclado= new BufferedReader(new InputStreamReader(System.in));
        try {
        boolean continuar=true;
        
        do{
            System.out.println("1. Introduce nuevo departamento");
            System.out.println("2. Borra un departamento");
            System.out.println("3. cambia la localidad de un departamento");
            System.out.println("4. Finaliza el programa");
            
            
            String respuesta = entrada_teclado.readLine();
            
            
            switch(respuesta){
                
                case "1":
                    Intrdoduce_departamento();
                    break;
                case "2":
                    borra_departamento();
                    break;
                case "3":
                    actualiza_departamento();
                    break;
                case "4":
                    System.out.println("Gracias por utilizar el programa");
                    continuar=false;
                    break;
                default:
                    System.out.println("Entrada invalida");
                    break;
            }
 
        }while(continuar);
        
        sesion.close();
        sesion_generador.close();
        
        
        } catch (IOException ex) {
                Logger.getLogger(HIBERNATE_4.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
