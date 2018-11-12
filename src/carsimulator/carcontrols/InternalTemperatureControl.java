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
  public InternalTemperatureControl(double obj)
  {
      this.internalTemperature = obj;
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
  public void incrementTemp()
  {
      increaseTemp(1);
  }

  /*
  * Increase cabin temperature but a variable amount
  * @param toAdd
  */
  public void increaseTemp(double toAdd)
  {
      this.internalTemperature += toAdd;
  }

  /*
  * Increment the temperature
  */
  public void decrementTemp()
  {
      decreaseTemp(1);
  }

  /*
  * Increase cabin temperature but a variable amount
  * @param toAdd
  */
  public void decreaseTemp(double toAdd)
  {
      this.internalTemperature -= toAdd;
  }

}
