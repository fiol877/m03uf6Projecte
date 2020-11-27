package cat.copernic.m03uf06review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola.
 *
 *
 * @author pep
 */
public class JdbcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String MySQLURL = "jdbc:mysql://localhost/m03uf6Projecte";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM `jocs`";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println(rs.getString("nom_joc") +"     "+ rs.getInt("id_joc")+"     "+ rs.getString("recomenat")+"     "+ rs.getDouble("nota_joc")
                    +"     "+ rs.getBoolean("a_la_venta")+"     "+ rs.getDate("fecha_lanzamiento"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
