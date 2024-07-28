public abstract class DeviceFactory {
    public abstract Device createDevice(int id);
}

class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice(int id) {
        return new Light(id);
    }
}

class ThermostatFactory extends DeviceFactory {
    @Override
    public Device createDevice(int id) {
        return new Thermostat(id);
    }
}

class DoorLockFactory extends DeviceFactory {
    @Override
    public Device createDevice(int id) {
        return new DoorLock(id);
    }
}
