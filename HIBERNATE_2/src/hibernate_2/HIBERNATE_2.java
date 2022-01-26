/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_2;

import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author GERMAN
 */
public class HIBERNATE_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        SessionFactory generador_sesiones=HibernateUtil.getSessionFactory();
        Session sesion=generador_sesiones.openSession();
        
        Transaction tx=sesion.beginTransaction();
        
        //String hql="INSERT INTO Departamento (codDepartamento,nombreDepartamento,localidad)SELECT "
                //+ "n.codDepartamentoN,  n.nombreDepartamentoN, n.localidadN FROM Nueva n";
        
        //Query insercion=sesion.createQuery(hql);
        
        String hql="DELETE FROM Departamento e WHERE e.codDepartamento='81'";
                
        Query borrado=sesion.createQuery(hql);
        
        //borrado.executeUpdate();
        
        String hql_2="UPDATE Departamento SET nombreDepartamento='PSG' WHERE codDepartamento='01'";
                
        Query actualiza_nombre=sesion.createQuery(hql_2);
        
        actualiza_nombre.executeUpdate();
        
        
        
     
        
       
        
        
        
        
        
        tx.commit();
        
        
        
    }
    
}
