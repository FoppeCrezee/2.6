/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connectie.Connectie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author foppe
 */
public class AddData {

    protected Connection con = null;

    public int addPatient(String naam, String ini, String sex, String datum, String adres, int nummer, String toev,
            String postcode, String plaats, int tel, String mail, int bsn, int geweest, String ww) {
        
        Connectie conn = new Connectie();
        con = conn.connectie();

        String queryUser = "INSERT INTO User (Emailadres, Wachtwoord) VALUES (?,?);";
        String query = "INSERT INTO Patient (BSN, Achternaam, Initialen, Geslacht, Geboortedatum, Adres, Huisnummer, toevoeging, Postcode, Plaats, Telefoonnummer, "
                + "Emailadres, AVL_geweest, stadium, tijd0, tijd1, tijd2, tijd3, tijd4) VALUES (?, ?, ?, ?, str_to_date(?,'%d-%m-%Y'), ?, ?, ?, ?, ?, ?, ?, ?, 0, str_to_date(?,'%d-%m-%Y %H:%i'), '', '', '' , '');";
        PreparedStatement pst = null;
        PreparedStatement us = null;
        Time time = new Time();
        String tijd = time.getCurrentTime();
        try {
            us = con.prepareStatement(queryUser);
            us.setString(1, mail);
            us.setString(2, ww);
            us.execute();
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, bsn);
                pst.setString(2, naam);
                pst.setString(3, ini);
                pst.setString(4, sex);
                pst.setString(5, datum);
                pst.setString(6, adres);
                pst.setInt(7, nummer);
                pst.setString(8, toev);
                pst.setString(9, postcode);
                pst.setString(10, plaats);
                pst.setInt(11, tel);
                pst.setString(12, mail);
                pst.setInt(13, geweest);
                pst.setString(14, tijd);

                pst.execute();
                //con.close();
                return 1;

            } catch (SQLException ex) {
                System.out.println(ex);
                String queryDelete = "INSERT INTO User (Emailadres, Wachtwoord) VALUES (?,?);";
                PreparedStatement del = null;
                del = con.prepareStatement(queryDelete);
                del.setString(1, mail);
                del.setString(2, ww);
                del.executeUpdate();
               // con.close();
                return 2;
            }
            
        } catch (Exception e) {
            System.out.println(e);
            //con.close();
            return 3;
        }
    }

}
