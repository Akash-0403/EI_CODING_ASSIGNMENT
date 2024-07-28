
class Database {
    private static Database instance;

    private Database() {
        // private constructor
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        db1.connect();

        Database db2 = Database.getInstance();
        db2.connect();

        System.out.println(db1 == db2);
    }
}
