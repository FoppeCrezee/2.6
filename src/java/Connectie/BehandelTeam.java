/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.RequestData;
import java.util.ArrayList;

/**
 * Is een Team van drie artsen die je stuk voor stuk op kan vragen
 * @author foppe
 */
public class BehandelTeam {
    private Arts arts1;
    private Arts arts2;
    private Arts arts3;
    
    
    /**
     * @param BehandelTeam is het behandelteam waar de artsen deel van maken
     */
    public BehandelTeam(int BehandelTeam){
        RequestData data = new RequestData();
        ArrayList<Arts> lijstje = data.getBehandelTeam(BehandelTeam);
        this.arts1 = lijstje.get(0);
        this.arts2 = lijstje.get(1);
        this.arts3 = lijstje.get(2);
    }
    
    /**
     * @return De eerste arts van het behandelteam
     */
    public Arts getArts1(){
        return arts1;
    }
    
    /**
     * @return De tweede arts van het behandelteam
     */
    public Arts getArts2(){
        return arts2;
    }
    
    /**
     * @return De derde arts van het behandelteam
     */
    public Arts getArts3(){
        return arts3;
    }
}
