package carsimulator.carcontrols;

import java.util.logging.Logger;
import carsimulator.Speed;
import java.util.logging.Level;

public class Pedals {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Pedals.class.getName());

    public static final int BRAKE_DESCELERATION_SPEED = -10;
    public static final double ACCELERATION_SPEED = 1;

    private final Speed speed;

    /**
     * Speed is the speed of the car
     * @param speed
     */
    public Pedals(Speed speed) {
        logger.log(Level.INFO, "Created a new pedals object");
        this.speed = speed;
    }

    /**
     * brake decelerates the car by BRAKE_DESCELERATION_SPEED
     */
    public void brake() {
        logger.log(Level.INFO, "Braking");
        this.speed.decreaseSpeed(BRAKE_DESCELERATION_SPEED);
    }

    /**
     * accelerate accelerates the car by ACCELERATION_SPEED
     */
    public void accelerate() {
        logger.log(Level.INFO, "Accelerating");
        this.speed.increaseSpeed(ACCELERATION_SPEED);
    }
}
