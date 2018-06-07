/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author foppe
 */
public class Login1 {

    public static void main(String[] args) {

        String vNaa = "TEstje";
        Connection con = null;
        PreparedStatement pst = null;
        
        String s = "Niet Foppe";
        String wacht = "Niet Test";
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
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM ding where een = 'Foppe'");
            if(rs.next()){
            s = rs.getString("een");
            wacht = rs.getString("twee");
            }
            
            
            System.out.println(s);
            System.out.println(wacht);
            
            
            //statement.executeUpdate("INSERT into ding values(" + vNaa + "," + vNaa + ")");
        } catch (SQLException e) {
            System.out.println("geen connectie: " + e);

        }

    }

}
