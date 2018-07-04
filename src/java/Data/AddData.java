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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author foppe
 */
public class AddData {
    
    public static final int GELUKT = 1;
    public static final int FOUT_PATIENT = 2;
    public static final int FOUT_USER = 3;
    public static final int BESTAAT_AL = 0;
    
    protected Connection con = null;

    /**
     * Voegt een patient toe aan de database
     * 
     * @param naam Achternaam
     * @param mail mailadres
     * @param bsn bsn
     * @param ini initialen
     * @param sex geslacht
     * @param adres adres
     * @param postcode postcode
     * @param plaats plaats
     * @param tel telefoonnummer
     * @param datum geboortedatum
     * @param nummer huisNummer
     * @param toev toevoeging van het huisnummer
     * @param geweest Of de patient al een keer in het AVL is geweest
     * @param hZiekenhuis is het ziekenhuis waar de patient op dit moment wordt behandeld
     * @param hBehandelaar is de arts die op dit moment de patient in het huidige ziekenhuis behandeld
     * @param verdenking is de verdenking die de huidige arts heeft
     * @param ww is het wachtwoord van de oatient
     * 
     * @return 1 als het is gelukt, 2 als er iets fout ging bij het toevoegen van een patient
     *         3 als er iets fout gin bij het toevoegen van een user en 4 als de gebruiker al bestaat
     */
    public int addPatient(String naam, String ini, String sex, String datum, String adres, int nummer, String toev,
            String postcode, String plaats, int tel, String mail, int bsn, int geweest, String ww, String hBehandelaar, String hZiekenhuis, String verdenking) {

        String queryUser = "INSERT INTO User (Emailadres, Wachtwoord) VALUES (?,?);";
        String query = "INSERT INTO Patient (BSN, Achternaam, Initialen, Geslacht, Geboortedatum, Adres, Huisnummer, toevoeging, Postcode, Plaats, Telefoonnummer, "
                + "Emailadres, AVL_geweest, stadium, tijd0, tijd1, tijd2, tijd3, tijd4, hZiekenhuis, hBehandelaar, verdenking) "
                + "VALUES (?, ?, ?, ?, str_to_date(?, '%Y-%m-%d'), ?, ?, ?, ?, ?, ?, ?, ?, 0, str_to_date(?,'%d-%m-%Y %H:%i'), null, null, null , null, ?, ?, ?);";
        Connectie conn = new Connectie();
        con = conn.connectie();
        RequestData data = new RequestData();
        PreparedStatement pst = null;
        PreparedStatement us = null;

        if (data.getPatientData(mail) == null) {
            Date time = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String tijd = dateFormat.format(time);
            try {
                //Voet een user toe
                us = con.prepareStatement(queryUser);
                us.setString(1, mail);
                us.setString(2, ww);
                us.execute();
                try {
                    //voegt een patient toe
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
                    pst.setString(15, hZiekenhuis);
                    pst.setString(16, hBehandelaar);
                    pst.setString(17, verdenking);

                    pst.execute();
                    return GELUKT;

                } catch (SQLException ex) {
                    System.out.println(ex);
                    String queryDelete = "DELETE FROM User WHERE Emailadres = ?";
                    PreparedStatement del = null;
                    del = con.prepareStatement(queryDelete);
                    del.setString(1, mail);
                    del.executeUpdate();
                    return FOUT_PATIENT;
                }

            } catch (Exception e) {
                System.out.println(e);
                return FOUT_USER;
            }
        } else {
            //gebruiker bestaat al
            return BESTAAT_AL;
        }
    }
}
