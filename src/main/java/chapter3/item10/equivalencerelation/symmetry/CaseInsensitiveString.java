package chapter3.item10.equivalencerelation.symmetry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item10/CaseInsensitiveString.java
 * CaseInsensitiveString implements a case-insensitive string.
 * Broken - violates symmetry!  (Page 39)
 * Case is preserved by toString() but ignored by equals().
 */
public final class CaseInsensitiveString {
    private final String s;
    private final String CanonicalS;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
        /** Canonical string is used by equals method */
        this.CanonicalS = convertToCanonicalForm(Objects.requireNonNull(s));
    }

    /** Broken - Overridden equals() method violates symmetry! */
//    @Override public boolean equals(Object o) {
//        /** Returns true if object is an instance of CaseInsensitiveString
//         * and is equals to string s (declared above) but ignores the case of the characters. */
//        if (o instanceof CaseInsensitiveString)
//            /** After casting the field s is accessed from the object of typeCaseInsensitiveString. */
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//
//        /** One-way interoperability! */
//        if (o instanceof String)
//            return s.equalsIgnoreCase((String) o);
//        return false;
//    }

    private String convertToCanonicalForm(String s) {
        /** Convert the input string to standard case. */
        return s.toLowerCase();
    }

    /** Demonstration of the problem (Page 40) */
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("polish");
        String s = "polish";

        /** Returns true as expected. */
        System.out.println(cis.equals(s));

        /** Returns false making it a clear violation of symmetry. */
        System.out.println(s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        /** We'd expect the contains() to return true given it's case-insensitive but returns false. */
        System.out.println(list.contains(s));

        /** Only works for newCaseInsensitiveString type. */
        CaseInsensitiveString newCaseInsensitiveString = new CaseInsensitiveString("Polish");
        System.out.println(cis.equals(newCaseInsensitiveString));
        System.out.println(newCaseInsensitiveString.equals(cis));
    }

    /** Fixed equals method (Page 40) */
    @Override public boolean equals(Object o) {
    /** After casting the field s is accessed from the object of typeCaseInsensitiveString. */
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).CanonicalS.equalsIgnoreCase(CanonicalS);
    }
}