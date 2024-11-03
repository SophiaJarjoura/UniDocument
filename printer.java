public interface Printable {
    void print(String text);
}

public class Printer {
    public void printUpperCase(String text) {
        System.out.println(text.toUpperCase());
    }
}

// Adapter : PrintAdapter
public class PrintAdapter implements Printable {
    private Printer printer;

    public PrintAdapter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.printUpperCase(text);
    }
}

// Test dans la classe principale
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Printable adapter = new PrintAdapter(printer);
        adapter.print("hello world"); // Affiche : HELLO WORLD
    }
}
