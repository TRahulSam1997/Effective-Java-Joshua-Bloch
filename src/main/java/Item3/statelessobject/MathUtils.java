package Item3.statelessobject;

import java.math.BigInteger;

public class MathUtils {

    /* Example courtesy of Baeldung.
     * The factorial() method is a stateless deterministic function.
     * The method neither relies on external state nor maintains state at all.
     * So, it's considered to be thread-safe and can be safely called by multiple threads at the same time.
     */
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
