package carsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;

/**
 * CarKeyListener handles keyboard inputs.
 */
public class CarKeyListener implements KeyListener {

    // Going to call the controller when actions are found.
    private final CarControls controller;

    public CarKeyListener(Frame frame, CarControls controller) {
        frame.addKeyListener(this);
        this.controller = controller;
    }

    /**
     * The types of action the user would like to perform on the car.
     */
    public static enum ActionType {
        ACCELERATE("Accelerate"),
        BRAKE("Brake"),
        TURN_LEFT("Turn left"),
        TURN_RIGHT("Turn right"),
        UNKNOWN("Unknown");  // TODO Is there a better way to handle unknown?

        private final String desc;

        ActionType(String desc) {
            this.desc = desc;
        }

        public String String() {
            return this.desc;
        }

        /**
         * Given a KeyEvent returns the appropriate ActionType
         *
         * @param e
         * @return
         */
        private static ActionType getActionType(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    return ActionType.ACCELERATE;
                case KeyEvent.VK_DOWN:
                    return ActionType.BRAKE;
                case KeyEvent.VK_LEFT:
                    return ActionType.TURN_LEFT;
                case KeyEvent.VK_RIGHT:
                    return ActionType.TURN_RIGHT;
            }

            return ActionType.UNKNOWN;
        }
    }

    /**
     * TODO what does this actually do? It seems that only keyPressed is called.
     * Commenting this out because I don't think it does anything, but it
     * needs to be implemented.  Boo Java
     */
    @Override
    public void keyTyped(KeyEvent e) {
//        ActionType action = ActionType.getActionType(e);
//        if (action == ActionType.UNKNOWN) {
//            return;
//        }
    }

    /**
     * I think this is the only event listener that we need.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        ActionType action = ActionType.getActionType(e);
        if (action == ActionType.UNKNOWN) {
            return;
        }

        // Perform the appropriate action on the controller
        System.out.println("keyPressed " + action);
        
        // handle the action
        // this should probably be done in the controller
        this.controller.handleActionType(action);
    }

    /**
     * TODO do we really care about this?
     * Commenting this out because I don't think it does anything, but it
     * needs to be implemented.  Boo Java
     */
    @Override
    public void keyReleased(KeyEvent e) {
//        ActionType action = ActionType.getActionType(e);
//        if (action == ActionType.UNKNOWN) {
//            return;
//        }
//
//        // Perform the appropriate action on the controller
//        System.out.println("keyReleased " + action);
    }

    public static void main(String[] args) {
        // TODO when this is actually used, frame will be the UI
        Frame frame = new Frame();
        frame.setVisible(true);

        // Give the CarKeyListener the frame
        
        // Just commenting this out because I'm changing the CarKeyListener constructor right now and it's breaking.
        // new CarKeyListener(frame);

    }

}
