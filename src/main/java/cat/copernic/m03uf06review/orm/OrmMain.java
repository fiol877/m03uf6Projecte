package cat.copernic.m03uf06review.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    public static void main(String[] args) {
        String MySQLURL = "jdbc:mysql://localhost/m03uf6Projecte";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        
        List<Registre> llistaRegistres = new ArrayList();
        
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM `jocs`";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    llistaRegistres.add(new Registre(rs.getInt("id_joc"), rs.getString("nom_joc"), rs.getString("recomenat").charAt(0), rs.getDouble("nota_joc"), rs.getBoolean("a_la_venta"), rs.getDate("fecha_lanzamiento")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(Registre registre : llistaRegistres){
            System.out.printf("%s   %s   %s   %s   %tD   %s%n", registre.id, registre.nom, registre.nota, registre.recomenat, registre.releaseDate, registre.venta);
        }
        
    }
}
