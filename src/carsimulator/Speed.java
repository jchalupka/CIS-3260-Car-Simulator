package carsimulator;

import java.util.logging.Logger;

public class Speed {
    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    private int speed;
    
    /**
     * Speed is the speed of the car
     * @param speed 
     */
    public Speed(int speed) {
        this.speed = speed;
    }
    
    private void increaseSpeed(int speed_delta) {
        this.speed += speed_delta;
    }
    
    private void decreaseSpeed(int speed_delta) {
        this.speed -= speed_delta;
    }
}
