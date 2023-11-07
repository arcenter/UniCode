// Code by arcenter
// https://github.com/arcenter/UniCode/

class Shape {
    private String color;    
    private boolean filled;

    public Shape() {
        color = "Green";
        filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        String filledString = "filled";
        if (!filled)
            filledString = "not " + filledString;
        return "A Shape with color of " + color + " and " + filledString;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14*radius*radius;
    }

    public double getPerimeter() {
        return 6.28*radius;
    }

    public String toString() {
        return "A Circle with radius = " + radius + ", which is a subclass of " + super.toString();
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return length*width;
    }

    public double getPerimeter() {
        return 2*(length+width);
    }

    public String toString() {
        return "A Rectange with width = " + width + " and length = " + length + ", which is a subclass of " + super.toString();
    }
}

class Square extends Rectangle {

    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setWidth(double side) {
        setSide(side);
    }
    
    public void setLength(double side) {
        setSide(side);
    }

    public String toString() {
        return "A Square with side = " + super.getWidth() + ", which is a subclass of " + super.toString();
    }

}

public class L10Q3 {
    public static void main(String args[]) {

        Shape shape1 = new Shape();
        System.out.println(shape1.toString());

        Shape shape2 = new Shape("Red", false);
        System.out.println(shape2.toString());

        Circle circle1 = new Circle();
        System.out.println(circle1.toString());
        System.out.println(circle1.getArea());
        System.out.println(circle1.getPerimeter());
        
        Circle circle2 = new Circle(2d);
        System.out.println(circle2.toString());
        System.out.println(circle2.getArea());
        System.out.println(circle2.getPerimeter());
        
        Circle circle3 = new Circle(3d, "Yellow", false);
        System.out.println(circle3.toString());
        System.out.println(circle3.getArea());
        System.out.println(circle3.getPerimeter());
        
        Rectangle rectangle1 = new Rectangle();
        System.out.println(rectangle1.toString());
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getPerimeter());
        
        Rectangle rectangle2 = new Rectangle(2d, 3d);
        System.out.println(rectangle2.toString());
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle2.getPerimeter());
        
        Rectangle rectangle3 = new Rectangle(4d, 5d, "Black", false);
        System.out.println(rectangle3.toString());
        System.out.println(rectangle3.getArea());
        System.out.println(rectangle3.getPerimeter());
        
        Square square1 = new Square();
        System.out.println(square1.toString());
        System.out.println(square1.getArea());
        System.out.println(square1.getPerimeter());
        
        Square square2 = new Square(2d);
        System.out.println(square2.toString());
        System.out.println(square2.getArea());
        System.out.println(square2.getPerimeter());
        
        Square square3 = new Square(3d, "Blue", false);
        System.out.println(square3.toString());
        System.out.println(square3.getArea());
        System.out.println(square3.getPerimeter());

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/
