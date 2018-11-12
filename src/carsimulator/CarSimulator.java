package carsimulator;

import carsimulator.carui.Grid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.JFrame;
import carsimulator.carcontrols.EngineTemperature;
import carsimulator.carcontrols.InternalTemperatureControl;


public class CarSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        Gas gas = new Gas(100, 100);
        Direction direction = new Direction(3 * Math.PI / 2);
        InternalTemperatureControl inTemp = new InternalTemperatureControl(21);
        EngineTemperature engineTemp = new EngineTemperature(0);
        
        Car car;
        
        try {
            car = new Car(direction, gas, inTemp, engineTemp);
        } catch (IOException ex) {
            Logger.getLogger(CarSimulator.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Grid application;
        try {
            application = new Grid(car);
        } catch (IOException ex) {
            Logger.getLogger(CarSimulator.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Thread t1 = new Thread(application);
        t1.start();
        try {
            new CarControls(application, car);
        } catch (IOException ex) {
            Logger.getLogger(CarSimulator.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
