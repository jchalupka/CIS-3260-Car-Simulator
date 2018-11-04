package carsimulator;

import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Location extends Point implements Runnable {
    private final Car car;
    
    /**
     * Location is the location of the car.
     * Places the car at the starting point
     * // TODO actually place the car at the starting point
     * 
     * @param car
     */
    public Location(Car car) {
        super(48, 310);
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
        
        this.car.speed.coast();
    }
    
    @Override
    public void run() {
        while(true) {
            updateLocation();
            try {
                sleep((long) 0.5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
