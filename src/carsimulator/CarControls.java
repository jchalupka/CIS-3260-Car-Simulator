package carsimulator;

public class CarControls {

    private CarKeyListener keyListener;
    private CarUI carUI;

    public CarControls(CarUI carUI) {
        this.carUI = carUI;
        this.keyListener = new CarKeyListener(this.carUI);
    }
    
    public static void main(String[] args) {
        CarUI carUI = new CarUI();
        new CarControls(carUI);
        carUI.setVisible(true);
    }

}
