public interface DeviceProxy {
    void turnOn();
    void turnOff();
    void getStatus();
}

class DeviceProxyImpl implements DeviceProxy {
    private Device device;
    private boolean hasAccess;

    public DeviceProxyImpl(Device device, boolean hasAccess) {
        this.device = device;
        this.hasAccess = hasAccess;
    }

    @Override
    public void turnOn() {
        if (hasAccess) {
            device.turnOn();
        } else {
            System.out.println("Access denied to turn on device: ID " + device.getId());
        }
    }

    @Override
    public void turnOff() {
        if (hasAccess) {
            device.turnOff();
        } else {
            System.out.println("Access denied to turn off device: ID " + device.getId());
        }
    }

    @Override
    public void getStatus() {
        if (hasAccess) {
            device.getStatus();
        } else {
            System.out.println("Access denied to get status of device: ID " + device.getId());
        }
    }
}
