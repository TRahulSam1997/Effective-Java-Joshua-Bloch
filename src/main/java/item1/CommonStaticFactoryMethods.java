package item1;

import java.lang.StackWalker.StackFrame;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

//class Rank{ }
enum Rank {
    JACK,
    QUEEN,
    KING
}

public class CommonStaticFactoryMethods {
    private static final Rank JACK = null;
    private static final Rank QUEEN = null;
    private static final Rank KING = null;

    public static void main(String[] args) {
        /* A type-conversion method. */
        Instant inst = Instant.now();
        Date date = Date.from(inst);
        System.out.println("date -> " + date);

        /* An aggregation method. */
        Set<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
        System.out.println("faceCards -> " + faceCards);

        /* A verbose alternative to from and of. */
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println("prime -> " + prime);

        /* A quasi-demo for getInstance(). */
        StackWalkerDemo stackWalkerDemo = new StackWalkerDemo();
        stackWalkerDemo.methodThree();
    }
}

/*
 * Example courtesy of Baeldung.
 * StackWalkerDemo has a chain of method calls.
 */
class StackWalkerDemo {
    public void methodOne() {
        this.methodTwo();
    }

    public void methodTwo() {
        this.methodThree();
    }

    /*
     * In this example, getInstance() returns an instance of StackWalker
     * which specifies the calling class of the method invocation.
    */
    public void methodThree() {
        Class<?> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass();

        System.out.println("callerClass -> " + callerClass);
    }
}
