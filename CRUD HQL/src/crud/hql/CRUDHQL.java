
package crud.hql;

import Util.HibernateUtil;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author GERMAN
 */
public class CRUDHQL {

  static SessionFactory sesion_generador;
  static Session sesion;  
  
static public void Inserta_registro(){

    try{
    
    Transaction tx=sesion.beginTransaction();
    
    String hql="INSERT INTO Departamento (codDepartamento,nombreDepartamento) SELECT c.codigo,c.nombre FROM DepartamentoNueva c";
    
    Query query=sesion.createQuery(hql);
    
    int filas_cambiadas=query.executeUpdate();
    
    System.out.println("Filas insertadas con exito "+filas_cambiadas);
    
    tx.commit();

    }catch (ConstraintViolationException e){
    
          System.out.println("Filas ya insertadas");
    }

} 
static public void Consulta_empleado(){

    BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Indica el nombre del empleado que quieres consultar: ");
    String nombre_empleado = null;
      try {
          nombre_empleado = teclado.readLine();
      } catch (IOException ex) {
          Logger.getLogger(CRUDHQL.class.getName()).log(Level.SEVERE, null, ex);
      }

    
    String hql="SELECT e FROM Empleado e WHERE nombreEmpleado=:parametro";
   
    Query query=sesion.createQuery(hql);
    
    query.setParameter("parametro", nombre_empleado);
    
    Empleado empleado=(Empleado)query.uniqueResult();
    
    System.out.println(empleado.getCodEmpleado()+" - "+empleado.getNombreEmpleado()
            +" - "+empleado.getDepartamento().getNombreDepartamento()+" - "+empleado.getSalario());
    
   
} 
static public void Consulta_salario_max(){

    BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Indica el nombre del departamento que quieres consultar: ");
    String nombre_dep = null;
      try {
          nombre_dep = teclado.readLine();
      } catch (IOException ex) {
          Logger.getLogger(CRUDHQL.class.getName()).log(Level.SEVERE, null, ex);
      }

    
    String hql="SELECT s.nombreEmpleado FROM Empleado s WHERE salario=(SELECT MAX(e.salario) FROM Empleado e,Departamento d "
            + "WHERE e.departamento.codDepartamento=d.codDepartamento GROUP BY d.nombreDepartamento HAVING d.nombreDepartamento=:parametro)";
    
    Query query=sesion.createQuery(hql);
    
    query.setParameter("parametro", nombre_dep);
    
    String salario_max=String.valueOf(query.uniqueResult());
    
    System.out.println("Salario maximo de "+nombre_dep+" es "+salario_max);
    



} 
static public void Consulta_trabajadores_departamento(){

BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Indica el nombre del departamento que quieres consultar los trabajadores: ");
    String nombre_dep = null;
      try {
          nombre_dep = teclado.readLine();
      } catch (IOException ex) {
          Logger.getLogger(CRUDHQL.class.getName()).log(Level.SEVERE, null, ex);
      }

    
    String hql="SELECT e,d FROM Empleado e, Departamento d "
            + "WHERE (e.departamento.codDepartamento=d.codDepartamento) AND d.nombreDepartamento=:parametro";
    
    String hql2="SELECT e,d FROM Empleado e,Departamento d WHERE (e.departamento.codDepartamento=d.codDepartamento)"
            + "GROUP BY d.nombreDepartamento,e.codEmpleado,e.nombreEmpleado,e.salario HAVING d.nombreDepartamento=:parametro";
    
    Query query=sesion.createQuery(hql);
    
    query.setParameter("parametro", nombre_dep);
    
    List<Empleado> empleados=query.list();
    
    Iterator i=empleados.iterator();
    
    while(i.hasNext()){
        
          Object[] par=(Object[]) i.next();       
        
          Empleado e=(Empleado) par[0] ;
    
          System.out.println(e.getCodEmpleado()+" - "
                  +e.getNombreEmpleado()+" - "
                  +e.getDepartamento().getNombreDepartamento()+" - "
                  +e.getSalario());
    
    }
    
    
  
    



} 
static public void Actualiza_empleado(){} 
static public void Borra_empleado(){} 
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        sesion_generador=HibernateUtil.getSessionFactory();
        sesion=sesion_generador.openSession();
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        
        boolean continuar = true;
        do{
        
            try {
                System.out.println("1. Inserta los empleado de la tabla nueva");
                System.out.println("2. Consulta los datos de un empleado");
                System.out.println("3. consulta el salario maximo de los trabajadores de un departamento por su nombre");
                System.out.println("4. consulta los trabajadores de un departamento por su nombre");
                System.out.println("5. actualiza los datos de un empleado");
                System.out.println("6. borra un empleado");
                System.out.println("7. salir");
                
                int respuesta=Integer.parseInt(teclado.readLine());
                
                switch (respuesta){
                    
                    case 1:
                        Inserta_registro();
                        break;
                    case 2:
                        Consulta_empleado();
                        break;
                    case 3:
                        Consulta_salario_max();
                        break;
                    case 4:
                        Consulta_trabajadores_departamento();
                        break;
                    case 5:
                        Actualiza_empleado();
                        break;
                    case 6:
                        Borra_empleado();
                        break;
                        
                    case 7:
                        System.out.println("Gracias por usar el programa");
                        continuar=false;
                        break;
                    default:
                        System.out.println("Comando incorrecto");
                        break;
                        
                }
            } catch (IOException ex) {
                Logger.getLogger(CRUDHQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        
        }while(continuar);
        
        
        
        
        sesion.close();
        sesion_generador.close();
        
    }
    
}
