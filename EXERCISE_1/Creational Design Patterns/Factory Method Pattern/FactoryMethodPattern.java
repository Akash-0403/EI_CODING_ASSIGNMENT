abstract class Document {
    public abstract void print();
}

class WordDocument extends Document {
    public void print() {
        System.out.println("Word Document");
    }
}

class PdfDocument extends Document {
    public void print() {
        System.out.println("PDF Document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        doc.print();

        factory = new PdfDocumentFactory();
        doc = factory.createDocument();
        doc.print();
    }
}
