/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_3;

import Util.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;

/**
 *
 * @author GERMAN
 */
public class HIBERNATE_3 {

    static Session sesion;
    public static void Actualiza_departamento(){
    BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
    
   
    
    try {
    
        
    Transaction tx=sesion.beginTransaction();
    
    String hql="UPDATE Departamento d SET "
            + "d.codDepartamento=:dep,d.nombreDepartamento=:ndp,d.localidad=:loc    "
            + "WHERE d.codDepartamento=:parametro";
    
    Query query=sesion.createQuery(hql);
    
    System.out.println("Introduce el codigo del departamento a actualizar");
    String criterio=entrada_teclado.readLine();
    System.out.println("Introduce el nuevo codigo del departamento");
    String departamento=entrada_teclado.readLine();
    System.out.println("Introduce el nuevo nombre del departamento");
    String nombre_departento=entrada_teclado.readLine();
    System.out.println("Introduce el nuevo localidad del departamento");
    String localidad=entrada_teclado.readLine();
    
    query.setParameter("parametro", criterio);
    query.setParameter("dep", departamento);
    query.setParameter("ndp", nombre_departento);
    query.setParameter("loc", localidad);
    
 
 
    System.out.println("Se han actualizado: "+query.executeUpdate());
    
    tx.commit();
  
    
    } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ConstraintViolationException ex) {
            System.out.println("No se puede borrar el departamento puesto que es FK en la tabla empleados");
    } 
    
    
    
    }
    public static void borra_departamento(){
        
    BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Introduce el codigo del departamento a borrar");
    
    try {
    String criterio=entrada_teclado.readLine();
        
    Transaction tx=sesion.beginTransaction();
    
    String hql="DELETE FROM Departamento d WHERE d.codDepartamento=:parametro";
    
    Query query=sesion.createQuery(hql);
    
    query.setParameter("parametro", criterio);
    
    System.out.println("Se han eliminado: "+query.executeUpdate());
    
    tx.commit();
  
    
    } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ConstraintViolationException ex) {
            System.out.println("No se puede borrar el departamento puesto que es FK en la tabla empleados");
    } 
    
    
    
     }
    public static void Muestra_tabla_ordenada(){
    
      BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Introduce el criterio para ordenar");
    
    try {
    String criterio=entrada_teclado.readLine();
        
    String hql="SELECT d FROM Departamento d ORDER BY " +criterio;
    
    Query query=sesion.createQuery(hql);
   
    
    Iterator iterador=query.iterate();
    
    while(iterador.hasNext()){
    
     Departamento departamento=(Departamento)iterador.next();
        
     System.out.println(departamento.getCodDepartamento()+" - "+departamento.getNombreDepartamento()+" - "+ departamento.getLocalidad());
    
    }
    
    
    } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLGrammarException ex) {
            System.out.println("No existe tal criterio");
    } 
    
    
    
    
    }
    public static void Muestra_departamento(){
    
    BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Introduce el codigo de departamento");
    
    try {
    String codigo_departamento=entrada_teclado.readLine();
        
    String hql="SELECT d FROM Departamento d WHERE d.codDepartamento=:cod";
    
    Query query=sesion.createQuery(hql);
    
    query.setParameter("cod", codigo_departamento);
    
    Departamento departamento=(Departamento)query.uniqueResult();
    

    
    System.out.println(departamento.getCodDepartamento()+" - "+departamento.getNombreDepartamento()+" - "+ departamento.getLocalidad());
    
    
    
    } catch (IOException ex) {
            Logger.getLogger(HIBERNATE_3.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NullPointerException ex) {
            System.out.println("No existe tal departamento");
    } 
    
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        
       SessionFactory sesion_generador=HibernateUtil.getSessionFactory();
        
       sesion=sesion_generador.openSession();
       
       //Transaction tx=sesion.beginTransaction();
       
       boolean continuar=true;
       
       do{
           
           try {
               
               BufferedReader entrada_teclado=new BufferedReader(new InputStreamReader(System.in));
               
               System.out.println("1. Muestra departamento por codigo");
               System.out.println("2. Muestra los departamentos ordenados");
               System.out.println("3. Borra departamento por codigo");
               System.out.println("4. Actualiza departamento por codigo");
               System.out.println("5. Finalizar programa");
               
               String respuesta=entrada_teclado.readLine();
               
               switch (respuesta){
               
                   case "1":
                       Muestra_departamento();
                       break;
                   case "2":
                       Muestra_tabla_ordenada();
                       break;
                   case "3":
                       borra_departamento();
                       break;
                   case "4":
                       Actualiza_departamento();
                       break;
                   case "5":
                       System.out.println("Gracias por utilizar el programa");
                       continuar=false;
                       break;
                   default:
                       System.out.println("Entrada Invalida");
                       break;
                       
                       
               
               
               
               }
               
               
               
               
               
           } catch (IOException ex) {
               Logger.getLogger(HIBERNATE_3.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
           
           
           
           
           
           
       }while(continuar);
   
       sesion.close();
       sesion_generador.close();
       
       
     
       //tx.commit();
       
        
        
        
        
    }
    
}
