package carsimulator.carcontrols;

import java.util.logging.Logger;
import carsimulator.Speed;
import java.util.logging.Level;

public class Pedals {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Pedals.class.getName());

    // TODO come back to these constants to see what feels right with the animation
    public static final int BRAKE_DESCELERATION_SPEED = -4; // Just a dumb guess
    public static final int ACCELERATION_SPEED = 5; // Just a dumb guess

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
