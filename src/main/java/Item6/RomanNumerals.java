package Item6;
import java.util.regex.Pattern;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item6/RomanNumerals.java
 * Reusing expensive object for improved performance (Pages 22 and 23)
 */
public class RomanNumerals {
    // Performance can be greatly improved! (Page 22)
    /* A Pattern instance is internally created and garbage collected, which is expensive.
     * Pattern instance is compiled to a finite state machine.
     */
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // Reusing expensive object for improved performance (Page 23)
    /* Regular expression is explicitly compiled into an immutable pattern instance. */
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    /* ROMAN object instance is reused here. */
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int numReps = Integer.parseInt(args[1]);
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");  // Change Slow to Fast to see performance difference
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // Prevents VM from optimizing away everything.
        if (!b)
            System.out.println();
    }
}

