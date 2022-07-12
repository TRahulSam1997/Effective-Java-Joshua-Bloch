package item1;

import org.apache.commons.lang3.RandomStringUtils;

public class ManupulateStrings {
    String appendThis;

    /* The traditional way for a class to allow a client to obtain an instance is to provide a public constructor. */
    public ManupulateStrings(String appendThis) {
        this.appendThis = appendThis;
    }

    /* A class can provide a public static factory method, which is simply a static method that returns an instance of the class. */
    public static String getAppendedString(String passedStr) {
        return  passedStr + " Appended random String is " + RandomStringUtils.randomAlphanumeric(10);
    }

    /* Example from the book. */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    String appending() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        StringBuilder sb1 = new StringBuilder(generatedString);
        return appendThis + " Appended random String is " + sb1;
    }
}
