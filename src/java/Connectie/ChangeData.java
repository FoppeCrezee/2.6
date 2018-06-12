/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

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
    private String naam;
    private String ww;
    private HttpServletRequest request;
    private String naamm;
    private HttpServletResponse response;

    public ChangeData(String naam, String ww, HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        naamm = (String) session.getAttribute("user");
        
        
        
        Connectie conn = new Connectie();
        con = conn.connectie();
        this.naam = naam;
        this.ww = ww;
        this.naamm = naamm;
        this.request = request;
        this.response = response;
        this.main();

    }

    public void main() {
        String query = "UPDATE ding SET een = ? , twee = ? WHERE een = ?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, naam);
            pst.setString(2, ww);
            pst.setString(3, naamm);
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
       
        Cookie[] cookies = request.getCookies();
        
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookie.setValue(naam);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("wachtwoord")) {
                    cookie.setValue(ww);
                    //cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                }
                
            

            }

        }

    }

}
