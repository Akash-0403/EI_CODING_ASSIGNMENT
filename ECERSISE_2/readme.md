# Smart Home System

## Overview

The Smart Home System is a Console Based Java application that simulates the management of smart home devices, such as lights, thermostats, and door locks. It allows users to add, remove, control, and automate devices through a console-based interface. The system uses several design patterns, including the Observer, Factory Method, Proxy, and others, to demonstrate clean and maintainable code architecture.

## Features

- Add and remove devices (lights, thermostats, door locks).
- Turn devices on and off.
- Schedule device actions with a delay.
- Set thermostat temperature.
- Add automation rules for controlling devices based on temperature thresholds.
- Display the status of all devices.

## Design Patterns Used

- **Observer Pattern**: For observing changes in the smart home system.
- **Factory Method Pattern**: For creating different types of devices.
- **Proxy Pattern**: For controlling access to devices.

## Usage

1. Run the application:
   ```bash
   javac Main.java
   java Main
   ```
2. Follow the on-screen menu to interact with the Smart Home System.

## Menu Options

- **1. Add Device**: Add a new device to the system (light, thermostat, or door lock).
- **2. Remove Device**: Remove an existing device from the system.
- **3. Turn On Device**: Turn on a specified device.
- **4. Turn Off Device**: Turn off a specified device.
- **5. Schedule Device**: Schedule a device to turn on or off after a delay.
- **6. Add Automation Rule**: Add a rule to automate device control based on temperature thresholds.
- **7. Evaluate Automation Rules**: Evaluate all automation rules to control devices.
- **8. Show Devices**: Display the current status of all devices.
- **9. Set Thermostat Temperature**: Set the temperature for a specified thermostat.
- **10. Exit**: Exit the application.

## Key Classes

- **Main**: The main class containing the user interaction loop.
- **SmartHomeSystem**: Manages the devices and observers.
- **Device**: An abstract class representing a generic device.
- **Light, Thermostat, DoorLock**: Concrete implementations of the `Device` class.
- **DeviceProxy, DeviceProxyImpl**: Interfaces and classes implementing the Proxy pattern.
- **Observer, SmartHomeObserver**: Interfaces and classes for the Observer pattern.
- **DeviceFactory, LightFactory, ThermostatFactory, DoorLockFactory**: Factories for creating devices.
- **Scheduler**: Class for scheduling tasks.
- **AutomationRule, TemperatureAutomationRule**: Interfaces and classes for automation rules.

## Example Usage

```java
// Add a light device with ID 1
system.addDevice(lightFactory.createDevice(1));

// Turn on the light device with ID 1
system.turnOnDevice(1);

// Set the temperature of the thermostat with ID 2
Thermostat thermostat = (Thermostat) system.getDeviceById(2);
thermostat.setTemperature(22);
```
