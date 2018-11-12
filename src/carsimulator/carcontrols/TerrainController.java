package carsimulator.carcontrols;

import carsimulator.Direction;
import carsimulator.Location;
import carsimulator.Speed;
import carsimulator.Car;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class TerrainController implements Runnable {

    private final Speed speed;
    private final Location location;
    private final Direction direction;
    private BufferedImage img = null;
    private final Car carModel;
    
    private static final int ROAD = -16777216;
    private static final int GRASS = -16359103;
    private static final int WATER = -16402177;
    
    @Override
    public void run() {
        while (true) {
            try {
                // check which colour the car is on and handle it accordingly
                Colour colour = checkPixelColour();
                handlePixelColour(colour);
                sleep((long)10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TerrainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public TerrainController(Speed speed, Direction direction, Location location, Car carModel) throws IOException {
        this.speed = speed;
        this.location = location;
        this.direction = direction;
        this.carModel = carModel;

        // Load in the image
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResource("resources/map-small.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
                 
        // Kick off the terrain controller thread
        Thread t1 = new Thread(this);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }

    private enum Colour {
        BLACK,
        GREEN,
        BLUE,
        OTHER,
    }

    public Colour checkPixelColour() {
        int colour = img.getRGB(this.location.x, this.location.y);
        
        switch (colour) {
            case WATER:
                return Colour.BLUE;
            case GRASS:
                return Colour.GREEN;
            case ROAD:
                return Colour.BLACK;
            default:
                break;
        }

        // We don't care about this case, just ignore it.
        return Colour.OTHER;
    }

    private void handlePixelColour(Colour colour) {
        if (colour == Colour.BLUE) {
            // Reset the car position
            carModel.isCrashed = true;
            this.location.setLocation(Location.start_positon_x, Location.start_position_y);
            this.direction.setDirection(3 * Math.PI / 2);
            this.speed.setSpeed((0.0));
        } else if (colour == Colour.GREEN) {
            this.speed.setSpeed(this.speed.getSpeed() + Speed.GRASS_DESCELERATION_SPEED);
        }
    }

}
