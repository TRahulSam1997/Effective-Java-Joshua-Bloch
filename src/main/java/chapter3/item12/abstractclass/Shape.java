package chapter3.item12.abstractclass;

/** Abstract Shape class. */
public abstract class Shape {
    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    /** Overriding toString method with a common string representation.
     * This will be inherited by the subclasses.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [name=" + name + ", area=" + area() + "]";
    }
}

/** Circle subclass. */
class Circle extends Shape {
    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

/** Square subclass. */
class Square extends Shape {
    private final double sideLength;

    public Square(String name, double sideLength) {
        super(name);
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }
}

class Client {
    public static void main(String[] args) {
        /** Creating a Circle object. */
        Shape circle = new Circle("MyCircle", 5);

        /** Using the inherited toString method from Shape class. */
        System.out.println(circle);

         /** Creating a Square object. */
        Shape square = new Square("MySquare", 4);

         /** Using the inherited toString method from Shape class. */
        System.out.println(square);
    }
}
