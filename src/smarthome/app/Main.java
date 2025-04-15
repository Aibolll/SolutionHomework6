package smarthome.app;

import smarthome.remote.SmartHomeRemoteControl;
import smarthome.command.Command;
import smarthome.command.SetThermostatCommand;
import smarthome.command.TurnOnLightCommand;
import smarthome.device.Light;
import smarthome.device.Thermostat;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(light);
        Command setTemp = new SetThermostatCommand(thermostat, 22);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.assignCommand("light_on", lightOn);
        remote.assignCommand("set_temp", setTemp);

        remote.pressButton("light_on");
        remote.pressButton("set_temp");
        remote.undoButton();  // Undo temperature
    }
}

