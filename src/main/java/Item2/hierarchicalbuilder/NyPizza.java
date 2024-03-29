package Item2.hierarchicalbuilder;

import java.util.Objects;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item2/hierarchicalbuilder/NyPizza.java
 * Subclass with hierarchical builder (Page 15)
 */
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    /* The proper subtype of this class is passed as the generic parameter. */
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        /* Build method returns the correct subclass. */
        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        /* Returns an instance of the subclass, not Pizza. */
        @Override protected Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return "New York Pizza with " + toppings;
    }
}
