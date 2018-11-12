package carsimulator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gas is a model of gas within a car.
 */
public class Gas {
    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    
    private final int maxGasAmount;
    private int currentGasAmount;
    private final int siphonAmount;

    /**
     * @param maxGasAmount
     * @param currentGasAmount 
     */
    public Gas(int maxGasAmount, int currentGasAmount) {
        this.maxGasAmount = maxGasAmount;
        this.currentGasAmount = currentGasAmount;
        this.siphonAmount = 10;
        
        logger.log(Level.INFO, "Created new gas object", this);
    }

    public int getCurrentGasAmount() {
        return currentGasAmount;
    }

    /**
     * getSiphonAmount gets the siphon amount for the gas.
     * @return the amount siphoned.
     */
    public int getSiphonAmount() {
        return siphonAmount;
    }

    /**
     * refuel refuels the gas.
     * Only refueling to max will be allowed.
     */
    public void refuel() {
        logger.log(Level.INFO, "Refueling");
        this.currentGasAmount = this.maxGasAmount;
    }

    /**
     * useGas makes a call to removeGas.
     * 
     * Making this it's own function because I'm assuming it's going to have
     * special functionality later (talking to view).
     *
     * @param amount
     */
    public void useGas(int amount) {
        logger.log(Level.INFO, "Decreased gas by {0}", amount);
        this.removeGas(amount);
    }

    /**
     * Removes fuel by the siphon amount.
     */
    public void siphon() {
        logger.log(Level.INFO, "Siphoning gas");
        this.removeGas(siphonAmount);
    }

    /**
     * removeGas removes fuel if there is fuel to remove.
     * 
     * @param amount 
     */
    private void removeGas(int amount) {
        this.currentGasAmount = Math.max(0, this.currentGasAmount - amount);
    }
}
