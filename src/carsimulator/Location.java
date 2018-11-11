package carsimulator;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Location extends Point implements Runnable {

    private final Car car;
   //private final BufferedImage img;

    public static final int start_positon_x = 36;
    public static final int start_position_y = 682;

    /**
     * Location is the location of the car. Places the car at the starting point
     * // TODO actually place the car at the starting point
     *
     * @param car
     * @throws java.io.IOException
     */
    public Location(Car car) throws IOException {
        // Start on the yellow square
        super(start_positon_x, start_position_y);
        this.car = car;
        
        // Load in the image
        //this.img = ImageIO.read(new File("Assets/map-small.png"));
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
        while (true) {
            updateLocation();
            try {
                sleep((long) 0.5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
