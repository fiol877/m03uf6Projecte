package cat.copernic.m03uf06review.hibernate_relational;

import cat.copernic.m03uf06review.hibernate_relational.Registre2;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * En aquesta secció cal accedir a dues taules de MySQL que formin una relació
 * 
 * One to Many, com per exemple: Departament -> Empleat
 * 
 * Cada departament té molts empleats, i un empleat només treballa en un
 * departament.
 * 
 * Recòrrer la relaciçó i mostrar-la per la consola 
 * 
 * Cal usar la llibreria Hibernate.
 * 
 * @author pep
 */
public class HibernateRelationalMain {
    
    private static SessionFactory factory;

    public static void main(String[] args) {
        mostrarJocs();
    }
    
    public static void iniciarSessio() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    
    public static void mostrarJocs() {
        iniciarSessio();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Registre2> jocs = session.createQuery("FROM Registre2").list();
            System.out.println("-----------------------------------------------------------------");
            for (Iterator iterator = jocs.iterator(); iterator.hasNext();) {
                Registre2 registre = (Registre2) iterator.next();
                System.out.printf("%s   %s   %s   %s   %tD   %s%n", registre.getId(), registre.getNom(), registre.getNota(), registre.getRecomenat(), registre.getReleaseDate(), registre.isVenta());
            }
            System.out.println("-----------------------------------------------------------------");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
}
