package Item1;

/*
* CHAPTER 2: Creating and Destroying Objects
* ITEM 1: Consider static factory methods instead of constructors
*/

import java.util.EnumSet;
import java.util.Random;

enum Color {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

public class Main {
    public static void main(String[] args) {
//        System.out.println("value Of -> " + ManupulateStrings.valueOf(true));

        /* Object creation. */
        ManupulateStrings ms = new ManupulateStrings("item 1");
//        System.out.println("With public constructor -> " + ms.appending());

        /* No object created. */
//        System.out.println("With static factory method -> " + ManupulateStrings.getAppendedString("item 1"));

        /* Example #2 from the book. */
        Random rnd = new Random();
//        System.out.println("ProbablePrime from BigInteger -> " + BigInteger.probablePrime(3, rnd));

        /* Example #1 doesn't create an object. */
//        System.out.println("valueOf from ManipulateStrings -> " + ManupulateStrings.valueOf(false));

        /* Example for advantage 4 courtesy of Baeldung. */
        EnumSet enumSet = EnumSet.noneOf(Color.class);
        System.out.println("Class name -> " + enumSet.getClass());

    }
}
