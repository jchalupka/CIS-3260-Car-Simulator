package carsimulator.carcontrols;

import java.util.logging.Level;
import java.util.logging.Logger;
import carsimulator.Direction;

public class Steering {

    private static final Logger LOGGER = Logger.getLogger(Steering.class.getName());
    
    private final Direction direction;
    private final double turnAmount;

    public double getTurnAmount() {
        return turnAmount;
    }

    /**
     *
     * @param direction
     */
    public Steering(Direction direction) {
        this.turnAmount = (2 * Math.PI) / 50; // TODO play with this until it looks right
        this.direction = direction;
    }

    /**
     * turnLeft turns the car left and returns the direction.
     * 
     * @return direction
     */
    public double turnLeft() {
        LOGGER.log(Level.INFO, "Turning left");
        System.out.println("Turning left");
        return this.direction.increase(turnAmount);
    }

    /**
     * turnRight turns the car right
     * 
     * @return direction
     */
    public double turnRight() {
        LOGGER.log(Level.INFO, "Turning right");
        return this.direction.decrease(turnAmount);
    }
}
