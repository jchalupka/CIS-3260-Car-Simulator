package carsimulator;

import carsimulator.carcontrols.*;
import java.awt.Frame;
import java.io.IOException;

public class CarControls {

    private final CarKeyListener keyListener;
    private final Frame carUI;
    private final Car carModel;

    public final Steering steering;
    public final GearBox gearbox;
    public final Odometer odometer;
    public final Pedals pedals;
    public final InternalTemperatureControl internalTemperatureControl;
    public final TerrainController terrainController;

    public CarControls(Frame frame, Car carModel) throws IOException {
        this.carUI = frame;
        this.carModel = carModel;

        // TODO should probably be a car controls factory
        this.steering = new Steering(this.carModel.direction);
        Gas gas = new Gas(100, 0);
        this.gearbox = new GearBox(gas);
        this.odometer = new Odometer();
        this.pedals = new Pedals(this.carModel.speed);
        this.internalTemperatureControl = new InternalTemperatureControl(21);
        this.terrainController = new TerrainController(this.carModel.speed, this.carModel.direction, this.carModel.location, this.carModel);
        
        // TODO change the order of these args
        // Note this shouldn't subclass because it's a has a not an is a
        this.keyListener = new CarKeyListener(this.carUI, this);
    }

    public synchronized void handleActionType(CarKeyListener.ActionType action) {
        // TODO hide the implementation from the handler
        // e.g. this.brake vs this.pedals.brake.
        // what is the correct way to do this?
        if (carModel.isCrashed == false) {
            switch (action) {
                case ACCELERATE:
                    this.pedals.accelerate();
                    break;
                case BRAKE:
                    this.pedals.brake();
                    break;
                case TURN_LEFT:
                    this.steering.turnLeft();
                    break;
                case TURN_RIGHT:
                    this.steering.turnRight();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CarUI carUI = new CarUI();
        carUI.setVisible(true);
    }

}
