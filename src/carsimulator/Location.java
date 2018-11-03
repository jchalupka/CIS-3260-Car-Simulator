package carsimulator;

import java.awt.Point;
import java.util.Vector;

public class Location extends Point implements Runnable {
    private final Car car;
    
    /**
     * Location is the location of the car.
     * Places the car at 0,0
     * 
     * @param car
     */
    public Location(Car car) {
        super();
        this.car = car;
    }
    
    /**
     * Updates location based on speed and direction.
     * 
     * // TODO update this with bounds checking?
     */
    private void updateLocation() {
        int speed = this.car.getSpeed();
        double direction = this.car.getDirection();

        double velocity_x = speed * Math.cos(direction);
        double velocity_y = speed * Math.sin(direction);
        
        this.x = (int) (this.x + velocity_x);
        this.y = (int) (this.y + velocity_y);
    }
    
    @Override
    public void run() {
        updateLocation();
    }
}
