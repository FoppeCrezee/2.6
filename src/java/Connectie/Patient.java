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
    private String mail;
    //private String wachtwoord;
    //private int BSN;
    private String initialen;
    //man = 
    private String sex;
    //TODO ff naar kijken String?
    //private String gebDatum;
    private String adres;
    //private int toevoeging;
    private String postcode;
    private String plaats;
    //private int telNummer;
    //private boolean avl_Geweest;

    public Patient(String mail, /*int BSN,*/ String initialen, String sex, /*String geb_datum,*/
            String adres, String postcode, String plaats/*, int telNummer*/) {
        this.mail = mail;
        this.initialen = initialen;
        this.sex = sex;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        //this.wachtwoord = wachtwoord;
    }

    public String getMail() {
        return mail;
    }
    
    public String getIni() {
        return initialen;
    }
    
    public String getSex() {
        return sex;
    }
    
    public String getAdres() {
        return adres;
    }
    
    public String getPostcode(){
        return postcode;
    }
    
    public String getPlaats() {
        return plaats;
    }

    //vervangen door andere gegevens
    /* public String getWachtwoord(){
        return wachtwoord;
    } */
    public void setNaam(String naam) {
        this.mail = mail;
    }

    /*public void setWachtwoord(String wachtwoord){
        this.wachtwoord = wachtwoord;
    }*/
}
