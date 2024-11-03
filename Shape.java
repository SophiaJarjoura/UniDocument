// Interface DrawingAPI
public interface DrawingAPI {
    void drawShape(String shape);
}

// Implémentations de DrawingAPI
public class OpenGLAPI implements DrawingAPI {
    public void drawShape(String shape) {
        System.out.println("Drawing " + shape + " using OpenGL");
    }
}

public class DirectXAPI implements DrawingAPI {
    public void drawShape(String shape) {
        System.out.println("Drawing " + shape + " using DirectX");
    }
}

// Abstraction Shape
public abstract class Shape {
    protected DrawingAPI drawingAPI;
    protected String shape;

    protected Shape(DrawingAPI drawingAPI, String shape) {
        this.drawingAPI = drawingAPI;
        this.shape = shape;
    }

    public abstract void draw();
}

// Formes concrètes
public class Circle extends Shape {
    public Circle(DrawingAPI drawingAPI) {
        super(drawingAPI, "Circle");
    }

    public void draw() {
        drawingAPI.drawShape(shape);
    }
}

// Exemple d'ajout d'une nouvelle forme : Rectangle
public class Rectangle extends Shape {
    public Rectangle(DrawingAPI drawingAPI) {
        super(drawingAPI, "Rectangle");
    }

    public void draw() {
        drawingAPI.drawShape(shape);
    }
}

// Test dans la classe principale
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(new OpenGLAPI());
        Shape rectangle = new Rectangle(new DirectXAPI());
        circle.draw();     // Dessine le cercle avec OpenGL
        rectangle.draw();  // Dessine le rectangle avec DirectX
    }
}
