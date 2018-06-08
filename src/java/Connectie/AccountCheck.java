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
        String query = "SELECT * FROM ding where een = ?";
        String s = "niks";
        String w = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                s = rs.getString("een");
                w = rs.getString("twee");
            }
        } catch (NullPointerException e) {
            return 3;
        } catch (Exception e) {
        
        }

        if(s.equals(vNaam)){
            if(w.equals(ww)){
                return 1;
            }
            return 2;
        }
        else {
            return 3;
        } 
    }

}
