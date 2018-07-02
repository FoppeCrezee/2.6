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
    private int bsn;
    private String initialen;
    private String sex;
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
    //private boolean toestemming;
    private String hZiekenhuis;
    private String hBehandelaar;
    private String verdenking;

    
    /**
     * @param naam Achternaam
     * @param mail mailadres
     * @param BSN bsn
     * @param initialen initialen
     * @param sex geslacht
     * @param adres adres
     * @param postcode postcode
     * @param plaats plaats
     * @param telNummer telefoonnummer
     * @param geb_datum geboortedatum
     * @param huisNummer huisNummer
     * @param toevoeging toevoeging van het huisnummer
     * @param stadium stadium van waar de behandeling op dit moment is (0-4)
     * @param arts arts die de behandeling gaat regelen
     * @param tijd0 tijd wanneer aanvraag is ingediend
     * @param tijd1 tijd wanneer stadium1 is ingegaan
     * @param tijd2 tijd wanneer stadium2 is ingegaan
     * @param tijd3 tijd wanneer stadium3 is ingegaan
     * @param tijd4 tijd wanneer stadium4 is ingegaan
     * @param hZiekenhuis is het ziekenhuis waar de patient op dit moment wordt behandeld
     * @param hBehandelaar is de arts die op dit moment de patient in het huidige ziekenhuis behandeld
     * @param verdenking is de verdenking die de huidige arts heeft
     */
    public Patient(String naam, String mail, int BSN, String initialen, String sex, Date geb_datum,
                   String adres, String postcode, String plaats, long telNummer, int huisNummer, 
                   String toevoeging, int stadium, String arts, Date tijd0, Date tijd1, Date tijd2,
                   Date tijd3, Date tijd4, String hZiekenhuis, String hBehandelaar, String verdenking) {
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
        this.hZiekenhuis = hZiekenhuis;
        this.hBehandelaar = hBehandelaar;
        this.verdenking = verdenking;
        
        
        
        
        if(toevoeging == null){
            toevoeging = "";
            this.toevoeging = "";
        }else
            this.toevoeging = toevoeging;
    }

    public String getMail() {
        return mail;
    }
    
    public String getHuidigeBehandelaar(){
        return hBehandelaar;
    }
    
    public String getHuidigZiekenuis(){
        return hZiekenhuis;
    }
    
    public String getVerdenking(){
        return verdenking;
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
}
