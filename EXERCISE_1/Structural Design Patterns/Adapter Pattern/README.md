# Adapter Pattern

The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. This pattern acts as a bridge between two incompatible interfaces by wrapping one of the objects with an adapter.

## Example: VGA to HDMI Adapter

In this example, the VGAMonitor class has a connectVGA method, but it needs to be connected via HDMI. The HDMIAdapter class implements the HDMI interface and adapts the VGAMonitor to work with an HDMI interface.
