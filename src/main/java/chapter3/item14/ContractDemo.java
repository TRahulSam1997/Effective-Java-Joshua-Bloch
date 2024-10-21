package chapter3.item14;

// Implementing Comparable to compare objects based on the 'age' field.
// Java record used to remove boilerplate code.
record Philosopher(String name, int age) implements Comparable<Philosopher> {
    // compareTo method compares the 'age' of the current object with another Philosopher object.
    @Override
    public int compareTo(Philosopher otherObject) {
        if (otherObject == null) {
            throw new ClassCastException("Cannot compare Philosopher to " + otherObject + ".");
        }

        // Compare by age
        return Integer.compare(this.age, otherObject.age); // returns negative, 0, or positive.
    }

}

public class ContractDemo {
    public static void main(String[] args) {
        // Create objects of Philosopher
        Philosopher Kant = new Philosopher("Kant", 79);
        Philosopher Wittgenstein = new Philosopher("Wittgenstein", 62);
        Philosopher Hegel = new Philosopher("Hegel", 79); // He really died at 61, lol.

        // Compare objects
        System.out.println("Comparing Kant and Wittgenstein -> " + Kant.compareTo(Wittgenstein));  // Kant older than Wittgenstein
        System.out.println("Comparing Wittgenstein and Kant -> " + Wittgenstein.compareTo(Kant));  // Wittgenstein is younger than Kant
        System.out.println("Comparing Kant and Hegel -> " + Kant.compareTo(Hegel));  // Kant and Hegel are of same age

        try {
            // Manually triggering ClassCastException by comparing with a null object
            Philosopher nullPerson = null;
            Kant.compareTo(nullPerson);
        } catch (ClassCastException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
