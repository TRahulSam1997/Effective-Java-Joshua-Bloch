package chapter3.item10.equivalencerelation.transivity.inheritance;

import chapter3.item10.equivalencerelation.transivity.Point;

import java.util.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/inheritance/CounterPointTest.java
 * Test program that uses CounterPoint as Point
 */
public class CounterPointTest {
    /** Initialize unitCircle to contain all Points on the unit circle  (Page 43) */
    private static final Set<Point> unitCircle = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1)
    );

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,  0);
        Point p2 = new CounterPoint(1,  0);

        /** Prints true */
        System.out.println(onUnitCircle(p1));

        /** Should print true, but doesn't if Point uses getClass-based equals */
        System.out.println(onUnitCircle(p2));
    }
}