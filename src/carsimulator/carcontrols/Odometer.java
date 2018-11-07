package carsimulator.carcontrols;

public class Odometer {
    
    private double tripDistance;
    
    /*
    * Create the odometer class
    * Default tripDistance is 0
    */
    public Odometer()
    {
        this.tripDistance = 0;
    }
    
    /*
    * Return the current trip distance from the odometer 
    @return tripDistance
    */
    public double getDistance()
    {
        return this.tripDistance;
    }
    
    /*
    * Reset the trip distance for the odometer
    * Trip distance is set back to 0
    */
    public void resetTrip()
    {
        this.tripDistance = 0;
    }
    
    /*
    * Increment the odometer
    * The odometer will increment by 1 km
    */
    public void incrementTrip()
    {
        increaseTrip(1);
    }
    
    /*
    * Add a variable amount of kilometers to the odomerer
    * @param toAdd
    */
    public void increaseTrip(int toAdd)
    {
        this.tripDistance += toAdd;
    }
    

}
