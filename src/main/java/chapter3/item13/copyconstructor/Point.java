package chapter3.item13.copyconstructor;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // The clone method is extralinguistic, that is, it creates an object without using a constructor
    // Unenforceable adherence to thinly documented conventions.
    @Override
    public Point clone() {
        try {
            // No cast is needed because our clone method returns Point
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    // This is a copy constructor. It creates a new Point that is a copy of an existing Point.
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public class Main {
        public static void main(String[] args) {
            Point originalPoint = new Point(5, 10);

            // Use the copy constructor to create a new Point that is a copy of originalPoint.
            // The copy constructor creates the object with 'new' as is the normal mechanism.
            Point copiedPoint = new Point(originalPoint);

            System.out.println("Original point: (" + originalPoint.getX() + ", " + originalPoint.getY() + ")");
            System.out.println("Copied point: (" + copiedPoint.getX() + ", " + copiedPoint.getY() + ")");
        }
    }

}

// Can create conflicts for clone() if final fields are in a class.
final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public ImmutablePoint clone() {
        try {
            // super.clone() won't work properly because of final fields.
            return (ImmutablePoint) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    public static void main(String[] args) {
        ImmutablePoint original = new ImmutablePoint(1, 2);
        // This clone won't work.
        ImmutablePoint cloned = original.clone();

        System.out.println("Original X: " + original.getX() + ", Y: " + original.getY());
        System.out.println("Cloned X: " + cloned.getX() + ", Y: " + cloned.getY());
    }
}

// The clone() method in the Object class returns an Object, so we have to cast it to the appropriate type.
class MyClass implements Cloneable {
    int id;
    String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass obj1 = new MyClass(1, "Test");
        MyClass obj2 = (MyClass) obj1.clone(); // casting
    }
}
