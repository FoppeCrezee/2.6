/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Connectie.Connectie;
import Connectie.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
public class ChangeData {

    protected Connection con = null;
    private String mail;
    private String ini;
    private String sex;
    private String adres;
    private String postcode;
    private String plaats;
    private String naam;
    private long tel;
    private int bsn;
    private int nummer;
    private String toevoeging;
    private HttpServletRequest request;
    private String eersteMail;
    private HttpServletResponse response;

    public ChangeData() {
        Connectie conn = new Connectie();
        con = conn.connectie();
    }
    /**
     * @param ini zijn de initialen
     * @param sex is het geslacht
     * @param adres is het adres van de patient
     * @param postcode is de postcode van de patient
     * @param plaats is de plaats waar de patient woont
     * @param naam is de achternaam van de patient
     * @param bsn is het bsn van de patient
     * @param tel is het telefoonnummer van de patient
     * @param nummer is het huisnummer van de patient
     * @param toevoeging is de eventuele toevoeging bij het huisnummer
     * @param request is de HttpServletRequest van de inlogsessie
     * @param response is de HttpServletResponse van de inlogsessie
     */
    public ChangeData(String ini, String sex, String adres, String postcode, String plaats,
            String naam, int bsn, long tel, int nummer, String toevoeging, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        eersteMail = (String) session.getAttribute("user");

        Connectie conn = new Connectie();
        con = conn.connectie();
        //this.mail = mail;
        this.naam = naam;
        this.ini = ini;
        this.sex = sex;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        this.bsn = bsn;
        this.nummer = nummer;
        this.toevoeging = toevoeging;
        this.tel = tel;
        this.request = request;
        this.response = response;
        this.main();
    }

    private void main() {
        String query = "UPDATE patient SET Achternaam = ?, BSN = ?, Huisnummer = ?, toevoeging = ?, Telefoonnummer = ?, "
                + "Initialen = ? , Geslacht = ? , Adres = ? , Postcode = ? , Plaats = ? WHERE Emailadres = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, naam);
            pst.setInt(2, bsn);
            pst.setInt(3, nummer);
            pst.setString(4, toevoeging);
            pst.setLong(5, tel);
            pst.setString(6, ini);
            pst.setString(7, sex);
            pst.setString(8, adres);
            pst.setString(9, postcode);
            pst.setString(10, plaats);
            pst.setString(11, eersteMail);
            pst.executeUpdate();

        } catch (SQLException ex) {
        }

    }
    
    public void changeArts(String mail, String naam, String ini, String spec, String bio){
        String query = "UPDATE Arts SET Achternaam = ?, Initialen = ?, Specialisme = ?, Biografie = ? WHERE Emailadres = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, naam);
            pst.setString(2, ini);
            pst.setString(3, spec);
            pst.setString(4, bio);
            pst.setString(5, mail);
            pst.executeUpdate();
        } catch (Exception ex) {
        System.out.println("||||" + ex);}
    }
    
    
    
    /**
     * Verandert het stadium waar de patient nu in zit, en verandert zijn behandelend arts indien nodig.
     * @param patientNaam is de naam van de patient waarvan het stadium gewijzigd moet worden
     * @param artsNaam is de naa van de arts die de wijziging doorbrengt
     * @param stadium is het nieuwe stadium dat de arts meegeeft
     */
    public void changeStadium(String patientNaam, String artsNaam, int stadium) {
        String query0 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd0 = str_to_date(?,'%d-%m-%Y %H:%i') WHERE Emailadres = ?;";
        String query1 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd1 = str_to_date(?,'%d-%m-%Y %H:%i') WHERE Emailadres = ?;";
        String query2 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd2 = str_to_date(?,'%d-%m-%Y %H:%i') WHERE Emailadres = ?;";
        String query3 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd3 = str_to_date(?,'%d-%m-%Y %H:%i') WHERE Emailadres = ?;";
        String query4 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd4 = str_to_date(?,'%d-%m-%Y %H:%i') WHERE Emailadres = ?;";
        String terug0 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd0 = str_to_date(?,'%d-%m-%Y %H:%i'), tijd1 = null, tijd2 = null, tijd3 = null, tijd4 = null WHERE Emailadres = ?;";
        String terug1 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd1 = str_to_date(?,'%d-%m-%Y %H:%i'), tijd2 = null, tijd3 = null, tijd4 = null WHERE Emailadres = ?;";
        String terug2 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd2 = str_to_date(?,'%d-%m-%Y %H:%i'), tijd3 = null, tijd4 = null WHERE Emailadres = ?;";
        String terug3 = "UPDATE patient SET stadium = ?, beh_arts = ?, tijd3 = str_to_date(?,'%d-%m-%Y %H:%i'), tijd4 = null WHERE Emailadres = ?;";

        RequestData data = new RequestData();
        Patient patient = data.getPatientData(patientNaam);
        String query;
        PreparedStatement pst;
        Time time = new Time();
        String tijd = time.getCurrentTime();
        
        if (patient.getStadium() < stadium) {
            if (stadium == 0) {
                query = query0;
            } else if (stadium == 1) {
                query = query1;
            } else if (stadium == 2) {
                query = query2;
            } else if (stadium == 3) {
                query = query3;
            } else {
                query = query4;
            }
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, stadium);
                pst.setString(2, artsNaam);
                pst.setString(3, tijd);
                pst.setString(4, patientNaam);
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (stadium < patient.getStadium()) {
            if (stadium == 0) {
                query = terug0;
            } else if (stadium == 1) {
                query = terug1;
            } else if (stadium == 2) {
                query = terug2;
            } else {
                query = terug3;
            }
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, stadium);
                pst.setString(2, artsNaam);
                pst.setString(3, tijd);
                pst.setString(4, patientNaam);
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

}
