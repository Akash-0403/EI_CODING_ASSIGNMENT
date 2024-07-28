# EI CODING ASSIGNMENT (Akash R-21IT009)

## Exercise 1: Design Patterns

### Observer Pattern
- Behavioral design pattern
- Notifies dependents of state changes

### Command Pattern
- Behavioral design pattern
- Encapsulates information to perform an action

### Factory Method Pattern
- Creational design pattern
- Defines an interface for creating objects

### Singleton Pattern
- Creational design pattern
- Ensures a class has only one instance

### Adapter Pattern
- Structural design pattern
- Allows objects with incompatible interfaces to work together

### Decorator Pattern
- Structural design pattern
- Adds behavior to objects dynamically

## Exercise 2: Smart Home System

### Overview
- Java application for managing smart home devices
- Uses Observer, Factory Method, Proxy patterns

### Features
- Add and remove devices (lights, thermostats, door locks).
- Turn devices on and off.
- Schedule device actions with a delay.
- Set thermostat temperature.
- Add automation rules for controlling devices based on temperature thresholds.
- Display the status of all devices.

### Menu Options
- Add, remove, turn on/off devices
- Schedule actions, set thermostat temperature
- Add automation rules, display device status

### Key Classes
- `Main`, `SmartHomeSystem`, `Device`
- `Light`, `Thermostat`, `DoorLock`
- `DeviceProxy`, `DeviceProxyImpl`
- `Observer`, `SmartHomeObserver`
- `DeviceFactory`, `LightFactory`, `ThermostatFactory`, `DoorLockFactory`
- `Scheduler`, `AutomationRule`, `TemperatureAutomationRule`

