package carsimulator.carcontrols;

import carsimulator.Direction;
import carsimulator.Location;
import carsimulator.Speed;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class TerrainController implements Runnable {

    private final Speed speed;
    private final Location location;
    private final Direction direction;
    private final BufferedImage img;

    @Override
    public void run() {
        while (true) {
            // check which colour the car is on and handle it accordingly
            Colour colour = checkPixelColour();
            handlePixelColour(colour);
        }

    }

    public TerrainController(Speed speed, Direction direction, Location location) throws IOException {
        this.speed = speed;
        this.location = location;
        this.direction = direction;

        // Load in the image
        this.img = ImageIO.read(new File("Assets/map-small.png"));
    }

    private enum Colour {
        BLACK,
        GREEN,
        BLUE,
        OTHER,
    }

    public Colour checkPixelColour() {
        int colour = img.getRGB(this.location.x, this.location.y);
        //-16777216 = Road
        //-16359103 = Grass
        //-16402177 = Water
        // TODO make this a switch
        if (colour == -16402177) {
            System.out.println("Water!");
            return Colour.BLUE;
        } else if (colour == -16359103) {
            System.out.println("Grass!");
            return Colour.GREEN;
        } else if (colour == -16777216) {
            System.out.println("Road!");
            return Colour.BLACK;
        }

        // We don't care about this case, just ignore it.
        return Colour.OTHER;
    }

    private void handlePixelColour(Colour colour) {
        if (colour == Colour.OTHER || colour == Colour.BLACK) {
            // ignoring it
            return;
        } else if (colour == Colour.BLUE) { // Water
            // Reset the car position
            JOptionPane.showMessageDialog(null, "You crashed!  Position reset.");
            this.location.setLocation(Location.start_positon_x, Location.start_position_y);
            this.direction.setDirection(3 * Math.PI / 2);

        } else if (colour == Colour.GREEN) {
            // Set the car's speed to 0.
            this.speed.setSpeed(this.speed.getSpeed()/2);
        }
    }

}
