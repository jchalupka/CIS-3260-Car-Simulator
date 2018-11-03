package carsimulator;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Point;

/**
 * Car is data model of the car.
 */
public class Car {
    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    private Point location;
    private Direction direction;
    private int speed;
    private Gas gas;

    /**
     * 
     * @param direction
     * @param gas 
     */
    public Car(Direction direction, Gas gas) {
        // TODO add the rest of the variables here as their class is implemented
        this.direction = direction;
        this.gas = gas;
        this.location = new Point(47, 900);
        
        // TODO this might not be the correct way to print it.
        logger.log(Level.INFO, "Created a new car: ", this);
    }
    
    /********************************************
     * Getters and Setters
     ********************************************/
    /**
     * Gets the cars current location on the map.
     * 
     * @return 
     */
    public Point getLocation() {
        logger.log(Level.INFO, "Location: ", this.location);
        return this.location;
    }
    
    
    /**
     * setLocation sets the cars current location on the map.
     * 
     * @param location 
     */
    public void setLocation(Point location) {
        this.location = location;
        logger.log(Level.INFO, "Location Updated: ", this.location);
    }

    /**
     * getSpeed gets the cars current speed.
     * @return 
     */
    public int getSpeed() {
        logger.log(Level.INFO, "Speed: ", this.speed);
        return this.speed;
    }
    
    /**
     * getCurrentGasAmount gets the current amount of gas in the car.
     * @return 
     */
    public int getCurrentGasAmount() {
        logger.log(Level.INFO, "Gas: ", this.gas.getCurrentGasAmount());
        return this.gas.getCurrentGasAmount();
    }
    /********************************************
     * End of Getters and Setters
     ********************************************/
}
