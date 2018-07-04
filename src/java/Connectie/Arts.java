/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

/**
 * Class waarin een arts wordt opgeslagen en je zijn gegevens op kan vragen
 * @author foppe
 */
public class Arts {
    private String email;
    private String naam;
    private String ini;
    private String spec;
    private String bio;
    private int behandelTeam;
    
    
    /**
     * @param email is de mail van de arts
     * @param naam is de achternaam van de arts
     * @param ini zijn de initialen van de arts
     * @param spec is de specialisatie van de arts
     * @param bio is de korte biografie van de arts
     * @param behandelTeam is het behandelteam waar de arts deel van is 
     */
    public Arts(String email, String naam, String ini, String spec, String bio, int behandelTeam){
        this.email = email;
        this.naam = naam;
        this.bio = bio;
        this.ini = ini;
        this.spec = spec;
        this.behandelTeam = behandelTeam;
        
    }
    
    /**
     * @return Returns de mail van de arts
     */
    public String getMail(){
        return email;
    }
    
    /**
     * @return Returns het behandelteam van de arts
     */
    public int getBehandelTeam(){
        return behandelTeam;
    }
    
    /**
     * @return Returns de achternaam van de arts
     */
    public String getNaam(){
        return naam;
    }
    
    /**
     * @return Returns de initialen van de arts
     */
    public String getIni(){
        return ini;
    }
    
    /**
     * @return Returns de specialisatie van de arts
     */
    public String getSpec(){
        return spec;
    }
    
    /**
     * @return Returns de korte biografie van de arts
     */
    public String getBio(){
        return bio;
    }
}
