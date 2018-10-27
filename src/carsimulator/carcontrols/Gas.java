package carsimulator.carcontrols;

public class Gas {

    private final int maxGasAmount;
    private int currentGasAmount;
    private final int siphonAmount;

    public Gas(int maxGasAmount, int currentGasAmount) {
        this.maxGasAmount = maxGasAmount;
        this.currentGasAmount = currentGasAmount;
        this.siphonAmount = 10;
    }

    public int getCurrentGasAmount() {
        return currentGasAmount;
    }

    public int getSiphonAmount() {
        return siphonAmount;
    }

    /**
     * Only refueling to max will be allowed.
     */
    public void refuel() {
        this.currentGasAmount = this.maxGasAmount;
    }

    public void siphon() {
        // Check if there is gas left to siphon
        if (this.currentGasAmount - siphonAmount >= 0) {
            this.currentGasAmount -= siphonAmount;
        } else {
            this.currentGasAmount = 0;
        }
    }
}
