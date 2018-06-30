/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connectie.Arts;
import Connectie.Connectie;
import Connectie.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author foppe
 */
public class RequestData {

    protected Connection con = null;
    protected String id;
    protected ResultSet rs;
    private Patient patient;
    private Arts arts;

    //true als patient
    public RequestData() {
        Connectie conn = new Connectie();
        con = conn.connectie();
    }

    public Arts getArtsData(String id) {
        String query = "SELECT * FROM arts WHERE Emailadres = ?";

        String mail = null;
        String naam = null;
        String ini = null;
        String spec = null;
        String bio = null;

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                mail = rs.getString("Emailadres");
                naam = rs.getString("Achternaam");
                ini = rs.getString("Initialen");
                spec = rs.getString("Specialisme");
                bio = rs.getString("Biografie");
            }
            arts = new Arts(mail, naam, ini, spec, bio);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        //con.close();
        return arts;

    }

    public Patient getPatientData(String id){
        //Voor andere tabel, in AccountCheck wordt alleen ww met id aangevraagd. Hier komt de hele tabel... geen wachtwoord
        //ding wordt patient
        String query = "SELECT * FROM patient where Emailadres = ?";
        String mail = null;
        int BSN = 0;
        String initialen = null;
        String naam = null;
        String sex = null;
        Date gebDatum = null;
        String adres = null;
        String toevoeging = null;
        String postcode = null;
        String plaats = null;
        long telNummer = 0;
        int huisNummer = 0;
        int stadium = 0;
        String arts = null;
        //boolean avl_Geweest;
        Timestamp tijd0 = null;
        Timestamp tijd1 = null;
        Timestamp tijd2 = null;
        Timestamp tijd3 = null;
        Timestamp tijd4 = null;

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                naam = rs.getString("Achternaam");
                mail = rs.getString("Emailadres");
                BSN = rs.getInt("BSN");
                initialen = rs.getString("Initialen");
                sex = rs.getString("Geslacht");
                adres = rs.getString("Adres");
                postcode = rs.getString("Postcode");
                plaats = rs.getString("Plaats");
                telNummer = rs.getLong("Telefoonnummer");
                gebDatum = rs.getDate("Geboortedatum");
                huisNummer = rs.getInt("Huisnummer");
                toevoeging = rs.getString("toevoeging");
                stadium = rs.getInt("stadium");
                arts = rs.getString("beh_Arts");

                tijd0 = rs.getTimestamp("tijd0");
                if (tijd0 != null) {
                    tijd0.setTime(getActTijd(tijd0).getTime());
                }
                tijd1 = rs.getTimestamp("tijd1");
                if (tijd1 != null) {
                    tijd1.setTime(getActTijd(tijd1).getTime());
                }
                tijd2 = rs.getTimestamp("tijd2");
                if (tijd2 != null) {
                    tijd2.setTime(getActTijd(tijd2).getTime());
                }
                tijd3 = rs.getTimestamp("tijd3");
                if (tijd3 != null) {
                    tijd3.setTime(getActTijd(tijd3).getTime());
                }
                tijd4 = rs.getTimestamp("tijd4");
                if (tijd4 != null) {
                    tijd4.setTime(getActTijd(tijd4).getTime());
                }

            }
            patient = new Patient(naam, mail, BSN, initialen, sex, gebDatum, adres, postcode, plaats, telNummer, huisNummer,
                    toevoeging, stadium, arts, tijd0, tijd1, tijd2, tijd3, tijd4);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
       // con.close();
        return patient;

    }

    public ArrayList<Patient> getPatienten() {
        String query = "SELECT * FROM patient order by case WHEN stadium < 4 THEN stadium END desc;";

        ArrayList<Patient> lijst = new ArrayList<Patient>();

        String mail = null;
        String initialen = null;
        String sex = null;
        String naam = null;
        int BSN = 0;
        //TODO ff naar kijken String?
        Date gebDatum = null;
        long telNummer = 0;
        int huisNummer = 0;
        String adres = null;
        String postcode = null;
        String plaats = null;
        String toevoeging = null;
        int stadium = 0;
        String arts = null;
        Timestamp tijd0 = null;
        Timestamp tijd1 = null;
        Timestamp tijd2 = null;
        Timestamp tijd3 = null;
        Timestamp tijd4 = null;
        //boolean avl_Geweest;

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                naam = rs.getString("Achternaam");
                mail = rs.getString("Emailadres");
                BSN = rs.getInt("BSN");
                initialen = rs.getString("Initialen");
                sex = rs.getString("Geslacht");
                adres = rs.getString("Adres");
                postcode = rs.getString("Postcode");
                plaats = rs.getString("Plaats");
                gebDatum = rs.getDate("Geboortedatum");
                telNummer = rs.getLong("Telefoonnummer");
                huisNummer = rs.getInt("Huisnummer");
                toevoeging = rs.getString("toevoeging");
                stadium = rs.getInt("stadium");
                arts = rs.getString("beh_Arts");
                tijd0 = rs.getTimestamp("tijd0");
                if (tijd0 != null) {
                    tijd0.setTime(getActTijd(tijd0).getTime());
                }
                tijd1 = rs.getTimestamp("tijd1");
                if (tijd1 != null) {
                    tijd1.setTime(getActTijd(tijd1).getTime());
                }
                tijd2 = rs.getTimestamp("tijd2");
                if (tijd2 != null) {
                    tijd2.setTime(getActTijd(tijd2).getTime());
                }
                tijd3 = rs.getTimestamp("tijd3");
                if (tijd3 != null) {
                    tijd3.setTime(getActTijd(tijd3).getTime());
                }
                tijd4 = rs.getTimestamp("tijd4");
                if (tijd4 != null) {
                    tijd4.setTime(getActTijd(tijd4).getTime());
                }

                Patient patient = new Patient(naam, mail, BSN, initialen, sex, gebDatum, adres, postcode, plaats, telNummer,
                        huisNummer, toevoeging, stadium, arts, tijd0, tijd1, tijd2, tijd3, tijd4);
                lijst.add(patient);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        //con.close();
        return lijst;

    }

    private Timestamp getActTijd(Timestamp tijd) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tijd.getTime());
        cal.add(Calendar.HOUR, -2);
        Timestamp timestamp = new Timestamp(cal.getTime().getTime());
        return timestamp;
    }

}
