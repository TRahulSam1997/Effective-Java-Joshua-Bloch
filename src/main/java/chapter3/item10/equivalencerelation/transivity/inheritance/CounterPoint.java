package chapter3.item10.equivalencerelation.transivity.inheritance;

import chapter3.item10.equivalencerelation.transivity.Point;

import java.util.concurrent.atomic.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/inheritance/CounterPoint.java
 * Trivial subclass of Point - doesn't add a value component (Page 43)
 * Point is subclassed with CounterPoint.
 */
public class CounterPoint extends Point {
    /** counter keeps track of how many Point instances are created.
     * FYI - AtomicInteger is thread-safe.
     */
    private static final AtomicInteger counter =
            new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public static int numberCreated() { return counter.get(); }
}