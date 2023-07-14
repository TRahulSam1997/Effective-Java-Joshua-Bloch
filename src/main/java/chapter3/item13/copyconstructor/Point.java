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

    // The clone method is extralinguistic, that is, it creates an object without using a constructor.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
