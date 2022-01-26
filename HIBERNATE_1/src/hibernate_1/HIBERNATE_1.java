/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_1;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author GERMAN
 */
public class HIBERNATE_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SessionFactory sesion=HibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        
        Transaction tx=session.beginTransaction();
        
        Empleado empleado= (Empleado)session.load(Empleado.class, "07");
        
        empleado.setNombreEmpleado("Recaredo edo edo");
        
        session.update(empleado);
        
        
        //session.save(empleado);
        
         
        
        
        tx.commit();
        
        session.close();
        sesion.close();
        
    }
    
}
