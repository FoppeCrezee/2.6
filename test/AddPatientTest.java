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

    @Test
    public void test() {
        String naam = "Peterson";
        String ini = "P.";
        String geslacht = "vrouw";
        String datum = "1983-09-12";
        String adres = "testF";
        int huis_num = 12;
        String toevoeging = null;
        String postcode = "1211 FF";
        String plaats = "TestF";
        int tel_nummer = 044567;
        String mail = "iu@hotmail.com";
        int bsn = 1612211;
        int geweest = 0;
        String ww = "test";
        String hBehandelaar = "Foppe";
        String hZiekenhuis = "UMC";
        String verdenking = "Urologie";

        AddData add = new AddData();
        System.out.println(add.addPatient(naam, ini, geslacht, datum, adres, huis_num, toevoeging, postcode, plaats, tel_nummer, mail, bsn, geweest, ww, hBehandelaar, hZiekenhuis, verdenking));
    }
}
