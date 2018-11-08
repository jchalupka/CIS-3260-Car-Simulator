/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package carsimulator.carcontrols;

 import carsimulator.Gas;
 import org.junit.After;
 import org.junit.AfterClass;
 import org.junit.Before;
 import org.junit.BeforeClass;
 import org.junit.Test;
 import static org.junit.Assert.*;
/**
 *
 * @author kevin
 */
public class InternalTempTest {
    private static InternalTemperatureControl instance;

    public InternalTempTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        instance = new InternalTemperatureControl(21);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCurrentInternalTemp() {
        System.out.println("getCurrentInternalTemp");
        int expResult = 21;
        int result = instance.getInternalTemp();
        assertEquals(expResult, result);
    }

}
