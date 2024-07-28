# Command Pattern

The Command Pattern is a behavioral design pattern where an object is used to encapsulate all information needed to perform an action or trigger an event at a later time. This pattern decouples the classes that invoke the operation from the ones that perform the operation.

## Example: Remote Control

In this example, the RemoteControl class holds a command and invokes its execute method. The Light class represents a receiver of the command. The LightOnCommand and LightOffCommand classes implement the Command interface to turn the light on and off, respectively.
