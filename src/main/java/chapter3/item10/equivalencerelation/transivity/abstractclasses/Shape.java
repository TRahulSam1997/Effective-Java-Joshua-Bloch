package chapter3.item10.equivalencerelation.transivity.abstractclasses;

public abstract class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public static void main(String[] args) {
        Shape circle = new Circle(0, 0, 5);
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int x, int y, int length, int width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }

    public static void main(String[] args) {
        Shape Rectangle = new Rectangle(0, 0, 5, 5);

        /** Impossible tp instantiate abstract class Shape */
//        Shape shape = new Shape(0, 0);
    }
}