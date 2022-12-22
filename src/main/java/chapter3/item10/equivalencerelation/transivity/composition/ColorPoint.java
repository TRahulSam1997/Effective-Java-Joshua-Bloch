package chapter3.item10.equivalencerelation.transivity.composition;

import chapter3.item10.equivalencerelation.transivity.Color;
import chapter3.item10.equivalencerelation.transivity.Point;

import java.util.Objects;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/composition/ColorPoint.java
 * Adds a value component without violating the equals contract (page 44)
 */
public class ColorPoint {
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