package carsimulator.carcontrols;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Steering {
    private static final Logger logger = Logger.getLogger(Steering.class.getName());
    
    /**
     * turnLeft turns the car left.
     */
    public void turnLeft() {
        logger.log(Level.INFO, "Turning left");
    }
    
    /**
     * turnRight turns the car right.
     */
    public void turnRight() {
        
    }
}
