package Item7;

import java.util.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item7/Stack.java
 * Can you spot the "memory leak"?  (Pages 26-27)
 */
public class Stack {
    private Object[] elements;
    private int size = 0;

    /** Initial Stack capacity. */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /** Constructor creates Object instance. */
    public Stack() {
        /** Object array is initialised with DEFAULT_INITIAL_CAPACITY of 26 and assigned to elements. */
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /** Garbage collection doesn't take place in this version. */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        /** An object is unintentionally retained here despite the client of this class having no use of those objects. */
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    /**
     * Corrected version of pop method (Page 27).
     * Once an object is "popped" off the stack it becomes obsolete.
     */
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.out.println(stack.pop());
    }
}