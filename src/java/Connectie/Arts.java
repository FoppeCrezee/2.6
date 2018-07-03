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
public class Arts {
    private String email;
    private String naam;
    private String ini;
    private String spec;
    private String bio;
    private int behandelTeam;
    
    public Arts(String email, String naam, String ini, String spec, String bio, int behandelTeam){
        this.email = email;
        this.naam = naam;
        this.bio = bio;
        this.ini = ini;
        this.spec = spec;
        this.behandelTeam = behandelTeam;
        
    }
    
    public String getMail(){
        return email;
    }
    
    public int getBehandelTeam(){
        return behandelTeam;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public String getIni(){
        return ini;
    }
    
    public String getSpec(){
        return spec;
    }
    
    public String getBio(){
        return bio;
    }
}
