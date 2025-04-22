package smarthome.app;

import smarthome.command.TurnOffLightCommand;
import smarthome.remote.SmartHomeRemoteControl;
import smarthome.command.Command;
import smarthome.command.SetThermostatCommand;
import smarthome.command.TurnOnLightCommand;
import smarthome.device.Light;
import smarthome.device.Thermostat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(light);
        Command lightOff = new TurnOffLightCommand(light);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.assignCommand("light_on", lightOn);
        remote.assignCommand("light_off", lightOff);

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Available commands: light_on, light_off, set_temp, exit");

        while (true) {
            System.out.print("Enter command: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            if (input.equalsIgnoreCase("set_temp")) {
                System.out.print("Enter temperature (°C): ");
                try {
                    int temp = Integer.parseInt(scanner.nextLine().trim());
                    Command setTemp = new SetThermostatCommand(thermostat, temp);
                    remote.assignCommand("set_temp", setTemp); // update with new temp
                    remote.pressButton("set_temp");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid temperature input. Please enter a number.");
                }
            } else {
                remote.pressButton(input);
            }
        }

        scanner.close();
    }
}