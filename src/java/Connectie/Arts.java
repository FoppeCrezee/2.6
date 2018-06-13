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
    
    public Arts(String email, String naam){
        this.email = email;
        this.naam = naam;
    }
    
    public String getMail(){
        return email;
    }
    
    public String getNaam(){
        return naam;
    }
    
}
