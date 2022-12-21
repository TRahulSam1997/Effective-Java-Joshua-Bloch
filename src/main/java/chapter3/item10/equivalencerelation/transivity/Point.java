package chapter3.item10.equivalencerelation.transivity;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/Point.java
 * Simple immutable two-dimensional integer point class (Page 37)
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    /** Broken - violates Liskov substitution principle (page 43) */
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    @Override public int hashCode()  {
        return 31 * x + y;
    }
}