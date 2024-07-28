# Decorator Pattern

The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects from the same class. This pattern is useful for adhering to the Single Responsibility Principle by allowing functionality to be divided between classes with unique areas of concern.

## Example: Coffee Decoration

In this example, the SimpleCoffee class implements the Coffee interface. The MilkDecorator and SugarDecorator classes also implement the Coffee interface and add functionality to the SimpleCoffee object by wrapping it. This allows the coffee to be decorated with milk and sugar dynamically.
