package Item1.ImmutableValueClass;

public class FooBar {

    /* Constructor is inaccessible. */
    private FooBar() {

    }

    public static FooBar constructFooBar(int number) {
        if (number > 5)
            return new FooBar();
        else
            return null;
    }
}
