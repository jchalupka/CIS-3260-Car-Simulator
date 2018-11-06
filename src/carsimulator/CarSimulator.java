package carsimulator;

import carsimulator.carui.Grid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CarSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO turn this into a factory.
        LogManager.getLogManager().reset();
        Gas gas = new Gas(100, 100);
        Direction direction = new Direction(0.0);
        
        Car car = new Car(direction, gas);
        Grid application;
        try {
            application = new Grid(car);
        } catch (IOException ex) {
            Logger.getLogger(CarSimulator.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Thread t1 = new Thread(application);
        t1.start();
        // Justin, do something similar to this in CarSimulator.
        new CarControls(application, car);
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
