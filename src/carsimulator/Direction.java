package carsimulator;

public class Direction {

    private static final double MAX_TURN_AMOUNT = Math.PI * 2;
    private static final double MIN_TURN_AMOUNT = 0;
    private static final double TURN_DIFFERENCE = MAX_TURN_AMOUNT - MIN_TURN_AMOUNT;

    private double val;

    public Direction(double curDirection) {
        this.val = curDirection;
    }

    public double getDirection() {
        return val;
    }

    public static double handleWrapAround(double val) {
        val = (((val - MIN_TURN_AMOUNT) % TURN_DIFFERENCE) + TURN_DIFFERENCE) % TURN_DIFFERENCE + MIN_TURN_AMOUNT;
        return val;
    }

    public double increase(double turnAmount) {
        this.val += turnAmount;
        this.val = handleWrapAround(this.val);

        return this.val;
    }

    public double decrease(double turnAmount) {
        this.val -= turnAmount;
        this.val = handleWrapAround(this.val);

        return this.val;
    }
}
