package carsimulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class DirectionTest {

    private static Direction instance;

    public DirectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Direction(0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of handleWrapAround method, of class Direction.
     */
    @Test
    public void testHandleWrapAround() {
        System.out.println("handleWrapAround");
        
        double val = 1 * Math.PI;   
        double expResult = val;
        double result = Direction.handleWrapAround(val);
        Assert.assertEquals(expResult, result, 0.0);
        
        val = 3*Math.PI;
        expResult = 1*Math.PI;
        result = Direction.handleWrapAround(val);
        Assert.assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of increase method, of class Direction.
     */
    @Test
    public void testIncrease() {
        System.out.println("increase");
        
        double turnAmount = 0.1;
        double expResult = 0.1;
        double result = instance.increase(turnAmount);
        Assert.assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of decrease method, of class Direction.
     */
    @Test
    public void testDecrease() {
        System.out.println("decrease");
        
        double turnAmount = 0.1;
        double expResult = (2 * Math.PI) - 0.1;
        double result = instance.decrease(turnAmount);
        Assert.assertEquals(expResult, result, 0.01);
    }

}
