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
    
    public static final int STADIUM0 = 0;
    public static final int STADIUM1 = 1;
    public static final int STADIUM2 = 2;
    public static final int STADIUM3 = 3;
    public static final int STADIUM4 = 4;
    
    
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
    private String hZiekenhuis;
    private String hBehandelaar;
    private String verdenking;
    private int behandelTeam;
    
    /**
     * In deze class worden de gegevens van een patient opgeslagen
     * 
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
     * @param behandelTeam is het behandelteam wat bij de patient is toegewezen
     */
    public Patient(String naam, String mail, int BSN, String initialen, String sex, Date geb_datum,
                   String adres, String postcode, String plaats, long telNummer, int huisNummer, 
                   String toevoeging, int stadium, String arts, Date tijd0, Date tijd1, Date tijd2,
                   Date tijd3, Date tijd4, String hZiekenhuis, String hBehandelaar, String verdenking, int behandelTeam) {
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
        this.behandelTeam = behandelTeam;
        
        if(toevoeging == null){
            this.toevoeging = "";
        }else
            this.toevoeging = toevoeging;
    }

    /**
     * @return Het behandelteam dat aan de patient is toegewezen
     */
    public int getBehandelTeam(){
        return behandelTeam;
    }
    
    /**
     * @return De mail van de patient
     */
    public String getMail() {
        return mail;
    }
    
    /**
     * @return De huisige behandelaar van de patient in het ziekenhuis waar hij nu wordt behandel 
     */
    public String getHuidigeBehandelaar(){
        return hBehandelaar;
    }
    
    /**
     * @return Het huidige ziekenhuis van de patient waar deze nu wordt behandeld
     */
    public String getHuidigZiekenuis(){
        return hZiekenhuis;
    }
    
    /**
     * @return De verdenking van de tumorgroep van de patient
     */
    public String getVerdenking(){
        return verdenking;
    }
    
    /**
     * @return Het stadium van het aanvraagproces waar de patient op dit moment in zit.
     */
    public int getStadium(){
        return stadium;
    }
    
    /**
     * @return Toevoeging van het huisnummer
     */
    public String getToevoeging(){
        return toevoeging;
    }
    
    /**
     * @return Huisnummer van de patient
     */
    public int getHuisNummer(){
       return huisNummer;
    }
    
    /**
     * @return Achternaam van de patient
     */
    public String getNaam(){
        return naam;
    }
    
    /**
     * @return Geboortedatum van de patient
     */
    public Date getDatum(){
        return gebDatum;
    }
    
    /**
     * @return BSN van de patient
     */
    public int getBSN(){
        return bsn;
    }
    
    /**
     * @return Telefoonnummer van de patient
     */
    public long getTelNummer(){
        return telNummer;
    }
    
    /**
     * @return Initialen van de patient
     */
    public String getIni() {
        return initialen;
    }
    
    /**
     * @return Geslacht van de patient
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * @return Adres van de patient
     */
    public String getAdres() {
        return adres;
    }
    
    /**
     * @return Postcode van de patient
     */
    public String getPostcode(){
        return postcode;
    }
    
    /**
     * @return Woonplaats van de patient
     */
    public String getPlaats() {
        return plaats;
    }

    /**
     * @return Huidige arts van de patient in het AVL
     */
    public String getArts(){
        return arts;
    }
    
    /**
     * @return Tijd van stadium 1 (0 in de code)
     */
    public Date getTijd0(){
        return tijd0;
    }
    
    /**
     * @return Tijd van stadium 2 (1 in de code)
     * Deze hoeft niet ingevuld te zijn
     */
    public Date getTijd1(){
        if(tijd1 == null)
            return null;
        else
            return tijd1;
    }
    
    /**
     * @return Tijd van stadium 3 (2 in de code)
     * Deze hoeft niet ingevuld te zijn
     */
    public Date getTijd2(){
        if(tijd2 == null)
            return null;
        else
            return tijd2;
    }
    
    /**
     * @return Tijd van stadium 4 (3 in de code)
     * Deze hoeft niet ingevuld te zijn
     */
    public Date getTijd3(){
        if(tijd3 == null)
            return null;
        else
            return tijd3;
    }
    
    /**
     * @return Tijd van stadium 5 (4 in de code)
     * Deze hoeft niet ingevuld te zijn
     */
    public Date getTijd4(){
        if(tijd4 == null)
            return null;
        else
            return tijd4;
    }
    
    /**
     * @return De tijd van het stadium waar de patient op dit moment in zit
     * Die hem dus als laatste is toegewezen.
     */
    public Date getTijdLaatsteStadium(){
        if(stadium == STADIUM0)
            return tijd0;
        else if(stadium == STADIUM1)
            return tijd1;
        else if(stadium == STADIUM2)
            return tijd2;
        else if(stadium == STADIUM3)
            return tijd3;
        else
            return tijd4;
    }
}
