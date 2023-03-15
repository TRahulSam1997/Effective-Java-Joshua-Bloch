package chapter3.item12;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item12/PhoneNumber.java
 * Adding a toString method to PhoneNumber (page 52)
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
        if (!(o instanceof chapter3.item11.PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * Returns the string representation of this phone number.
     * The string consists of twelve characters whose format is
     * "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the
     * prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single decimal digit.
     *
     * If any of the three parts of this phone number is too small
     * to fill up its field, the field is padded with leading zeros.
     * For example, if the value of the line number is 123, the last
     * four characters of the string representation will be "0123".
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    public static void main(String[] args) {
        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
//        System.out.println("Jenny's number: " + jenny);

        System.out.println("Inherited toString for PhoneNumber from Object -> " + jenny);
    }
}

class MyComponent {
    private PhoneNumber phoneNumber;

    public MyComponent() {
        phoneNumber = new PhoneNumber(707, 867, 5309);
    }

    public static void main(String[] args) {
        MyComponent myComponent = new MyComponent();

        try {
            throw new Exception();
        } catch (Exception e) {
            /** Log the error message, including a string representation of the Person object. */
            System.err.println("An error occurred with the phoneNumber -> " + myComponent.phoneNumber);
        }
    }
}

class CollectionsExample {

    public static void main(String[] args) {
        HashMap<String, PhoneNumber> collectionsExampleHashSet = new HashMap<>();
        collectionsExampleHashSet.put("Žižek", new PhoneNumber(707, 867, 5309));

        System.out.println(collectionsExampleHashSet);
    }
}