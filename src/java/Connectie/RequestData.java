/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author foppe
 */
public class RequestData {

    protected Connection con = null;
    protected String id;
    protected ResultSet rs;
    private Patient patient;

    public RequestData(String id) {
        Connectie conn = new Connectie();
        con = conn.connectie();
        this.id = id;
    }

    public Patient getData() {
        //Voor andere tabel, in AccountCheck wordt alleen ww met id aangevraagd. Hier komt de hele tabel... geen wachtwoord
        //ding wordt patient
        String query = "SELECT * FROM patient where Emailadres = ?";
        //String query = "SELECT * FROM ding where een = ?";
        String mail = null;
        int BSN;
        String initialen = null;
        //man = 
        String sex = null;
        //TODO ff naar kijken String?
        String gebDatum;
        String adres = null;
        int toevoeging;
        String postcode = null;
        String plaats = null;
        int telNummer;
        //boolean avl_Geweest;

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                mail = rs.getString("Emailadres");
                //BSN = rs.getInt("BSN");
                initialen = rs.getString("Initialen");
                sex = rs.getString("Geslacht");
                adres = rs.getString("Adres");
                postcode = rs.getString("Postcode");
                plaats = rs.getString("Plaats");               
            }
            patient = new Patient(mail, initialen, sex, adres, postcode, plaats);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return patient;

    }

}
