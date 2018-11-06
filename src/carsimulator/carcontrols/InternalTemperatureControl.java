package carsimulator.carcontrols;

/**
 *
 * @author KevinPirabaharan
 */
public class InternalTemperatureControl {

  private double internalTemperature;

  /*
  * Create the temperature class
  * Default temperature is room temperature
  */
  public InternalTemperatureControl()
  {
      this.internalTemperature = 21.0;
  }

  /*
  * Return the current internal temperature
  @return temperature
  */
  public double getInternalTemp()
  {
      return this.internalTemperature;
  }

  public void resetTemperature()
  {
      this.internalTemperature = 0;
  }

  /*
  * Increment the temperature
  */
  public void incrementTrip()
  {
      increaseTemp(1);
  }

  /*
  * Increase cabin temperature but a variable amount
  * @param toAdd
  */
  public void increaseTemp(int toAdd)
  {
      this.internalTemperature += toAdd;
  }

  /*
  * Increment the temperature
  */
  public void decrementTrip()
  {
      decreateTemp(1);
  }

  /*
  * Increase cabin temperature but a variable amount
  * @param toAdd
  */
  public void decreaseTemp(int toAdd)
  {
      this.internalTemperature -= toAdd;
  }

}
