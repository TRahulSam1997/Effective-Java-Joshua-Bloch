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
        ComparingClass alice = new ComparingClass("Alice", 30);
        ComparingClass bob = new ComparingClass("Bob", 25);
        ComparingClass charlie = new ComparingClass("Charlie", 30);

        // Compare objects
        System.out.println("Comparing Alice and Bob -> " + alice.compareTo(bob));  // Alice older than Bob
        System.out.println("Comparing Bob and Alice -> " + bob.compareTo(alice));  // Bob is younger than Alice
        System.out.println("Comparing Alice and Charlie -> " + alice.compareTo(charlie));  // Alice and Charlie are of same age

        try {
            // Manually triggering ClassCastException by comparing with a null object
            ComparingClass nullPerson = null;
            alice.compareTo(nullPerson);
        } catch (ClassCastException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
