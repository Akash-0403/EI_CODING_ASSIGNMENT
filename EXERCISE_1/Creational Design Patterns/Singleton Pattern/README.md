# Singleton Pattern

The Singleton Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to it. This pattern is often used for managing shared resources such as database connections.

## Example: Database Connection

In this example, the Database class uses a private static variable to hold the single instance and provides a getInstance method to return that instance. This ensures that there is only one instance of the Database class.
