package carsimulator.carcontrols;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carsimulator.Gas;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Connor
 */
public class GearBoxTest {
    private static GearBox instance;
    private static Gas gas;
    
     public GearBoxTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        gas = new Gas(1,1);
        instance = new GearBox(gas);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setPark method, of class GearBox.
     */
    @Test
    public void testSetPark() {
        System.out.println("setPark");
        instance.setPark();
        // Check that the current gear is equal to park
        assertEquals(GearBox.Gear.Park, instance.getCurrentGear());
    }

    /**
     * Test of hasGas method, of class GearBox.
     */
    @Test
    public void testHasGas() {
        System.out.println("hasGas");
        // Turning right should decrease the direction
        boolean result = instance.hasGas();
        assertEquals(result, true);
    }
    
    /**
     * Test of setDrive method, of class GearBox.
     */
    @Test
    public void testSetDrive() {
        System.out.println("setDrive");
        instance.setPark();
        instance.setDrive();
        // Check that the current gear is drive
        assertEquals(GearBox.Gear.Drive, instance.getCurrentGear());
    }
    
    /**
     * Test of setReverse method, of class GearBox.
     */
    @Test
    public void testSetReverse() {
        System.out.println("setReverse");
        instance.setPark();
        instance.setReverse();
        // Check that the current gear is reverse
        assertEquals(GearBox.Gear.Reverse, instance.getCurrentGear());
    }
    
    /**
     * Test of checkGas method, of class GearBox.
     */
//    @Test
//    public void testCheckGas() {
//        System.out.println("CeckGas");
//        instance.setDrive();
//        instance.checkGas();
//        // Turning right should decrease the direction
//        boolean result = true;
//        if(instance.getCurrentGear() == GearBox.Gear.Park)
//            result = false;
//        assertEquals(result, true);
//    }
}
