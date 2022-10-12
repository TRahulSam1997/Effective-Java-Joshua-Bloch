package Item6;
import java.util.Comparator;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item6/Sum.java
 * Hideously slow program! Can you spot the object creation? (Page 24)
 */
public class Sum {
    private static long sum() {
        /* Object creation */
        long sum = 0L;

        /* 2^31 unnecessary Long instances created due to this loop. */
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}
