package chapter3.item10.equivalencerelation.transivity.composition;

import chapter3.item10.equivalencerelation.transivity.Color;
import chapter3.item10.equivalencerelation.transivity.Point;

import java.util.Objects;
import java.util.Set;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/composition/ColorPoint.java
 * Adds a value component without violating the equals contract (page 44)
 * We'll favour composition over inheritance to circumvent the issue with
 * extending an instantiable class while adding a value component.
 */
public class ColorPoint {
    /** Instead of extending Point we create a private field.
     * And a public view method (line 28).
     */
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}

class ColourPointTest {
    private static final Set<Point> unitCircle = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1)
    );

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {

        Point p1 = new Point(1,  0);
        Point p2 = new ColorPoint(1,  0, Color.BLUE).asPoint();

        /** Prints true */
        System.out.println(onUnitCircle(p1));
        System.out.println(onUnitCircle(p2));
    }
}