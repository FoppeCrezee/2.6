/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

/**
 *
 * @author foppe
 */
public class Patient {
    //velden
    private String naam;
    private String wachtwoord;
    
    public Patient(String naam, String wachtwoord){
        this.naam = naam;
        this.wachtwoord = wachtwoord;
    }
    
    public String getNaam(){
        return naam;
    }
    
    //vervangen door andere gegevens
    public String getWachtwoord(){
        return wachtwoord;
    } 
}
