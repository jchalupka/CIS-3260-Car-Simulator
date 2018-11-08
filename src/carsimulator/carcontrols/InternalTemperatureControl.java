package carsimulator.carcontrols;

/**
 *
 * @author KevinPirabaharan
 */
public class InternalTemperatureControl {

  private int internalTemperature;

  /*
  * Create the temperature class
  * Default temperature is room temperature
  */
  public InternalTemperatureControl(int obj)
  {
      this.internalTemperature = obj;
  }

  /*
  * Return the current internal temperature
  @return temperature
  */
  public int getInternalTemp()
  {
      return this.internalTemperature;
  }

  public void resetTemperature()
  {
      this.internalTemperature = 21;
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
  public void increaseTemp(int toAdd)
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
  public void decreaseTemp(int toAdd)
  {
      this.internalTemperature -= toAdd;
  }

}
