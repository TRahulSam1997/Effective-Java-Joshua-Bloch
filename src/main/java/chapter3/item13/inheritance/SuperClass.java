package chapter3.item13.inheritance;

public class SuperClass implements Cloneable {
    // Some data fields...
    public SuperClass clone() {
        try {
            return (SuperClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}

class SubClass extends SuperClass {
    // SubClass adds a new field
    private int[] someResource;

    /* The someResource array will be shared between the original and the cloned object,
    leading to potential problems if one of them modifies the array. */

    void test() {
        SubClass subClass = new SubClass();
        // Calling clone() of super class but not behaving as expected.
        subClass.clone();
    }
}
