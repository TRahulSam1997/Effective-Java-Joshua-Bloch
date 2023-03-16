package chapter3.item12.valueclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PhoneNumber {
    private final int areaCode;
    private final int prefix;
    private final int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    /**
     * Returns the string representation of the phone number in the format (AAA) PPP-LLLL,
     * where AAA is the area code, PPP is the prefix, and LLLL is the line number.
     * Example: (123) 456-7890
     */
    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    /**
     * Parses a phone number from the specified string.
     * The string must be in the format (AAA) PPP-LLLL, where AAA is the area code,
     * PPP is the prefix, and LLLL is the line number.
     * Example: (123) 456-7890
     *
     * @param phoneNumberStr the string to parse
     * @return the PhoneNumber instance
     * @throws IllegalArgumentException if the string is not in the correct format
     */
    public static PhoneNumber fromString(String phoneNumberStr) {
        // Regular expression pattern for the phone number format
        Pattern pattern = Pattern.compile("\\((\\d{3})\\) (\\d{3})-(\\d{4})");
        Matcher matcher = pattern.matcher(phoneNumberStr);

        if (matcher.matches()) {
            int areaCode = Integer.parseInt(matcher.group(1));
            int prefix = Integer.parseInt(matcher.group(2));
            int lineNumber = Integer.parseInt(matcher.group(3));
            return new PhoneNumber(areaCode, prefix, lineNumber);
        } else {
            throw new IllegalArgumentException("Invalid phone number format: " + phoneNumberStr);
        }
    }

    public String getAreaCode() {
        return String.valueOf(areaCode);
    }

    public String getPrefix() {
        return String.valueOf(prefix);
    }

    public String getLineNumber() {
        return String.valueOf(lineNumber);
    }
}

class Client {
    public static void main(String[] args) {
        // Create a PhoneNumber object
        PhoneNumber phoneNumber = new PhoneNumber(123, 456, 7890);

        // Use the PhoneNumber object
        System.out.println("Area code: " + phoneNumber.getAreaCode());
        System.out.println("Prefix: " + phoneNumber.getPrefix());
        System.out.println("Line number: " + phoneNumber.getLineNumber());

        // Convert the PhoneNumber object to a string representation
        String phoneNumberString = phoneNumber.toString();
        System.out.println("Phone number string: " + phoneNumberString);

        // Convert the string representation back to a PhoneNumber object
        PhoneNumber parsedPhoneNumber = PhoneNumber.fromString(phoneNumberString);
        System.out.println("Parsed phone number: " + parsedPhoneNumber);
    }
}
