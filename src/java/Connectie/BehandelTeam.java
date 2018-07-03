/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.RequestData;
import java.util.ArrayList;

/**
 *
 * @author foppe
 */
public class BehandelTeam {
    private Arts arts1;
    private Arts arts2;
    private Arts arts3;
    
    public BehandelTeam(int BehandelTeam){
        RequestData data = new RequestData();
//        ArrayList<Arts> lijst = new ArrayList<Arts>();
        ArrayList<Arts> lijstje = data.getBehandelTeam(BehandelTeam);
        this.arts1 = lijstje.get(0);
        this.arts2 = lijstje.get(1);
        this.arts3 = lijstje.get(2);
    }
    
    public Arts getArts1(){
        return arts1;
    }
    
    public Arts getArts2(){
        return arts2;
    }
    
    public Arts getArts3(){
        return arts3;
    }
}
