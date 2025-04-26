package smarthome.remote;

import smarthome.command.Command;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteControl {
    private Map<String, Command> slots = new HashMap<>();
    private Command lastCommand;

    public void assignCommand(String slot, Command command) {
        slots.put(slot, command);
    }

    

    public void undoButton() {
        if (lastCommand != null) {
            lastCommand.undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}

