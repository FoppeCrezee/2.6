/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.sql.Date;

/**
 *
 * @author foppe
 */
public class Patient {

    //velden
    private String naam;
    private String mail;
    //private String wachtwoord;
    private int bsn;
    private String initialen;
    //man = 1
    //vrouw = 2
    private String sex;
    //TODO ff naar kijken String?
    private Date gebDatum;
    private String adres;
    private int huisNummer;
    private String toevoeging;
    private String postcode;
    private String plaats;
    private long telNummer;
    private int stadium;
    //private boolean avl_Geweest;

    
    /**
     * @param mail mailadres
     * @param BSN bsn
     * @param initialen initialen
     * @param sex geslacht
     * @param adres adres
     * @param postcode postcode
     * @param plaats plaats
     * @param telNummer telefoonnummer
     */
    public Patient(String naam, String mail, int BSN, String initialen, String sex, Date geb_datum,
            String adres, String postcode, String plaats, long telNummer, int huisNummer, String toevoeging, int stadium) {
        this.naam = naam;
        this.huisNummer = huisNummer;
        this.mail = mail;
        this.initialen = initialen;
        this.sex = sex;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        this.bsn = BSN;
        this.gebDatum = geb_datum;
        this.telNummer = telNummer;
        this.stadium = stadium;
        if(toevoeging == null){
            toevoeging = "";
            this.toevoeging = "";
        }else
            this.toevoeging = toevoeging;
        
        //this.wachtwoord = wachtwoord;
    }

    public String getMail() {
        return mail;
    }
    
    public int getStadium(){
        return stadium;
    }
    
    public String getToevoeging(){
        return toevoeging;
    }
    
    public int getHuisNummer(){
       return huisNummer;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public Date getDatum(){
        return gebDatum;
    }
    
    public int getBSN(){
        return bsn;
    }
    public long getTelNummer(){
        return telNummer;
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
