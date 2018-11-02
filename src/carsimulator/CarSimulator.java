package carsimulator;

import carsimulator.carui.Grid;
import javax.swing.JFrame;

public class CarSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grid application = new Grid();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
