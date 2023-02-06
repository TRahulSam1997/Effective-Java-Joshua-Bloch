package chapter3.item11;
import java.util.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item11/PhoneNumber.java
 * Shows the need for overriding hashcode when you override equals (Pages 50-53 )
 */
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


    /** Broken with no hashCode; works with any of the three below. */

    /** Typical hashCode method (Page 52). */
//    @Override public int hashCode() {
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

    /**
     * One-line hashCode method - mediocre performance  (page 53).
     * Recommended for use only in situations where performance is not critical.
     */
//    @Override public int hashCode() {
//        /**
//         * The hash() static method takes arbitrary number of objects
//         * and returns a hash code for them.
//         * Runs slowly as entails array creation to pass
//         * a varying number of arguments - also involves autoboxing.
//         * */
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    /**
     * hashCode method with lazily initialized cached hash code  (page 53).
     * Apt for immutable classes with expensive hash code calculation.
     */

    /** Automatically initialized to 0. */
//    private int hashCode;
//
//    @Override public int hashCode() {
//        /** Lazy initialization. */
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        /** If cached directly returns result. */
//        return result;
//    }

    public static void main(String[] args) {
        /** Instances of PhoneNumber will be used keys. */
        Map<PhoneNumber, String> m = new HashMap<>();
        /**
         * If hashCode() is not overridden results in unequal hash codes,
         * as two PhoneNumber instances are involved:
         * one is used for insertion into the HashMap,
         * and a second, equal instance is used for (attempted) retrieval.
         */
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}