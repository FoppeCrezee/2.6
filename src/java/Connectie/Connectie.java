/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";

    protected java.sql.Connection connectie() {
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
