package chapter3.item13.copyfactory;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // This is a static factory method. It creates a new Point that is a copy of an existing Point.
    public static Point copyOf(Point other) {
        return new Point(other.x, other.y);
    }
}
