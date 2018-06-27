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
public class Toelichting {
    private int stadium;
    private String stadium0 = "Uw aanvraag is succesvol ingediend en als uw\n" +
"aanvraag door de arts is bekeken, zal uw medisch\n" +
"dossier worden opgevraagd.";
    private String stadium1 = "Uw aanvraag is door de arts bekeken, en uw\n" +
"medisch dossier is opgevraagd bij uw huidige\n" +
"behandelaar.";
    private String stadium2 = "Uw medisch dossier is opgestuurd door uw huidige\n" +
"behandelaar, en kan nu bekeken worden door de\n" +
"arts.";
    private String stadium3 = "Uw medisch dossier is ontvangen door de arts, en\n" +
"zal nu de aanvraag bespreken.";
    private String stadium4 = "Uw aanvraag is beoordeeld, klik hier voor de uitslag.";
    
    
    
    public Toelichting(int stadium){
        this.stadium = stadium;
    }
    
    public String getToelichting(){
        String toelichting;
        if(stadium == 0)
            toelichting = stadium0;
        else if(stadium == 1)
            toelichting = stadium1;
        else if(stadium == 2)
            toelichting = stadium2;
        else if(stadium == 3)
            toelichting = stadium3;
        else
            toelichting = stadium4;
        return toelichting;
    }
}
