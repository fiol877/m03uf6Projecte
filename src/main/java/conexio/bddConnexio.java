package conexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bddConnexio {

    public Connection connexio() {
        String MySQLURL = "jdbc:mysql://localhost/m03uf6Projecte";
        String databseUserName = "root";
        String databasePassword = "";

        Connection con = null;

        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

//    public void queryJDBC() {
//        Connection con = connexio();
//
//        try {
//            if (con != null) {
//                Statement stmt = con.createStatement();
//                String query = "SELECT * FROM `jocs`";
//                ResultSet rs = stmt.executeQuery(query);
//
//                while (rs.next()) {
//                    System.out.println(rs.getString("nom_joc") + "     " + rs.getInt("id_joc") + "     " + rs.getString("recomenat") + "     " + rs.getDouble("nota_joc")
//                            + "     " + rs.getBoolean("a_la_venta") + "     " + rs.getDate("fecha_lanzamiento"));
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
