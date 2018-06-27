/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author foppe
 */
public class Time {
    
    
    
    public String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date date = new Date();
	//System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }
}
