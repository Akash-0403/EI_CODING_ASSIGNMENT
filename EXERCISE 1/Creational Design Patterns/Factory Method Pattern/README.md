# Factory Method Pattern

The Factory Method Pattern is a creational design pattern that defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. This pattern is used to create objects without specifying the exact class of the object that will be created.

## Example: Document Creation

In this example, the DocumentFactory interface defines a method for creating documents. The WordDocumentFactory and PdfDocumentFactory classes implement the DocumentFactory interface to create WordDocument and PdfDocument objects, respectively.
