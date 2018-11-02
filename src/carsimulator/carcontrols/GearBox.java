package carsimulator.carcontrols;

import java.util.logging.Logger;
import java.util.logging.Level;
import carsimulator.Gas;

public class GearBox {
    private static final Logger LOGGER = Logger.getLogger(GearBox.class.getName());
    private final Gas gas;
    protected enum Gear {
        Park,
        Reverse,
        Drive
    }
    private Gear state;
    
    /**
     * GearBox has one variable, state, which is an enum for indicating the
     * current gear. This variable is dependent on the gas class.
     * @param gas 
     */
    public GearBox(Gas gas) {
        this.gas = gas;
        this.state = Gear.Park;
    }
    
    /**
     * A method that returns the current Gear
     * @return enum Gear which indicates the car's current gear
     */
    public Gear getCurrentGear() {
        return this.state;
    }
    
    /**
     * Sets the state of the car to park
     */
    public void setPark() {
        this.state = Gear.Park;
        LOGGER.log(Level.INFO, "Gear is in Park.");
    }
    
    /**
     * Checks the that the current gas amount is greater than 0
     * @return a boolean that is true is the gas amount is greater than 0
     */
    public boolean hasGas() {
        return(this.gas.getCurrentGasAmount() > 0);
    }
    
//    public void checkGas() {
//        if(!this.hasGas()) {
//            LOGGER.log(Level.INFO, "Car is out of gas.");
//            this.setPark();   
//        }
//    }
    
    /**
     * Sets the state of the car to drive if there is gas and the previous
     * state was park
     */
    public void setDrive() {
        if (this.state == Gear.Park && this.hasGas()) {
            LOGGER.log(Level.INFO, "Gear shifted to drive.");
            this.state = Gear.Drive;
        }
    }
    
    /**
     * Sets the state of the car to drive if there is gas and the previous
     * state was park
     */
    public void setReverse() {
        if (this.state == Gear.Park && this.hasGas()) {
            LOGGER.log(Level.INFO, "Gear shifted to reverse");
            this.state = Gear.Reverse;
        }
    }
}
