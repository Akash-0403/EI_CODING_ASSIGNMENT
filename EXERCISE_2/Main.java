import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        SmartHomeSystem system = new SmartHomeSystem();

        // Add observers
        Observer observer1 = new SmartHomeObserver("User 1");
        system.attach(observer1);

        // Device creation
        DeviceFactory lightFactory = new LightFactory();
        DeviceFactory thermostatFactory = new ThermostatFactory();
        DeviceFactory doorLockFactory = new DoorLockFactory();

        system.addDevice(lightFactory.createDevice(1));
        system.addDevice(thermostatFactory.createDevice(2));
        system.addDevice(doorLockFactory.createDevice(3));

        // User interaction loop
        while (true) {
            System.out.println("\nSMART HOME SYSTEM MENU:");
            System.out.println("1. Add Device");
            System.out.println("2. Remove Device");
            System.out.println("\t3. Turn On Device");
            System.out.println("\t4. Turn Off Device");
            System.out.println("\t5. Set temperature for thermostat");
            System.out.println();
            System.out.println("\t6. Schedule Device");
            System.out.println("\t7. Add Automation Rule");
            System.out.println("\t8. Evaluate Automation Rules");

            System.out.println("9. Show Device Status!");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter device type (light/thermostat/door): ");
                    String type = scanner.next();
                    System.out.print("Enter device ID: ");
                    int id = scanner.nextInt();
                    Device device = null;
                    switch (type.toLowerCase()) {
                        case "light":
                            device = lightFactory.createDevice(id);
                            break;
                        case "thermostat":
                            device = thermostatFactory.createDevice(id);
                            break;
                        case "door":
                            device = doorLockFactory.createDevice(id);
                            break;
                        default:
                            System.out.println("Invalid device type.");
                            continue;
                    }
                    System.out.println();
                    system.addDevice(device);
                    break;

                case 2:
                    System.out.print("Enter device ID to remove: ");
                    int removeId = scanner.nextInt();
                    Device removeDevice = system.getDeviceById(removeId);
                    if (removeDevice != null) {
                        System.out.println();
                        system.removeDevice(removeDevice);
                    } else {
                        System.out.println("Device not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter device ID to turn on: ");
                    int turnOnId = scanner.nextInt();
                    System.out.println();
                    system.turnOnDevice(turnOnId);
                    break;

                case 4:
                    System.out.print("Enter device ID to turn off: ");
                    int turnOffId = scanner.nextInt();
                    System.out.println();
                    system.turnOffDevice(turnOffId);
                    break;

                case 5:
                    System.out.print("Enter thermostat ID: ");
                    int thermostatID = scanner.nextInt();
                    Thermostat thermostat = (Thermostat) system.getDeviceById(thermostatID);
                    if (thermostat != null) {
                        System.out.print("Enter temperature to set: ");
                        int temperature = scanner.nextInt();
                        thermostat.setTemperature(temperature);
                        System.out.println();
                        System.out.println("Thermostat ID " + thermostatID + " set to " + temperature + " degrees.");
                    } else {
                        System.out.println();
                        System.out.println("Thermostat not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter device ID to schedule: ");
                    int scheduleId = scanner.nextInt();
                    System.out.print("Enter delay in seconds: ");
                    long delay = scanner.nextLong();
                    System.out.print("Enter action (turnOn/turnOff): ");
                    String action = scanner.next();
                    if (action.equalsIgnoreCase("turnOn")) {
                        System.out.println();
                        system.scheduleTurnOn(scheduleId, delay, TimeUnit.SECONDS);
                        TimeUnit.SECONDS.sleep(delay + 1);
                    } else if (action.equalsIgnoreCase("turnOff")) {
                        System.out.println();
                        system.scheduleTurnOff(scheduleId, delay, TimeUnit.SECONDS);
                        TimeUnit.SECONDS.sleep(delay + 1);
                    } else {
                        System.out.println("Invalid action.");
                    }
                    break;

                case 7:
                    System.out.print("Enter thermostat ID: ");
                    int thermostatId = scanner.nextInt();
                    System.out.print("Enter temperature threshold: ");
                    int threshold = scanner.nextInt();
                    System.out.print("Enter control device ID: ");
                    int controlDeviceId = scanner.nextInt();
                    System.out.print("Turn off (true/false): ");
                    boolean turnOff = scanner.nextBoolean();
                    System.out.println();
                    AutomationRule rule = new TemperatureAutomationRule(system, thermostatId, threshold,
                            controlDeviceId, turnOff);
                    System.out.println();
                    system.addAutomationRule(rule);
                    break;

                case 8:
                    System.out.println();
                    system.evaluateAutomationRules();
                    break;

                case 9:
                    System.out.println();
                    system.showDevices();
                    break;

                case 10:
                    system.shutdownScheduler();
                    System.out.println();
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

            }
        }
    }
}
