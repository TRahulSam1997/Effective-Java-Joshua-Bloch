package Item2.hierarchicalbuilder;
import java.util.*;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item2/hierarchicalbuilder/Pizza.java
 * Builder pattern for class hierarchies (Page 14)
 * Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders
 */
public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    /* Allows simulated self-type. */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        /* Overriding this method allows subclasses to get an instance of their own type. */
        protected abstract T self();
    }

    /* The generic, recursive type parameter is necessary for method chaining to work. */
    Pizza(Builder<?> builder) {
        /* Defensive copy been made to ensure encapsulation isn't broken.
         * When the native class changes a mutable object's field, a defensive copy should be made any time it's passed into a constructor like this or out of the class.
         */
        toppings = builder.toppings.clone(); // See Item 50
    }
}