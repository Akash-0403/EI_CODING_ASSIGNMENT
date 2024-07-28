public interface AutomationRule {
    void execute();
}

class TemperatureAutomationRule implements AutomationRule {
    private SmartHomeSystem system;
    private int thermostatId;
    private int threshold;
    private int controlDeviceId;
    private boolean turnOff;

    public TemperatureAutomationRule(SmartHomeSystem system, int thermostatId, int threshold, int controlDeviceId,
            boolean turnOff) {
        this.system = system;
        this.thermostatId = thermostatId;
        this.threshold = threshold;
        this.controlDeviceId = controlDeviceId;
        this.turnOff = turnOff;
    }

    @Override
    public void execute() {
        Thermostat thermostat = (Thermostat) system.getDeviceById(thermostatId);
        Device controlDevice = system.getDeviceById(controlDeviceId);
        if (thermostat != null && controlDevice != null) {
            if (thermostat.getTemperature() > threshold) {
                if (turnOff) {
                    system.turnOffDevice(controlDeviceId);
                } else {
                    system.turnOnDevice(controlDeviceId);
                }
            }
        }
    }
}
