package carsimulator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Speed {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());

    private static final int MAX_SPEED = 100;
    private static final int MIN_SPEED = 0;

    public static final double NATURAL_DESCELERATION_SPEED = -0.5;
    public static final double GRASS_DESCELERATION_SPEED = -0.05;
    
    private double speed;

    /**
     * Speed is the speed of the car.
     *
     * speed will be set to zero upon initialization.
     */
    public Speed() {
        logger.log(Level.INFO, "Created new Speed object.");
        this.speed = 0;
    }

    public static int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public static int getMIN_SPEED() {
        return MIN_SPEED;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = Math.max(MIN_SPEED, speed);
    }
    
    /**
     * increaseSpeed increases the current speed by speed_delta. The function
     * also ensures the speed does not go above the maximum speed.
     *
     * @param speed_delta
     */
    public void increaseSpeed(double speed_delta) {
        logger.log(Level.INFO, "Increasing speed by {0}", speed_delta);
        System.out.println("increasing speed by " + speed_delta);
        this.speed = Math.min(MAX_SPEED, this.speed + speed_delta);
    }

    /**
     * decreaseSpeed decreases the current speed by speed_delta. The function
     * also ensures the speed does not go below the minimum speed.
     *
     * @param speed_delta
     */
    public void decreaseSpeed(double speed_delta) {
        logger.log(Level.INFO, "Decreasing speed by {0}", speed_delta);
        System.out.println("decreasing speed by " + speed_delta);
        this.speed = Math.max(MIN_SPEED, this.speed + speed_delta);
    }

    /**
     * coast decreases speed as if coasting by NATURAL_DESCELERATION_SPEED
     */
    public void coast() {
        logger.log(Level.INFO, "Coasting");
        this.decreaseSpeed(NATURAL_DESCELERATION_SPEED);
    }
}
