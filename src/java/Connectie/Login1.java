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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        //PreparedStatement pst = null;

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
            //Statement statement = con.createStatement();

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

            //ResultSet rs = statement.executeQuery("SELECT * FROM ding where een = 'Foppe'");
            //statement.executeUpdate("UPDATE ding SET een = 'Betrr' , twee = 'test' WHERE een = 'Beter'");
            /* ResultSet rs = statement.executeQuery("UPDATE ding SET een = Betrr , twee = test WHERE een = Beter");
            if(rs.next()){
            s = rs.getString("een");
            wacht = rs.getString("twee");
            }*/
            System.out.println(s);
            System.out.println(wacht);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = new Date();
            Time time = new Time(date.getTime());
            System.out.println(dateFormat.format(date));
            
            
            //System.out.println(date.setTime(time));
            

            //statement.executeUpdate("INSERT into ding values(" + vNaa + "," + vNaa + ")");
        } catch (SQLException e) {
            System.out.println("geen connectie: " + e);

        }

    }

}
