package cat.copernic.m03uf06review.hibernate_relational;

import cat.copernic.m03uf06review.hibernate_relational.Registre2;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        HashSet set1 = new HashSet();
        set1.add(new Categoria("Minecraft"));
        set1.add(new Categoria("Rol"));

        HashSet set2 = new HashSet();
        set2.add(new Categoria("Aventura"));
        set2.add(new Categoria("Rol"));

        //crearJoc("Pog", "s", 7.7, true, null, set2);
        //crearJoc(new Registre2("SkyrimASDF", "s", 9.9, true, null), set2);
        //updateJoc(new Registre2(25, "Skyrim", "s", 5.0, true, java.sql.Date.valueOf("2011-11-11")), set2);
        eliminarJoc(25);

        //mostrarJocs();
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
                Set categorias = registre.getCategoria();
                for (Iterator iterator2 = categorias.iterator(); iterator2.hasNext();) {
                    Categoria categoriaNom = (Categoria) iterator2.next();
                    System.out.println("Certificate: " + categoriaNom.getNom());
                }
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

    public static Integer crearJoc(Registre2 joc, Set categorias) {
        iniciarSessio();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer idJoc = null;

        try {
            tx = session.beginTransaction();
            joc.setCategoria(categorias);
            idJoc = (Integer) session.save(joc);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
        return idJoc;
    }

    public static void updateJoc(Registre2 joc, Set categorias) {
        iniciarSessio();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            joc.setCategoria(categorias);
            session.update(joc);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }

        eliminarCategoriasNull();
    }

    public static void eliminarJoc(Integer id) {
        iniciarSessio();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Registre2 joc = (Registre2) session.get(Registre2.class, id);
            session.delete(joc);
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

    public static void eliminarCategoriasNull() {
        iniciarSessio();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            String hql = "FROM Categoria c WHERE c.idJoc = null";
            Query query = session.createQuery(hql);
            List<Categoria> results = query.list();
            for (Categoria c : results) {
                Categoria categoria = (Categoria) session.get(Categoria.class, c.getId());
                session.delete(categoria);
            }
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
