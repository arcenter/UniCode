// Code by arcenter
// https://github.com/arcenter/UniCode/

interface Draw {
    public void draw();
}

class Circle implements Draw {
    @Override
    public void draw() {
        System.out.println("Cicle drawn");
    }
}

class Rectangle implements Draw {
    @Override
    public void draw() {
        System.out.println("Rectangle drawn");
    }
}

class Triangle implements Draw {
    @Override
    public void draw() {
        System.out.println("Triangle drawn");
    }
}

public class L11Q2 {
    
    public static void main(String args[]) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
    
        circle.draw();
        rectangle.draw();
        triangle.draw();

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/