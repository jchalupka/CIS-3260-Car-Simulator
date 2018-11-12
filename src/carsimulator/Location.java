package carsimulator;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Location extends Point implements Runnable {

    private final Car car;
    private final BufferedImage img;

    public static final int start_positon_x = 36;
    public static final int start_position_y = 682;
    public final int max_x;
    public final int max_y;
    public final int min_x;
    public final int min_y;

    /**
     * Location is the location of the car. Places the car at the starting point
     *
     * @param car
     * @throws java.io.IOException
     */
    public Location(Car car) throws IOException {
        // Start on the yellow square
        super(start_positon_x, start_position_y);
        this.car = car;

        // Load in the image
        this.img = ImageIO.read(getClass().getClassLoader().getResource("resources/map-small.png"));
        this.max_x = this.img.getWidth() - 20;
        this.max_y = this.img.getHeight() - 20;
        this.min_x = 0;
        this.min_y = 20; // Adjusting for the menu bar
    }

    /**
     * Updates location based on speed and direction.
     *
     */
    private void updateLocation() {
        double speed = this.car.getSpeed();
        System.out.println("speed " + speed);
        double direction = this.car.getDirection();

        double velocity_x = speed * Math.cos(direction);
        double velocity_y = speed * Math.sin(direction);

        int new_x = (int) (this.x + velocity_x);
        int new_y = (int) (this.y + velocity_y);

        if (new_x <= this.max_x && new_x >= this.min_x && new_y <= this.max_y && new_y >= this.min_y) {
            this.x = new_x;
            this.y = new_y;
        }

        this.car.speed.coast();
        try {
            sleep(70);
        } catch (InterruptedException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            updateLocation();
            try {
                sleep((long) 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
