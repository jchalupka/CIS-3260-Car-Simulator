package carsimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CarKeyListener handles keyboard inputs.
 */
public class CarKeyListener implements KeyListener {

    // Simple logger to log events
    private static final Logger logger = Logger.getLogger(Car.class.getName());

    // Going to call the controller when actions are found.
    private final CarControls controller;

    // Set of currently pressed keys
    private final Set<Integer> pressed = new HashSet<>();

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
        UNKNOWN("Unknown");

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
        private synchronized static ActionType getActionType(int c) {
            switch (c) {
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
        // Doesn't do anything
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        this.pressed.add(e.getKeyCode());
        // Iterate over pressed to get the keys.
        for (int c : pressed) {
            ActionType action = ActionType.getActionType(c);
            if (action == ActionType.UNKNOWN) {
                return;
            }
            logger.log(Level.INFO, "keyPressed " + action);

            // Call the action in the controller
            this.controller.handleActionType(action);
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        this.pressed.remove(e.getKeyCode());
    }
}
