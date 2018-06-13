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
    private HttpServletRequest request;
    private String naamm;
    private HttpServletResponse response;

    public ChangeData(String mail, String ini, String sex, String adres, String postcode, String plaats, HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        naamm = (String) session.getAttribute("user");
        
        Connectie conn = new Connectie();
        con = conn.connectie();
        this.mail = mail;
        this.ini = ini;
        this.sex = sex;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        
        this.naamm = naamm;
        this.request = request;
        this.response = response;
        this.main();

    }

    public void main() {
        String query = "UPDATE patient SET Emailadres = ? , Initialen = ? , Geslacht = ? , Adres = ? , Postcode = ? , Plaats = ? WHERE Emailadres = ?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, mail);
            pst.setString(2, ini);
            pst.setString(3, sex);
            pst.setString(4, adres);
            pst.setString(5, postcode);
            pst.setString(6, plaats);
            pst.setString(7, naamm);
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
        Cookie[] cookies = request.getCookies();
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

        }

    }

}
