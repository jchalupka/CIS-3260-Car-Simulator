/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsimulator.carcontrols;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carsimulator.Speed;
import org.mockito.Mockito;

/**
 *
 * @author JordanChalupka
 */
public class PedalsTest {

    private static Pedals instance;
    private static Speed speed;

    public PedalsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        speed = Mockito.mock(Speed.class);
        instance = new Pedals(speed);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of brake method, of class Pedals.
     */
    @Test
    public void testBrake() {
        instance.brake();
        Mockito.verify(speed).decreaseSpeed(Pedals.BRAKE_DESCELERATION_SPEED);
    }

    /**
     * Test of accelerate method, of class Pedals.
     */
    @Test
    public void testAccelerate() {
        instance.accelerate();
        Mockito.verify(speed).increaseSpeed(Pedals.ACCELERATION_SPEED);
    }
}
