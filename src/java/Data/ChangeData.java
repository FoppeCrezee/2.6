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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
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

    
    
    public ChangeData(){
        Connectie conn = new Connectie();
        con = conn.connectie();
    }
    
    
    public ChangeData(String ini, String sex, String adres, String postcode, String plaats, 
            String naam, int bsn, long tel, int nummer, String toevoeging, HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        eersteMail = (String) session.getAttribute("user");
        
        Connectie conn = new Connectie();
        con = conn.connectie();
        this.mail = mail;
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

    public void main() {
        String query = "UPDATE patient SET Achternaam = ?, BSN = ?, Huisnummer = ?, toevoeging = ?, Telefoonnummer = ?, Emailadres = ? , "
                + "Initialen = ? , Geslacht = ? , Adres = ? , Postcode = ? , Plaats = ? WHERE Emailadres = ?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, naam);
            pst.setInt(2, bsn);
            pst.setInt(3, nummer);
            pst.setString(4, toevoeging);
            pst.setLong(5, tel);
            pst.setString(6, mail);
            pst.setString(7, ini);
            pst.setString(8, sex);
            pst.setString(9, adres);
            pst.setString(10, postcode);
            pst.setString(11, plaats);
            pst.setString(12, eersteMail);
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
        /*Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookie.setValue(mail);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("init")) {
                    cookie.setValue(ini);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("sex")) {
                    cookie.setValue(sex);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("adres")) {
                    cookie.setValue(adres);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("postcode")) {
                    cookie.setValue(postcode);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("plaats")) {
                    cookie.setValue(plaats);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                
            

            }

        }*/

    }
    
    public void changeStadium(String patientNaam, String artsNaam, int stadium){
        String query= "UPDATE patient SET stadium = ?, beh_arts = ? WHERE Emailadres = ?;";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, stadium);
            pst.setString(2, artsNaam);
            pst.setString(3, patientNaam);
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        
    }

}
