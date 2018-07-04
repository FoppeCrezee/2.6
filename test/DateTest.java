/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Connectie.Patienten;
import java.util.Date;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author foppe
 */
public class DateTest {

    public DateTest() {
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
        Patienten patienten = new Patienten();
        Date date = new Date();

        long sec = date.getTime() - (2 * Patienten.SECONDEN * Patienten.MINUTEN * Patienten.MILISECONDEN);

        Date date2 = new Date(sec);
        sec = sec - (69 * Patienten.SECONDEN * Patienten.MINUTEN * Patienten.MILISECONDEN);

        Date date3 = new Date(sec);
        sec = sec - (55 * Patienten.SECONDEN  * Patienten.MILISECONDEN);

        Date date4 = new Date(sec);
        sec = sec - (5 * 50 * Patienten.MILISECONDEN);

        Date date5 = new Date(sec);

        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date, 0));
        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date, 1));
        assertThat(patienten.getTijdPlus(date, 2), anyOf(is("72:00"), is("71:59")));
        assertThat(patienten.getTijdPlus(date, 3), anyOf(is("72:00"), is("71:59")));
        Assert.assertEquals("Aanvraag is afgerond", patienten.getTijdPlus(date, 4));

        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date2, 0));
        assertThat(patienten.getTijdPlus(date2, 2), anyOf(is("70:00"), is("69:59")));
        assertThat(patienten.getTijdPlus(date2, 3), anyOf(is("70:00"), is("69:59")));
        Assert.assertEquals("Aanvraag is afgerond", patienten.getTijdPlus(date2, 4));

        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date3, 0));
        assertThat(patienten.getTijdPlus(date3, 3), anyOf(is("01:00"), is("00:59")));
        Assert.assertEquals("Aanvraag is afgerond", patienten.getTijdPlus(date3, 4));

        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date4, 0));
        assertThat(patienten.getTijdPlus(date4, 3), anyOf(is("00:05"), is("00:04")));
        Assert.assertEquals("Aanvraag is afgerond", patienten.getTijdPlus(date4, 4));

        Assert.assertEquals("Dossier is nog niet binnen", patienten.getTijdPlus(date5, 0));
        Assert.assertEquals("00:00", patienten.getTijdPlus(date5, 3));
        Assert.assertEquals("Aanvraag is afgerond", patienten.getTijdPlus(date4, 4));
    }
}
