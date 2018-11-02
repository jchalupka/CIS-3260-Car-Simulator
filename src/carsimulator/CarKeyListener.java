package carsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;

/**
 * This will implement all of the key event listeners for the car (I think)
 */
public class CarKeyListener implements KeyListener {

    public CarKeyListener(Frame frame) {
        frame.addKeyListener(this);
    }
    
    /**
     * The types of action the user would like to perform on the car.
     */
    private static enum ActionType {
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

    @Override
    public void keyTyped(KeyEvent e) {
        ActionType action = ActionType.getActionType(e);
        if (action == ActionType.UNKNOWN) {
            return;
        }
        
        // Perform the appropriate action on the controller
        System.out.println(action);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ActionType action = ActionType.getActionType(e);
        if (action == ActionType.UNKNOWN) {
            return;
        }
        
        // Perform the appropriate action on the controller
        System.out.println(action);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ActionType action = ActionType.getActionType(e);
        if (action == ActionType.UNKNOWN) {
            return;
        }
        
        // Perform the appropriate action on the controller
        System.out.println(action);
    }

    public static void main(String[] args) {
        // TODO when this is actually used, frame will be the UI
        Frame frame = new Frame();
        frame.setVisible(true);

        // Give the CarKeyListener the frame
        new CarKeyListener(frame);

    }

}
