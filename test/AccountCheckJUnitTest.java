/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Connectie.AccountCheck;
import Data.ChangeData;
import Data.RequestData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author foppe
 */
public class AccountCheckJUnitTest {

    public AccountCheckJUnitTest() {
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

        String vNaam = "foppecrezee@hotmail.com";
        String mail = "peterdevries@hotmail.com";
        String wrongN = "wrong";
        String wW = "test";

        AccountCheck check = new AccountCheck(vNaam, wW);
        AccountCheck arts = new AccountCheck(mail, wW);
        AccountCheck wrongWw = new AccountCheck(vNaam, wrongN);
        AccountCheck wrongName = new AccountCheck(wrongN, wW);

        Assert.assertEquals(1, check.con());
        Assert.assertEquals(2, arts.con());
        Assert.assertEquals(3, wrongWw.con());
        Assert.assertEquals(4, wrongName.con());

        Assert.assertEquals(true, check.checkPatient());
        Assert.assertEquals(false, check.checkArts());
        Assert.assertEquals(false, arts.checkPatient());
        Assert.assertEquals(true, arts.checkArts());

    }
}
