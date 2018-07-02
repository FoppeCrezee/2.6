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
    private Arts arts;

    private String mail = null;
    private int BSN = 0;
    private String initialen = null;
    private String naam = null;
    private String sex = null;
    private Date gebDatum = null;
    private String adres = null;
    private String toevoeging = null;
    private String postcode = null;
    private String plaats = null;
    private long telNummer = 0;
    private int huisNummer = 0;
    private int stadium = 0;
    private String artsB = null;
    //boolean avl_Geweest;
    private Timestamp tijd0 = null;
    private Timestamp tijd1 = null;
    private Timestamp tijd2 = null;
    private Timestamp tijd3 = null;
    private Timestamp tijd4 = null;

    private String hBehandelaar;
    private String hZiekenhuis;
    private String verdenking;

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
    

    public Patient getPatientData(String id) {
        String query = "SELECT * FROM patient where Emailadres = ?";
        Patient patientje = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                patientje = getPatient(rs);
            }

        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        // con.close();
        return patientje;

    }

    public ArrayList<Patient> getPatienten() {
        String query = "SELECT * FROM patient order by case WHEN stadium < 4 THEN stadium END desc;";

        ArrayList<Patient> lijst = new ArrayList<Patient>();
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Patient patientje = getPatient(rs);
                lijst.add(patientje);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        //con.close();
        return lijst;

    }

    private Patient getPatient(ResultSet rs) {
        try {
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
            artsB = rs.getString("beh_Arts");
            hBehandelaar = rs.getString("hBehandelaar");
            hZiekenhuis = rs.getString("hZiekenhuis");
            verdenking = rs.getString("verdenking");

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
        } catch (Exception e) {
        }
        Patient patientje = new Patient(naam, mail, BSN, initialen, sex, gebDatum, adres, postcode, plaats, telNummer,
                huisNummer, toevoeging, stadium, artsB, tijd0, tijd1, tijd2, tijd3, tijd4, hZiekenhuis, hBehandelaar, verdenking);
        return patientje;
    }

    private Timestamp getActTijd(Timestamp tijd) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tijd.getTime());
        cal.add(Calendar.HOUR, -2);
        Timestamp timestamp = new Timestamp(cal.getTime().getTime());
        return timestamp;
    }
}
