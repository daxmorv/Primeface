/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import conexion.NewHibernateUtil;
import dao.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class PersonaDAOImpl implements PersonaDAO{

     
    
    @Override
    public List<Persona> buscarTodos() {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Persona> personas = new ArrayList<Persona>();
        try{
            
            //session.beginTransaction();         
            Query q=session.createQuery("from Persona d order by d.nombre");
            personas=q.list();            
            //session.beginTransaction().commit();            
            
        }catch(Exception e){
            System.out.println("Error en actualizar "+e.getMessage());
            session.beginTransaction().rollback();
            personas=null;
        }
        finally{
            System.out.println("cerrando la sesion");
            session.close();
        }
        return personas;
 
    }

     @Override
       public void guardar(Persona p) {
       Session session = NewHibernateUtil.getSessionFactory().openSession(); 
       session.beginTransaction();         
       session.persist(p);
       session.beginTransaction().commit();   
       session.close();
    }

    @Override
    public void editar(Persona p) {
       System.out.println("Entro a Editar DAO IMPL");
       System.out.println("NOmbre:"+p.getNombre()+"Apellido:"+p.getApellido()+"Edad:"+p.getEdad()+"Telefono"+p.getTelefono()+"Fecha"+p.getFechaNacimiento());
       Session session = NewHibernateUtil.getSessionFactory().openSession(); 
       session.beginTransaction();         
       session.update(p);
       session.beginTransaction().commit();   
       session.close();
       System.out.println("TERMINO DE  Editar DAO IMPL");
    }

  
    
    
    
}
