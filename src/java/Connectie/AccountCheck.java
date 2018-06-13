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
import java.util.Properties;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
public class AccountCheck {

    private String vNaam;
    private String ww;
    private Connection con = null;

    public AccountCheck(String vNaam, String ww) {
        this.vNaam = vNaam;
        this.ww = ww;
        Connectie conn = new Connectie();
        con = conn.connectie();
    }

    public int con() {
        String query = "SELECT * FROM user where Emailadres = ?";
        String s = "niks";
        String w = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                s = rs.getString("Emailadres");
                w = rs.getString("Wachtwoord");
            }
        } catch (NullPointerException e) {
            //System.out.println("e");
            //return 3;
        } catch (Exception e) {
        }
        
        if (s.equals(vNaam)) {
            if (w.equals(ww)) {
                if(checkPatient())
                    return 1;
                else if(checkArts())
                    return 2;
            }
            return 3;
        } else {
            return 4;
        }
    }

    public boolean checkPatient() {
        String queryP = "SELECT * FROM patient where Emailadres = ?";
        String email = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(queryP);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            //System.out.println(vNaam);
            if (rs.next()) {
                email = rs.getString("Emailadres");
            }
            if (email == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkArts() {
        String queryA = "SELECT * FROM Arts where Emailadres = ?";
        String email = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(queryA);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            //System.out.println(vNaam);
            if (rs.next()) {
                email = rs.getString("Emailadres");
            }
            if (email == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
