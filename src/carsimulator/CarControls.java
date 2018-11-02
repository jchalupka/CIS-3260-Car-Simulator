package carsimulator;

import carsimulator.carcontrols.*;

public class CarControls {

    private CarKeyListener keyListener;
    private CarUI carUI;
    
    public final Steering steering;
    public final GearBox gearbox;
    public final Odometer odometer;
    public final Pedals pedals;
    public final InternalTemperatureControl internalTemperatureControl;

    public CarControls(CarUI carUI) {
        this.carUI = carUI;
        
        // TODO change the order of these args
        // Note this shouldn't subclass because it's a has a not an is a
        this.keyListener = new CarKeyListener(this.carUI, this);
        
        // TODO should probably be a car controls factory
        // TODO Speed and Direction should be taken from the Car model. 
        // Direction should really be taken from the Car model.
        Direction direction = new Direction(0.0);
        this.steering = new Steering(direction);
        this.gearbox = new GearBox();
        this.odometer = new Odometer();
        // Speed should really be taken from the Car model.
        Speed speed = new Speed();
        this.pedals = new Pedals(speed);
        this.internalTemperatureControl = new InternalTemperatureControl();
    }
    
    public static void main(String[] args) {
        CarUI carUI = new CarUI();
        new CarControls(carUI);
        carUI.setVisible(true);
    }

}
