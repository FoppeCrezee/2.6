/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author foppe
 */
public class AccountLoginTest {

    public AccountLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        String vNaa = "TEstje";
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
            System.out.println("gelukt");

            String Naam = "Beter";
            String ww = "Test";
            String naamm = "Betrr";
            String query = "UPDATE ding SET een = ? , twee = ? WHERE een = ?";
            PreparedStatement pst = null;
            try {
                pst = con.prepareStatement(query);
                pst.setString(1, Naam);
                pst.setString(2, ww);
                pst.setString(3, naamm);
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = new Date();
            Time time = new Time(date.getTime());
            System.out.println(dateFormat.format(date));

        } catch (SQLException e) {
            System.out.println("geen connectie: " + e);

        }
    }
}
