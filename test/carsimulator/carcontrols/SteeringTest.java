package carsimulator.carcontrols;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carsimulator.Direction;
import org.mockito.Mockito;

/**
 *
 * @author JordanChalupka
 */
public class SteeringTest {

    private static Steering instance;
    private static Direction direction;

    public SteeringTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        direction = Mockito.mock(Direction.class);
        instance = new Steering(direction);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of turnLeft method, of class Steering.
     */
    @Test
    public void testTurnLeft() {
        System.out.println("turnLeft");
        instance.turnLeft();
        // Turning left should increase the direction
        Mockito.verify(direction).increase(instance.getTurnAmount());

    }

    /**
     * Test of turnRight method, of class Steering.
     */
    @Test
    public void testTurnRight() {
        System.out.println("turnRight");
        instance.turnRight();
        // Turning right should decrease the direction
        Mockito.verify(direction).decrease(instance.getTurnAmount());
    }

}
