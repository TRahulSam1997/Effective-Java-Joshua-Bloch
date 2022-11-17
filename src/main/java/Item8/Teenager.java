package Item8;

import java.util.concurrent.TimeUnit;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item8/Teenager.java
 * Ill-behaved client of resource with cleaner safety-net (Page 33)
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");

        // Uncomment next line and retest behavior, but note that you MUST NOT depend on this behavior!
//      System.gc();
    }
}