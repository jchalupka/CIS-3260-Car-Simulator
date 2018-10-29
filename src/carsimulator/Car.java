package carsimulator;

import java.util.logging.Logger;

public class Car {
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    private Location location;
    private Direction direction;
    private int speed;
    private Gas gas;

    // TODO add the rest of the variables here as their class is implemented
    public Car(Direction direction, Gas gas) {
        this.direction = direction;
        this.gas = gas;
    }
    
    /********************************************
     * Getters and Setters
     ********************************************/

    public Location getLocation() {
        return location;
    }
    
    // Going to need to initially set the location
    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSpeed() {
        return speed;
    }
    
    public int getCurrentGasAmount() {
        return gas.getCurrentGasAmount();
    }
    /********************************************
     * End of Getters and Setters
     ********************************************/
}
