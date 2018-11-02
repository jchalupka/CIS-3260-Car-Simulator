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
    
    public GearBox(Gas gas) {
        this.gas = gas;
        this.state = Gear.Park;
    }
    
    public Gear getCurrentGear() {
        return this.state;
    }
    
    public void setPark() {
        this.state = Gear.Park;
        LOGGER.log(Level.INFO, "Gear is in Park.");
    }
    
    public boolean hasGas() {
        return(this.gas.getCurrentGasAmount() > 0);
    }
    
//    public void checkGas() {
//        if(!this.hasGas()) {
//            LOGGER.log(Level.INFO, "Car is out of gas.");
//            this.setPark();   
//        }
//    }
    
    public void setDrive() {
        if (this.state == Gear.Park && this.hasGas()) {
            LOGGER.log(Level.INFO, "Gear shifted to drive.");
            this.state = Gear.Drive;
        }
    }
    
    public void setReverse() {
        if (this.state == Gear.Park && this.hasGas()) {
            LOGGER.log(Level.INFO, "Gear shifted to reverse");
            this.state = Gear.Reverse;
        }
    }
}
