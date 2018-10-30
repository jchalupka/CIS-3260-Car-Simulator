/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsimulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JordanChalupka
 */
public class SpeedTest {
    
    public SpeedTest() {
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

    /**
     * Test of getMAX_SPEED method, of class Speed.
     */
    @Test
    public void testGetMAX_SPEED() {
        System.out.println("getMAX_SPEED");
        int expResult = 0;
        int result = Speed.getMAX_SPEED();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMIN_SPEED method, of class Speed.
     */
    @Test
    public void testGetMIN_SPEED() {
        System.out.println("getMIN_SPEED");
        int expResult = 0;
        int result = Speed.getMIN_SPEED();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class Speed.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Speed instance = new Speed();
        int expResult = 0;
        int result = instance.getSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseSpeed method, of class Speed.
     */
    @Test
    public void testIncreaseSpeed() {
        System.out.println("increaseSpeed");
        int speed_delta = 0;
        Speed instance = new Speed();
        instance.increaseSpeed(speed_delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseSpeed method, of class Speed.
     */
    @Test
    public void testDecreaseSpeed() {
        System.out.println("decreaseSpeed");
        int speed_delta = 0;
        Speed instance = new Speed();
        instance.decreaseSpeed(speed_delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
