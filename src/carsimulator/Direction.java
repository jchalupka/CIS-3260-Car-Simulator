package carsimulator;

import java.util.logging.Logger;

/**
 * Direction models the direction of a car.
 */
public class Direction {
    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    // The maximum and minimum amount a car can turn
    // TODO we might not need this depending on how we handle steering, but
    // I'm leaving it in to be more flexible.
    private static final double MAX_TURN_AMOUNT = Math.PI * 2;
    private static final double MIN_TURN_AMOUNT = 0;
    private static final double TURN_DIFFERENCE = MAX_TURN_AMOUNT - MIN_TURN_AMOUNT;

    private double val;

    /**
     * 
     * @param curDirection 
     */
    public Direction(double curDirection) {
        this.val = curDirection;
    }

    /**
     * getDirection gets the cars current direction.
     * @return 
     */
    public double getDirection() {
        return val;
    }

    /**
     * handleWrapAround keeps the direction variable between the max and min
     * turn amount.
     * @param val
     * @return 
     */
    public static double handleWrapAround(double val) {
        val = (((val - MIN_TURN_AMOUNT) % TURN_DIFFERENCE) + TURN_DIFFERENCE) % TURN_DIFFERENCE + MIN_TURN_AMOUNT;
        return val;
    }

    /**
     * increase handles increasing the current direction by turnAmount.
     * @param turnAmount
     * @return 
     */
    public double increase(double turnAmount) {
        
        this.val -= turnAmount;
        this.val = handleWrapAround(this.val);

        return this.val;
    }

    /**
     * decrease handles decreasing the current direction by turnAmount.
     * @param turnAmount
     * @return 
     */
    public double decrease(double turnAmount) {
        this.val += turnAmount;
        this.val = handleWrapAround(this.val);

        return this.val;
    }
}
