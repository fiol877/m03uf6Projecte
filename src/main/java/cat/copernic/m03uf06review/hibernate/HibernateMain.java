package cat.copernic.m03uf06review.hibernate;

import cat.copernic.m03uf06review.hibernate.Registre;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 * Cal usar la llibreria Hibernate.
 *
 *
 * @author pep
 */
public class HibernateMain {

    private static SessionFactory factory;

    public static void main(String[] args) {
        iniciarSessio();
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
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Registre> jocs = session.createQuery("FROM Registre").list();
            System.out.println("-----------------------------------------------------------------");
            for (Iterator iterator = jocs.iterator(); iterator.hasNext();) {
                Registre registre = (Registre) iterator.next();
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
