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
    
    private static Speed instance;
    
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
        instance = new Speed();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSpeed method, of class Speed.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        int expResult = 0;
        int result = instance.getSpeed();
        // Speed should be 0 when created
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseSpeed method, of class Speed.
     */
    @Test
    public void testIncreaseSpeed() {
        System.out.println("increaseSpeed");
        int speed_delta = 10;
        int expResult = 10;
        instance.increaseSpeed(speed_delta);
        int result = instance.getSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of decreaseSpeed method, of class Speed.
     */
    @Test
    public void testDecreaseSpeed() {
        System.out.println("decreaseSpeed");
        int speed_delta = -10;
        // Should not decrease speed below 0
        int expResult = 0;
        instance.decreaseSpeed(speed_delta);
        int result = instance.getSpeed();
        assertEquals(expResult, result);
    }
    
}
