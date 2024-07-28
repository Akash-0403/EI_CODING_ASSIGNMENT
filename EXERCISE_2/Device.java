public interface Device {
    int getId();

    String getType();

    void turnOn();

    void turnOff();

    void getStatus();

    boolean isOn(); // Add this method
}

class Light implements Device {
    private int id;
    private String type = "light";
    private boolean isOn;

    public Light(int id) {
        this.id = id;
        this.isOn = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Light " + id + " turned on.");
        } else {
            System.out.println("Light " + id + " is already on.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Light " + id + " turned off.");
        } else {
            System.out.println("Light " + id + " is already off.");
        }
    }

    @Override
    public void getStatus() {
        System.out.println("Light " + id + " is " + (isOn ? "on" : "off"));
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

class Thermostat implements Device {
    private int id;
    private String type = "thermostat";
    private int temperature;

    public Thermostat(int id) {
        this.id = id;
        this.temperature = 70; // Default temperature
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is active.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is inactive.");
    }

    @Override
    public void getStatus() {
        System.out.println("Thermostat " + id + " temperature is " + temperature);
    }

    @Override
    public boolean isOn() {
        // Assuming thermostat is always "on" when it's active
        return true;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature);
    }

    public int getTemperature() {
        return temperature;
    }
}

class DoorLock implements Device {
    private int id;
    private String type = "door";
    private boolean isLocked;

    public DoorLock(int id) {
        this.id = id;
        this.isLocked = true; // Default to locked
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void turnOn() {
        if (isLocked) {
            isLocked = false;
            System.out.println("Door " + id + " unlocked.");
        } else {
            System.out.println("Door " + id + " is already unlocked.");
        }
    }

    @Override
    public void turnOff() {
        if (!isLocked) {
            isLocked = true;
            System.out.println("Door " + id + " locked.");
        } else {
            System.out.println("Door " + id + " is already locked.");
        }
    }

    @Override
    public void getStatus() {
        System.out.println("Door " + id + " is " + (isLocked ? "locked" : "unlocked"));
    }

    @Override
    public boolean isOn() {
        // Considering "on" as unlocked
        return !isLocked;
    }
}
