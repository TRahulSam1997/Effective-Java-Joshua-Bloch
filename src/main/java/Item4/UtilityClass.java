package Item4;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item4/UtilityClass.java
 * Noninstantiable utility class (Page 19)
 */

public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        /* This will throw an error. */
        UtilityClass utilityClass = new UtilityClass();
    }

}