package carsimulator;

import java.util.logging.Logger;

public class Car {
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    private Location location;
    /**
     * TODO this needs to be contained within the range
     * 0 to 2pi, and then wrap around.  
     * There might already be something in Java for this...
     */
    private double direction;
    private int speed;
    private int fuelLevel;

    /********************************************
     * Getters and Setters
     ********************************************/
    
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    public double getDirection() {
        return direction;
    }
    
    public void setDirection(double direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    public int getFuelLevel() {
        return fuelLevel;
    }
    
    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    /********************************************
     * End of Getters and Setters
     ********************************************/
}
