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
}
