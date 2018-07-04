/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connectie.Arts;
import Connectie.BehandelTeam;
import Connectie.Connectie;
import Connectie.Patient;
import Connectie.Patienten;
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

    //velden
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
    private Timestamp tijd0 = null;
    private Timestamp tijd1 = null;
    private Timestamp tijd2 = null;
    private Timestamp tijd3 = null;
    private Timestamp tijd4 = null;

    private String hBehandelaar;
    private String hZiekenhuis;
    private String verdenking;
    private int behandelTeam;

    public RequestData() {
        Connectie conn = new Connectie();
        con = conn.connectie();
    }

    /**
     * @param rs is de resultset gekregen uit de database
     * @return Een arts object
     */
    private Arts getArts(ResultSet rs){
        String mail = null;
        String naam = null;
        String ini = null;
        String spec = null;
        String bio = null;
        int behandelTeam = 0;
        Arts artsje = null;
        try{
            mail = rs.getString("Emailadres");
                naam = rs.getString("Achternaam");
                ini = rs.getString("Initialen");
                spec = rs.getString("Specialisme");
                bio = rs.getString("Biografie");
                behandelTeam = rs.getInt("BehandelGroep");
                artsje = new Arts(mail, naam, ini, spec, bio, behandelTeam);
        }catch(Exception e){}
        return artsje;  
    }
    
    /**Geeft de gegevens van een specifieke arts
     * @param id is het id van de arts
     * @return Een arts object
     */
    public Arts getArtsData(String id) {
        String query = "SELECT * FROM arts WHERE Emailadres = ?";

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
            arts = getArts(rs);
            }
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return arts;
    }

    /**Geeft de gegevens van de artsen van een specifiek behandelteam
     * @param team is het behandelteam van de arts
     * @return Een arts object
     */
    public ArrayList<Arts> getBehandelTeam(int team) {
        String query = "SELECT * FROM arts WHERE BehandelGroep = ?";

        ArrayList<Arts> lijst = new ArrayList<Arts>();
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setInt(1, team);
            rs = pst.executeQuery();
            while (rs.next()) {
                arts = getArts(rs);
                lijst.add(arts);
            }

        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return lijst;
    }

    /**
     * Geeft de gegevens van een specifieke patient
     * @param id is het id van de patient
     * @return Een patient object
     */
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
        return patientje;

    }
    
    /**
     * Geeft alle patienten gesorteerd terug 
     * @return Een arraylist met alle patienten
     */
    public ArrayList<Patient> getPatienten() {
        //Eerst gesorteerd van groot naar klein, dan alle patienten met stadium 5 (4 in code)
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
        return lijst;

    }

    /**
     * @param rs is de resultset van de patient(en) uit de database
     * @return Een patient object
     */
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
            behandelTeam = rs.getInt("BehandelTeam");

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
                huisNummer, toevoeging, stadium, artsB, tijd0, tijd1, tijd2, tijd3, tijd4, hZiekenhuis, hBehandelaar, verdenking, behandelTeam);
        return patientje;
    }
    
    /**
     * @param tijd is de tijd van het stadium dat wordt meegegeven
     * @return De actuele tijd
     */
    private Timestamp getActTijd(Timestamp tijd) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tijd.getTime());
        cal.add(Calendar.HOUR, -Patienten.TIJDSVERSCHIL);
        Timestamp timestamp = new Timestamp(cal.getTime().getTime());
        return timestamp;
    }
}
