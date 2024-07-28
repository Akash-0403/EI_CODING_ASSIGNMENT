import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartHomeSystem {
    private List<Observer> observers;
    private List<Device> devices;
    private Scheduler scheduler;
    private Automation automation;

    public SmartHomeSystem() {
        observers = new ArrayList<>();
        devices = new ArrayList<>();
        scheduler = new Scheduler();
        automation = new Automation();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addDevice(Device device) {
        devices.add(device);
        notifyObservers("Device added: " + device.getType() + "-> ID: " + device.getId());
    }

    public void removeDevice(Device device) {
        devices.remove(device);
        notifyObservers("Device removed: " + device.getType() + "-> ID: " + device.getId());
    }

    public Device getDeviceById(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;
    }

    public void turnOnDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            if (device.isOn()) {
                System.out.println("Device ID " + id + " is already on.");
            } else {
                device.turnOn();
                notifyObservers("Device turned on: " + device.getType() + " ID: " + id);
            }
        } else {
            System.out.println("Device not found: ID " + id);
        }
    }

    public void turnOffDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            if (!device.isOn()) {
                System.out.println("Device ID " + id + " is already off.");
            } else {
                device.turnOff();
                notifyObservers("Device turned off: " + device.getType() + " ID: " + id);
            }
        } else {
            System.out.println("Device not found: ID " + id);
        }
    }

    public void showDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices present.");
        } else {
            System.out.println("Current devices:");

            for (Device device : devices) {
                if (!device.getType().equalsIgnoreCase("thermostat")) {
                    System.out.println("ID: " + device.getId() + ", Type: " + device.getType() + ", Status: "
                            + (device.isOn() ? "On" : "Off"));
                } else {
                    Thermostat thermostat = (Thermostat) device;
                    System.out.println("ID: " + device.getId() + ", Type: " + device.getType() + ", Status: "
                            + (device.isOn() ? "On" : "Off") + ", Temperature: " + (thermostat.getTemperature()));
                }
            }
        }
    }

    public void scheduleTurnOn(int id, long delay, TimeUnit unit) {
        scheduler.scheduleTask(() -> turnOnDevice(id), delay, unit);
        notifyObservers("Scheduled turn on for device ID: " + id);
    }

    public void scheduleTurnOff(int id, long delay, TimeUnit unit) {
        scheduler.scheduleTask(() -> turnOffDevice(id), delay, unit);
        notifyObservers("Scheduled turn off for device ID: " + id);
    }

    public void addAutomationRule(AutomationRule rule) {
        automation.addRule(rule);
        notifyObservers("Added automation rule");
    }

    public void evaluateAutomationRules() {
        automation.evaluateRules();
    }

    public void shutdownScheduler() {
        scheduler.shutdown();
        notifyObservers("Scheduler shutdown");
    }
}
