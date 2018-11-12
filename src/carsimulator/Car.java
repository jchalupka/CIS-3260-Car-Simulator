package carsimulator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import carsimulator.carcontrols.InternalTemperatureControl;
import carsimulator.carcontrols.EngineTemperature;

/**
 * Car is data model of the car.
 */
public class Car {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());


    protected Location location;
    protected Direction direction;
    protected Speed speed;
    protected Gas gas;
    protected InternalTemperatureControl inTemp;
    protected EngineTemperature engineTemp;
    public boolean isCrashed;

    /**
     *
     * @param direction
     * @param gas
     * @throws java.io.IOException
     */
    public Car(Direction direction, Gas gas, InternalTemperatureControl inTemp, EngineTemperature engineTemp) throws IOException {
        this.direction = direction;
        this.gas = gas;
        this.location = new Location(this);
        this.speed = new Speed();
        this.isCrashed = false;
        this.inTemp = inTemp;
        this.engineTemp = engineTemp;

        // Start updating the location
        Thread t = new Thread(location);
        t.start();
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
     * @param x
     * @param y
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
    public double getSpeed() {
        logger.log(Level.INFO, "Speed: {0}", this.speed);
        return this.speed.getSpeed();
    }

    /**
     * setSpeed sets the cars speed.
     *
     * @param speed
     */
    public void setSpeed(Speed speed) {
        this.speed.setSpeed(0);
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
    
    public double getInternalTemperature() {
        return this.inTemp.getInternalTemp();
    }
    
    public double getEngineTemperature() {
        return this.engineTemp.getEngineTemp();
    }
    
    /**
     * ******************************************
     * End of Getters and Setters ******************************************
     */
}
