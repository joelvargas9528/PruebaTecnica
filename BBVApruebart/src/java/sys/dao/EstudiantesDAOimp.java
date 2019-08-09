/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Estudiantes;
import sys.util.HibernateUtil;

/**
 *
 * @author santi
 */
public class EstudiantesDAOimp implements EstudiantesDAO{

    @Override
    public List<Estudiantes> mostrar() {
        List<Estudiantes> listar = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Estudiantes";
        
        try{
            listar  = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listar;
    }

    @Override
    public void nuevoestudiante(Estudiantes estudiante) {
        Session session  = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(estudiante);
            session.getTransaction().commit();    
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
}
