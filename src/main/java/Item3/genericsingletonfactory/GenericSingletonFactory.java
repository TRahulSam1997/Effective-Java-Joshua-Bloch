package Item3.genericsingletonfactory;

import java.util.function.UnaryOperator;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter5/item30/GenericSingletonFactory.java
 * Generic singleton factory pattern from Item 30 (Page 136-7)
 */
public class GenericSingletonFactory {
    // Generic singleton factory pattern
    /* Object is the superclass for all the classes, therefore all types passed will be a subtype. */
    private static final UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        /* Can be used without casts. */
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();
        System.out.println("Same object for UnaryOperator<String> -> " + sameString);
        for (String s : strings) {
            // Applying the function to get the result
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        System.out.println("Same object for UnaryOperator<Number> -> " + sameNumber);
        for (Number n : numbers) {
            // Applying the function to get the result
            System.out.println(sameNumber.apply(n));
        }
    }
}
