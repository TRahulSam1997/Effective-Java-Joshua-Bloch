package chapter3.item12.unconduciveobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * PhoneDirectory holds a list of PhoneEntry instances.
 * Only a summary of the objects are implemented in the toString() method.
 **/
public class PhoneDirectory {
    private String name;
    private List<PhoneEntry> phoneEntries;

    public PhoneDirectory(String name, List<PhoneEntry> phoneEntries) {
        this.name = name;
        this.phoneEntries = phoneEntries;
    }

    /** The phone entries themselves are left out. **/
    @Override
    public String toString() {
        return "PhoneDirectory[" + name + ", " + phoneEntries.size() + " listings]";
    }

    /** Nested class representing a phone entry. **/
    public static class PhoneEntry {
        private String fullName;
        private String phoneNumber;

        public PhoneEntry(String fullName, String phoneNumber) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "PhoneEntry[fullName=" + fullName + ", phoneNumber=" + phoneNumber + "]";
        }
    }

    public static void main(String[] args) {
        PhoneEntry phoneEntry1 = new PhoneEntry("Kierkegaard", "000 000 0001");
        PhoneEntry phoneEntry2 = new PhoneEntry("Nietzsche", "000 000 0002");
        PhoneEntry phoneEntry3 = new PhoneEntry("Sartre", "000 000 0069");

        List<PhoneEntry> phoneEntryList = new ArrayList<>();

        phoneEntryList.add(phoneEntry1);
        phoneEntryList.add(phoneEntry2);
        phoneEntryList.add(phoneEntry3);

        PhoneDirectory phoneDirectory = new PhoneDirectory("The existentialists", phoneEntryList);

        /** Returns only the necessary details of the object apt for representation. **/
        System.out.println("phoneEntry1 -> " + phoneEntry1);
        System.out.println("phoneEntry2 -> " + phoneEntry2);
        System.out.println("phoneEntry3 -> " + phoneEntry3);

        System.out.println("phoneDirectory -> " + phoneDirectory);
    }
}

