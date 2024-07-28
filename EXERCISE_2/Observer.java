public interface Observer {
    void update(String message);
}

class SmartHomeObserver implements Observer {
    private String name;

    public SmartHomeObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: \n" + message);
    }
}
