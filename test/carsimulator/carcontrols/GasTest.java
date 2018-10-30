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
 * @author JordanChalupka
 */
public class GasTest {
    
    private static Gas instance;
    
    public GasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Gas(100,100);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentGasAmount method, of class Gas.
     */
    @Test
    public void testGetCurrentGasAmount() {
        System.out.println("getCurrentGasAmount");
        
        int expResult = 100;
        int result = instance.getCurrentGasAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of refuel method, of class Gas.
     */
    @Test
    public void testRefuel() {
        System.out.println("refuel");
        instance = new Gas(100, 0);
        instance.refuel();
        int expResult = 100;
        int result = instance.getCurrentGasAmount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUseFuel() {
        System.out.println("useFuel");
        int expResult = 50;
        instance.useGas(50);
        int result = instance.getCurrentGasAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of siphon method, of class Gas.
     */
    @Test
    public void testSiphon() {
        System.out.println("siphon");
        instance.siphon();
        int expResult = 100 - instance.getSiphonAmount();
        int result = instance.getCurrentGasAmount();
        assertEquals(expResult, result);
        
        // Testing what happens when we try to go below 0
        instance = new Gas(100, 0);
        instance.siphon();
        expResult = 0;
        result = instance.getCurrentGasAmount();
        assertEquals(expResult, result);
    }
    
}
