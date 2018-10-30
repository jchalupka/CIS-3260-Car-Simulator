package carsimulator.carcontrols;

import java.util.logging.Logger;
import carsimulator.Speed;

public class Pedals {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Pedals.class.getName());

    // TODO come back to these constants to see what feels right with the animation
    public static final int NATURAL_DESCELERATION_SPEED = 1; // Just a dumb guess
    public static final int BRAKE_DESCELERATION_SPEED = 4; // Just a dumb guess
    public static final int ACCELERATION_SPEED = 2; // Just a dumb guess

    private final Speed speed;

    /**
     * Speed is the speed of the car
     */
    public Pedals() {
        this.speed = new Speed();
    }

    /**
     * coast decreases speed as if coasting by NATURAL_DESCELERATION_SPEED
     */
    public void coast() {
        this.speed.decreaseSpeed(NATURAL_DESCELERATION_SPEED);
    }

    /**
     * brake decelerates the car by BRAKE_DESCELERATION_SPEED
     */
    public void brake() {
        this.speed.decreaseSpeed(BRAKE_DESCELERATION_SPEED);
    }

    /**
     * accelerate accelerates the car by ACCELERATION_SPEED
     */
    public void accelerate() {
        this.speed.increaseSpeed(ACCELERATION_SPEED);
    }
}
