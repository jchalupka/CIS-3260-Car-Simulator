/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsimulator.carcontrols;

/**
 *
 * @author kevin
 */
public class EngineTemperature {
     private double EngineTemperature;

  /*
  * Create the temperature class
  * Default temperature is predefined temperature
  */
  public EngineTemperature(double obj)
  {
      this.EngineTemperature = obj;
  }

  /*
  * Return the current engine temperature
  @return temperature
  */
  public double getEngineTemp()
  {
      return this.EngineTemperature;
  }

  public void resetTemperature()
  {
      this.EngineTemperature = 0;
  }

  /*
  * Increment the temperature
  */
  public void incrementTemp()
  {
      increaseTemp(0.05);
  }

  /*
  * Increase engine temperature by a consisitent amount
  * @param toAdd
  */
  public void increaseTemp(double toAdd)
  {
      this.EngineTemperature += toAdd;
  }
}
