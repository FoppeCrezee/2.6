/*
 * Maakt een connectie met de database
 */
package Connectie;

import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author foppe
 */
public class Connectie {

    private String vNaam;
    private String ww;
    private java.sql.Connection con = null;
    private final String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";

    
    /**
     * Maakt de connectie met de database
     */
    public java.sql.Connection connectie() {
        try {
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
        } catch (Exception ex) {
            System.out.println("geen connectie: " + ex);
        }
        return con;
    }

}
