package smarthome.device;

public class Thermostat {
    private int previousTemp;
    private int currentTemp;

    public void setTemperature(int temp) {
        previousTemp = currentTemp;
        currentTemp = temp;
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
    }

    public void revertTemperature() {
        currentTemp = previousTemp;
        System.out.println("[Thermostat] Reverting to previous temperature: " + previousTemp + "°C");
    }
}
