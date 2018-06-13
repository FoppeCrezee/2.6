/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.AddData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author foppe
 */
public class AddPatientTest {
    
    public AddPatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test() {
        String naam = "test";
        String ini = "T.";
        String geslacht = "man";
        String datum = "12-09-1998";
        String adres = "test";
        int huis_num = 1;
        String toevoeging = null;
        String postcode = "1111 AA";
        String plaats = "Test";
        int tel_nummer = 044567;
        String mail = "test@test.test";
        int bsn = 1111111;
        int geweest = 1;
        String ww = "test";
        
        AddData add = new AddData();
        add.addPatient(naam, ini, geslacht, datum, adres, huis_num, toevoeging, postcode, plaats, tel_nummer, mail, bsn, geweest, ww);
     }
}
