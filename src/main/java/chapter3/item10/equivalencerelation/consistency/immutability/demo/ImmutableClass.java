package chapter3.item10.equivalencerelation.consistency.immutability.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Example courtesy of ChatGPT.
 */

/**
 * Make the class final so that it cannot be subclassed.
 * This will prevent any subclass from modifying the state of the immutable class.
 */
public final class ImmutableClass {
    /**
     * Declare all fields as private and final.
     * This will prevent any code outside the class from modifying the fields directly.
     */
    private final int field1;
    private final String field2;
    private final List<String> field3;

    /**
     * Make the class's constructor private.
     * This will prevent any code outside the class from creating an instance of the immutable class.
     */
    private ImmutableClass(int field1, String field2, List<String> field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = new ArrayList<>(field3);
    }

    public static ImmutableClass create(int field1, String field2, List<String> field3) {
        return new ImmutableClass(field1, field2, field3);
    }

    /**
     * Don't provide any setter methods for the fields.
     * This will ensure that the fields cannot be modified once they are set in the constructor.
     */
    public int getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    /**
     * If the class has any mutable fields, make a deep copy of those fields in the constructor and assign the copied values to the private final fields.
     * This will ensure that the internal state of the immutable class cannot be modified.
     */
    public List<String> getField3() {
        return new ArrayList<>(field3);
    }

    /**
     * In Java, a deep copy is a copy of an object that creates a new object with a new memory address,
     * and recursively copies the contents of the original object to the new object.
     * This means that the new object is completely independent of the original object,
     * and any changes made to the new object do not affect the original object.
     */
}