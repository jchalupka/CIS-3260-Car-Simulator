package carsimulator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Car is data model of the car.
 */
public class Car {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());

    private Location location;
    
    // Note I think these should really be private, but I need them to be accessible by CarController for setting and reading.
    // Is there an easy way for me to pass them the setter and getter?
    // TODO this
    public Direction direction;
    public Speed speed;
    public Gas gas;

    /**
     *
     * @param direction
     * @param gas
     */
    public Car(Direction direction, Gas gas) {
        // TODO add the rest of the variables here as their class is implemented
        this.direction = direction;
        this.gas = gas;
        this.location = new Location(this);
        // TODO this might not be the correct way to print it.
        logger.log(Level.INFO, "Created a new car: {0}", this);
        this.speed = new Speed();
        
        // Start updating the location
        Thread t1 = new Thread(location);
        t1.start();
    }

    /**
     * ******************************************
     * Getters and Setters ******************************************
     */
    /**
     * Gets the cars current location on the map.
     *
     * @return
     */
    public Location getLocation() {
        logger.log(Level.INFO, "Location: {0}", this.location);
        return this.location;
    }

    /**
     * setLocation sets the cars current location on the map.
     *
     * @param location
     */
    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
        logger.log(Level.INFO, "Location Updated: {0}", this.location);
    }

    /**
     * getSpeed gets the cars current speed.
     *
     * @return
     */
    public int getSpeed() {
        logger.log(Level.INFO, "Speed: {0}", this.speed);
        return this.speed.getSpeed();
    }

    /**
     * getCurrentGasAmount gets the current amount of gas in the car.
     *
     * @return
     */
    public int getCurrentGasAmount() {
        logger.log(Level.INFO, "Gas: {0}", this.gas.getCurrentGasAmount());
        return this.gas.getCurrentGasAmount();
    }

    public double getDirection() {
        logger.log(Level.INFO, "Direction: {0}", this.location);
        return this.direction.getDirection();
    }
    /**
     * ******************************************
     * End of Getters and Setters ******************************************
     */
}
