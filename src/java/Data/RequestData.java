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
import java.util.ArrayList;

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

    public Arts getArtsData(String id){
        String query = "SELECT * FROM arts WHERE Emailadres = ?";
        
        String mail = null;
        String naam = null;
        
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                mail = rs.getString("Emailadres");
                naam = rs.getString("Achternaam");              
            }
            arts = new Arts(mail, naam);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return arts;
    }
    
    
    
    public Patient getPatientData(String id) {
        //Voor andere tabel, in AccountCheck wordt alleen ww met id aangevraagd. Hier komt de hele tabel... geen wachtwoord
        //ding wordt patient
        String query = "SELECT * FROM patient where Emailadres = ?";
        //String query = "SELECT * FROM ding where een = ?";
        String mail = null;
        int BSN = 0;
        String initialen = null;
        String naam = null;
        //man = 
        String sex = null;
        //TODO ff naar kijken String?
        Date gebDatum = null;
        String adres = null;
        String toevoeging = null;
        String postcode = null;
        String plaats = null;
        long telNummer = 0;
        int huisNummer = 0;
        //boolean avl_Geweest;

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
                
            }
            patient = new Patient(naam, mail, BSN, initialen, sex, gebDatum, adres, postcode, plaats, telNummer, huisNummer, toevoeging);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return patient;
    }
    
    public ArrayList<Patient> getPatienten(){
        String query = "SELECT * FROM patient";
        
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
        //boolean avl_Geweest;

        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            //System.out.println("1");
            //pst.setString(1, id);
            rs = pst.executeQuery();
            //System.out.println("2");
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
                Patient patient = new Patient(naam, mail, BSN, initialen, sex, gebDatum, adres, postcode, plaats, telNummer, huisNummer, toevoeging);
                lijst.add(patient);
                //System.out.println("3");
            }
            
            //System.out.println(patient.getMail());
            
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
   
        return lijst;
        
    }

}
