/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author foppe
 */
public class Insert {
    
    private String vNaam;
    private String ww;
    
    public Insert(String vNaam, String ww){
        this.vNaam = vNaam;
        this.ww = ww;
    }
    
    public void add(){
    
        String vNaa = "TEstje";
        Connection con = null;
        PreparedStatement pst = null;
        String query = "INSERT into ding (een, twee)" + " values (?,?)";

        try {
            String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
            
            
            System.out.println("gelukt");
            
            //PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, vNaam);
            pst.setString(2, ww);
            pst.execute();
            
            Statement statement = con.createStatement();
            //System.out.println(statement.executeQuery("SELECT * FROM ding"));
            
            
            //statement.executeUpdate("INSERT into ding(een, twee) values('hopelijk', 'odet')");
        } catch (SQLException e) {
            System.out.println("geen connectie: " + e);

        }
        
        
    }
    
    
}
