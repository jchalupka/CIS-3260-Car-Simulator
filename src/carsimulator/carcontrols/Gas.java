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

    /**
     * Making this it's own function because I'm assuming it's going to have
     * special functionality later (talking to view).
     *
     * @param amount
     */
    public void useGas(int amount) {
        // TODO send notification to view to update the fuel guage.
        this.removeGas(amount);
    }

    /**
     * Removes fuel by the siphon amount.
     */
    public void siphon() {
        this.removeGas(siphonAmount);
    }

    /**
     * Removes fuel (only if there is fuel to remove).
     */
    private void removeGas(int amount) {
        this.currentGasAmount = Math.max(0, this.currentGasAmount - amount);
    }
}
