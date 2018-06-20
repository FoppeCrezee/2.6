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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        
        String vNaam = "foppecrezee@hotmail.com";
        String mail = "peterdevries@hotmail.com";
        String wrongN = "wrong";
        String wW = "test";
        
        AccountCheck check = new AccountCheck(vNaam, wW);
        AccountCheck wrongName = new AccountCheck(mail, wW);
        AccountCheck wrongWw = new AccountCheck(vNaam, wrongN);
        
        Assert.assertEquals(1, check.con());
        //Assert.assertEquals(2, wrongWw.con());
        //Assert.assertEquals(3, wrongName.con());
        
        Assert.assertEquals(true, check.checkPatient());
        Assert.assertEquals(false, check.checkArts());
        Assert.assertEquals(false, wrongName.checkPatient());
        Assert.assertEquals(true, wrongName.checkArts());
        
        
        RequestData data = new RequestData();
        System.out.println(data.getPatienten().toString());
        
        ChangeData datas = new ChangeData();
        datas.changeStadium("foppecrezee@hotmail.com", "arts@arts.nl" , 2);
    }
}
