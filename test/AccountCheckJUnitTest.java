/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Connectie.AccountCheck;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        
        String vNaam = "Foppe";
        String wrongN = "wrong";
        String wW = "test";
        
        AccountCheck check = new AccountCheck(vNaam, wW);
        AccountCheck wrongName = new AccountCheck(wrongN, wW);
        AccountCheck wrongWw = new AccountCheck(vNaam, wrongN);
        
        Assert.assertEquals(1, check.con());
        Assert.assertEquals(2, wrongWw.con());
        Assert.assertEquals(3, wrongName.con());
        
    }
}
