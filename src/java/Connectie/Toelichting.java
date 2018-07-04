/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

/**
 * Hierin zijn alle verschillende toelichtingen opgeslagen
 * @author foppe
 */
public class Toelichting {
    private int stadium;
    private final String stadium0 = "Uw aanvraag is succesvol ingediend en als uw\n" +
"aanvraag door de arts is bekeken, zal uw medisch\n" +
"dossier worden opgevraagd.";
    private final String stadium1 = "Uw aanvraag is door de arts bekeken, en uw\n" +
"medisch dossier is opgevraagd bij uw huidige\n" +
"behandelaar.";
    private final String stadium2 = "Uw medisch dossier is opgestuurd door uw huidige\n" +
"behandelaar, en kan nu bekeken worden door de\n" +
"arts.";
    private final String stadium3 = "Uw medisch dossier is ontvangen door de arts, en\n" +
"zal nu de aanvraag bespreken.";
    private final String stadium4 = "Uw aanvraag is beoordeeld, klik hier voor de uitslag.";
    
    
    /**
     * @param stadium is het stadium van de aanvraag waar de patient zich in begeeft
     */
    public Toelichting(int stadium){
        this.stadium = stadium;
    }
    
    /**
     * @return De toelichting bij het bijbehorende stadium
     */
    public String getToelichting(){
        String toelichting;
        if(stadium == Patient.STADIUM0)
            toelichting = stadium0;
        else if(stadium == Patient.STADIUM1)
            toelichting = stadium1;
        else if(stadium == Patient.STADIUM2)
            toelichting = stadium2;
        else if(stadium == Patient.STADIUM3)
            toelichting = stadium3;
        else
            toelichting = stadium4;
        return toelichting;
    }
}
