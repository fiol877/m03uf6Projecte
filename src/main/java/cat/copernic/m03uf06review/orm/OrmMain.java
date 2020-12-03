package cat.copernic.m03uf06review.orm;

import conexio.bddConnexio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 *
 * @author pep
 */
public class OrmMain {

    static List<Registre> llistaRegistres = new ArrayList();

    public static void main(String[] args) {
        queryORM();
        imprimirLlista(llistaRegistres);

    }

    public static void queryORM() {
        bddConnexio bddConnexio = new bddConnexio();
        Connection con = bddConnexio.connexio();

        try {
            if (con != null) {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM `jocs`";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    omplirLlista(new Registre(rs.getInt("id_joc"), rs.getString("nom_joc"), rs.getString("recomenat"), rs.getDouble("nota_joc"), rs.getBoolean("a_la_venta"), rs.getDate("fecha_lanzamiento")));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Registre> omplirLlista(Registre joc) throws SQLException {
        llistaRegistres.add(joc);
        return llistaRegistres;
    }

    public static void imprimirLlista(List<Registre> llistaRegistres) {
        for (Registre registre : llistaRegistres) {
            System.out.printf("%s   %s   %s   %s   %tD   %s%n", registre.getId(), registre.getNom(), registre.getNota(), registre.getRecomenat(), registre.getReleaseDate(), registre.isVenta());
        }
    }
}
