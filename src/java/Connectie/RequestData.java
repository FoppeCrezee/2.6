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
    
    public RequestData(String id){
        Connectie conn = new Connectie();
        con = conn.connectie();
        this.id = id;
    }
    
    public Patient getData(){
        //Voor andere tabel, in AccountCheck wordt alleen ww met id aangevraagd. Hier komt de hele tabel... geen wachtwoord
        //ding wordt patient
        String query = "SELECT * FROM ding where een = ?";
        String s = null;
        String w = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                s = rs.getString("een");
                w = rs.getString("twee");
            }
        patient = new Patient(s, w);
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return patient;
        
    }
    
}
