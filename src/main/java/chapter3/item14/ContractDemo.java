package chapter3.item14;

// Implementing Comparable to compare objects based on the 'age' field.
// Java record used to remove boilerplate code.
record ComparingClass(String name, int age) implements Comparable<ComparingClass> {
    // compareTo method compares the 'age' of the current object with another ComparingClass object.
    @Override
    public int compareTo(ComparingClass otherObject) {
        if (otherObject == null) {
            throw new ClassCastException("Cannot compare ComparingClass to " + otherObject + ".");
        }

        // Compare by age
        return Integer.compare(this.age, otherObject.age); // returns negative, 0, or positive.
    }

}

public class ContractDemo {
    public static void main(String[] args) {
        // Create objects of ComparingClass
        ComparingClass Kant = new ComparingClass("Kant", 79);
        ComparingClass Wittgenstein = new ComparingClass("Wittgenstein", 62);
        ComparingClass Hegel = new ComparingClass("Hegel", 79); // He really died at 61, lol.

        // Compare objects
        System.out.println("Comparing Kant and Wittgenstein -> " + Kant.compareTo(Wittgenstein));  // Kant older than Wittgenstein
        System.out.println("Comparing Wittgenstein and Kant -> " + Wittgenstein.compareTo(Kant));  // Wittgenstein is younger than Kant
        System.out.println("Comparing Kant and Hegel -> " + Kant.compareTo(Hegel));  // Kant and Hegel are of same age

        try {
            // Manually triggering ClassCastException by comparing with a null object
            ComparingClass nullPerson = null;
            Kant.compareTo(nullPerson);
        } catch (ClassCastException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
