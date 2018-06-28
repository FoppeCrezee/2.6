/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.util.Date;

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
    private String arts;
    private Date tijd0;
    private Date tijd1;
    private Date tijd2;
    private Date tijd3;
    private Date tijd4;
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
                   String adres, String postcode, String plaats, long telNummer, int huisNummer, 
                   String toevoeging, int stadium, String arts, Date tijd0, Date tijd1, Date tijd2,
                   Date tijd3, Date tijd4) {
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
        this.arts = arts;
        this.tijd0 = tijd0;
        this.tijd1 = tijd1;
        this.tijd2 = tijd2;
        this.tijd3 = tijd3;
        this.tijd4 = tijd4;
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

    public String getArts(){
        return arts;
    }
    
    public Date getTijd0(){
        return tijd0;
    }
    
    public Date getTijd1(){
        if(tijd1 == null)
            return null;
        else
            return tijd1;
    }
    
    public Date getTijd2(){
        if(tijd2 == null)
            return null;
        else
            return tijd2;
    }
    
    public Date getTijd3(){
        if(tijd3 == null)
            return null;
        else
            return tijd3;
    }
    
    public Date getTijd4(){
        if(tijd4 == null)
            return null;
        else
            return tijd4;
    }
    
    public Date getTijdLaatsteStadium(){
        if(stadium == 0)
            return tijd0;
        else if(stadium == 1)
            return tijd1;
        else if(stadium == 2)
            return tijd2;
        else if(stadium == 3)
            return tijd3;
        else
            return tijd4;
    }
    //vervangen door andere gegevens
    /* public String getWachtwoord(){
        return wachtwoord;
    } */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /*public void setWachtwoord(String wachtwoord){
        this.wachtwoord = wachtwoord;
    }*/
}
